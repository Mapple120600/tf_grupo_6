package repository;

import model.HistoriaClinica;
import model.Paciente;
import java.io.*;

public class HistoriaClinicaRepository extends Repository<HistoriaClinica> {

    private String ruta = "data/historias.txt";
    private PacienteRepository pacienteRepository;

    public HistoriaClinicaRepository(PacienteRepository pacienteRepository) {
        super();
        this.pacienteRepository = pacienteRepository;
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(HistoriaClinica historia) {
        datos.add(historia);
        guardarEnArchivo();
    }

    public HistoriaClinica buscarPorId(int id) {
        for (HistoriaClinica h : datos) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");

            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));

            for (HistoriaClinica h : datos) {
                writer.println(
                    h.getId() + ";" +
                    h.getPaciente().getDni() + ";" +
                    h.getAntecedentes() + ";" +
                    h.getObservaciones()
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error al guardar historias: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(";");

                if (partes.length == 4) {

                    Paciente paciente = pacienteRepository.buscarPorDni(partes[1]);

                    if (paciente != null) {
                        datos.add(
                            new HistoriaClinica(
                                Integer.parseInt(partes[0]),
                                paciente,
                                partes[2],
                                partes[3]
                            )
                        );
                    }
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error al leer historias: " + e.getMessage());
        }
    }
}