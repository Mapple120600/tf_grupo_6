package repository;

import model.Factura;
import model.Paciente;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FacturaRepository extends Repository<Factura> {
    private String ruta = "data/facturas.txt";
    private PacienteRepository pacienteRepository;

    public FacturaRepository(PacienteRepository pacienteRepository) {
        super();
        this.pacienteRepository = pacienteRepository;
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Factura factura) {
        datos.add(factura);
        guardarEnArchivo();
    }

    public Factura buscarPorId(int id) {
        for (Factura f : datos) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) carpeta.mkdir();

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (Factura f : datos) {
                writer.println(f.getId() + ";" + f.getPaciente().getDni() + ";" + f.getTotal() + ";" + f.getFecha());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar facturas: " + e.getMessage());
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
                    Paciente paciente = pacienteRepository.buscarPorDni(partes[1]);
                    if (paciente != null) {
                        datos.add(new Factura(Integer.parseInt(partes[0]), paciente, Double.parseDouble(partes[2]), partes[3]));
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer facturas: " + e.getMessage());
        }
    }
}