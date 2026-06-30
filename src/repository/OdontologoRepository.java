package repository;

import model.Odontologo;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class OdontologoRepository extends Repository<Odontologo> {
    private String ruta = "data/odontologos.txt";

    public OdontologoRepository() {
        super();
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Odontologo odontologo) {
        datos.add(odontologo);
        guardarEnArchivo();
    }

    public Odontologo buscarPorId(int id) {
        for (Odontologo o : datos) {
            if (o.getId() == id) return o;
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) carpeta.mkdir();

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (Odontologo o : datos) {
                writer.println(o.getId() + ";" + o.getNombre() + ";" + o.getEspecialidad());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar odontologos: " + e.getMessage());
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
                if (partes.length == 3) {
                    datos.add(new Odontologo(Integer.parseInt(partes[0]), partes[1], partes[2]));
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer odontologos: " + e.getMessage());
        }
    }
}