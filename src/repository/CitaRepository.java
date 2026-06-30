package repository;

import model.Cita;
import model.Odontologo;
import model.Paciente;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class CitaRepository extends Repository<Cita> {
    private String ruta = "data/citas.txt";
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;

    public CitaRepository(PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository) {
        super();
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
        cargarDesdeArchivo();
    }

    @Override
    public void agregar(Cita cita) {
        datos.add(cita);
        guardarEnArchivo();
    }

    public Cita buscarPorId(int id) {
        for (Cita c : datos) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public boolean horarioDisponible(int idOdontologo, String fecha, String hora) {
        for (Cita c : datos) {
            boolean mismoOdontologo = c.getOdontologo().getId() == idOdontologo;
            boolean mismaFecha = c.getFecha().equals(fecha);
            boolean mismaHora = c.getHora().equals(hora);
            boolean activa = c.getEstado().equals("PROGRAMADA");
            if (mismoOdontologo && mismaFecha && mismaHora && activa) return false;
        }
        return true;
    }

    public void guardarCambios() {
        guardarEnArchivo();
    }

    private void guardarEnArchivo() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) carpeta.mkdir();

            PrintWriter writer = new PrintWriter(new FileWriter(ruta));
            for (Cita c : datos) {
                writer.println(c.getId() + ";" + c.getPaciente().getDni() + ";" +
                        c.getOdontologo().getId() + ";" + c.getFecha() + ";" + c.getHora() + ";" + c.getEstado());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar citas: " + e.getMessage());
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
                if (partes.length == 6) {
                    Paciente paciente = pacienteRepository.buscarPorDni(partes[1]);
                    Odontologo odontologo = odontologoRepository.buscarPorId(Integer.parseInt(partes[2]));
                    if (paciente != null && odontologo != null) {
                        Cita cita = new Cita(Integer.parseInt(partes[0]), paciente, odontologo, partes[3], partes[4]);
                        if (partes[5].equals("CANCELADA")) cita.cancelar();
                        datos.add(cita);
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer citas: " + e.getMessage());
        }
    }
}