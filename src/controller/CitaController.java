package controller;

import model.Cita;
import model.Odontologo;
import model.Paciente;
import repository.CitaRepository;
import repository.OdontologoRepository;
import repository.PacienteRepository;
import java.util.ArrayList;

public class CitaController {
    private CitaRepository citaRepository;
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;

    public CitaController(CitaRepository citaRepository,
                          PacienteRepository pacienteRepository,
                          OdontologoRepository odontologoRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return odontologoRepository.listar();
    }

    public ArrayList<Odontologo> buscarDisponibles(String especialidad,
                                                    String fecha,
                                                    String hora) {
        ArrayList<Odontologo> disponibles = new ArrayList<>();

        for (Odontologo odontologo : odontologoRepository.listar()) {
            boolean mismaEspecialidad = odontologo.getEspecialidad()
                    .equalsIgnoreCase(especialidad);
            boolean horarioLibre = citaRepository.horarioDisponible(
                    odontologo.getId(), fecha, hora);

            if (mismaEspecialidad && horarioLibre) {
                disponibles.add(odontologo);
            }
        }

        return disponibles;
    }

    public String programarCita(int idCita, String dniPaciente,
                                int idOdontologo, String fecha, String hora) {
        if (idCita <= 0 || dniPaciente.trim().equals("") ||
                fecha.trim().equals("") || hora.trim().equals("")) {
            return "Los datos de la cita no son válidos.";
        }

        if (citaRepository.buscarPorId(idCita) != null) {
            return "Ya existe una cita con ese ID.";
        }

        Paciente paciente = pacienteRepository.buscarPorDni(dniPaciente);
        if (paciente == null) {
            return "No se encontró un paciente con ese DNI.";
        }

        Odontologo odontologo = odontologoRepository.buscarPorId(idOdontologo);
        if (odontologo == null) {
            return "No se encontró el odontólogo.";
        }

        if (!citaRepository.horarioDisponible(idOdontologo, fecha, hora)) {
            return "El horario ya está ocupado.";
        }

        Cita cita = new Cita(idCita, paciente, odontologo, fecha, hora);
        citaRepository.agregar(cita);
        return "Cita registrada correctamente.";
    }

    public String cancelarCita(int idCita) {
        Cita cita = citaRepository.buscarPorId(idCita);

        if (cita == null) {
            return "No se encontró la cita.";
        }

        if (cita.getEstado().equals("CANCELADA")) {
            return "La cita ya estaba cancelada.";
        }

        cita.cancelar();
        return "Cita cancelada correctamente.";
    }

    public ArrayList<Cita> listarCitas() {
        return citaRepository.listar();
    }
}
