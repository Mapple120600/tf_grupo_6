package repository;

import model.MaterialDental;
import java.io.*;

public class MaterialRepository extends Repository<MaterialDental> {
    private String ruta = "data/materiales.txt";

    public MaterialRepository() {
        super();
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(MaterialDental material) {
        datos.add(material);
        guardarEnArchivo();
    }

    public MaterialDental buscarPorId(int id) {
        for (MaterialDental m : datos) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) carpeta.mkdir();

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (MaterialDental m : datos) {
                writer.println(m.getId() + ";" + m.getNombre() + ";" + m.getStock() + ";" + m.getUnidad());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar materiales: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        File archivo = new File(ruta);
        if (!archivo.exists()) return;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    datos.add(new MaterialDental(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]), partes[3]));
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer materiales: " + e.getMessage());
        }
    }
}