package repository;

import model.Paciente;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class PacienteRepository extends Repository<Paciente> {
    private String ruta = "data/pacientes.txt";

    public PacienteRepository() {
        super();
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Paciente paciente) {
        datos.add(paciente);
        guardarEnArchivo();
    }

    public Paciente buscarPorId(int id) {
        for (Paciente p : datos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Paciente buscarPorDni(String dni) {
        for (Paciente p : datos) {
            if (p.getDni().equals(dni)) return p;
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {            
            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (Paciente p : datos) {
                writer.println(p.getId() + ";" + p.getNombre() + ";" + p.getDni() + ";" + p.getTelefono());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("error al guardar pacientes: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                Paciente p = new Paciente(id, partes[1], partes[2], partes[3]);
                datos.add(p);

            }
            reader.close();
        } catch (Exception e) {
            System.out.println("error al leer pacientes: " + e.getMessage());
        }
    }
}
