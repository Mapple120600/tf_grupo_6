package repository;

import model.Pago;
import model.Paciente;
import java.io.*;

public class PagoRepository extends Repository<Pago> {
    private String ruta = "data/pagos.txt";
    private PacienteRepository pacienteRepository;

    public PagoRepository(PacienteRepository pacienteRepository) {
        super();
        this.pacienteRepository = pacienteRepository;
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Pago pago) {
        datos.add(pago);
        guardarEnArchivo();
    }

    public Pago buscarPorId(int id) {
        for (Pago p : datos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) carpeta.mkdir();

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (Pago p : datos) {
                writer.println(p.getId() + ";" + p.getPaciente().getDni() + ";" + p.getMonto() + ";" + p.getMetodo() + ";" + p.getFecha());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar pagos: " + e.getMessage());
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
                if (partes.length == 5) {
                    Paciente paciente = pacienteRepository.buscarPorDni(partes[1]);
                    if (paciente != null) {
                        datos.add(new Pago(Integer.parseInt(partes[0]), paciente, Double.parseDouble(partes[2]), partes[3], partes[4]));
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer pagos: " + e.getMessage());
        }
    }
}