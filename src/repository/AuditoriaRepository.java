package repository;

import model.Auditoria;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class AuditoriaRepository extends Repository<Auditoria> {
    private String ruta = "data/auditoria.txt";

    public AuditoriaRepository() {
        super();
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Auditoria auditoria) {
        datos.add(auditoria);
        guardarEnArchivo();
    }

    public Auditoria buscarPorId(int id) {
        for (Auditoria a : datos) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) carpeta.mkdir();

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (Auditoria a : datos) {
                writer.println(a.getId() + ";" + a.getAccion() + ";" + a.getUsuario() + ";" + a.getFecha());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar auditoria: " + e.getMessage());
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
                    datos.add(new Auditoria(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3]));
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer auditoria: " + e.getMessage());
        }
    }
}
