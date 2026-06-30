package repository;

import model.Tratamiento;
import model.Paciente;
import model.Odontologo;
import java.io.*;

public class TratamientoRepository extends Repository<Tratamiento> {

    private String ruta = "data/tratamientos.txt";
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;

    public TratamientoRepository(
            PacienteRepository pacienteRepository,
            OdontologoRepository odontologoRepository) {

        super();
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;

        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Tratamiento tratamiento) {
        datos.add(tratamiento);
        guardarEnArchivo();
    }

    public Tratamiento buscarPorId(int id) {
        for (Tratamiento t : datos) {
            if (t.getId() == id) {
                return t;
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

            for (Tratamiento t : datos) {

                writer.println(
                    t.getId() + ";" +
                    t.getPaciente().getDni() + ";" +
                    t.getOdontologo().getId() + ";" +
                    t.getNombre() + ";" +
                    t.getCosto() + ";" +
                    t.getEstado()
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error al guardar tratamientos: " + e.getMessage());
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

                if (partes.length == 6) {

                    Paciente paciente = pacienteRepository.buscarPorDni(partes[1]);

                    Odontologo odontologo =
                            odontologoRepository.buscarPorId(
                                    Integer.parseInt(partes[2]));

                    if (paciente != null && odontologo != null) {

                        Tratamiento tratamiento = new Tratamiento(
                                Integer.parseInt(partes[0]),
                                paciente,
                                odontologo,
                                partes[3],
                                Double.parseDouble(partes[4])
                        );

                        if (partes[5].equals("FINALIZADO")) {
                            tratamiento.finalizar();
                        }

                        datos.add(tratamiento);
                    }
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error al leer tratamientos: " + e.getMessage());
        }
    }
}