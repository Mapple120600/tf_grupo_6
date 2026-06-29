package service;

import model.Cita;
import model.Odontologo;
import model.Paciente;
import repository.CitaRepository;
import repository.OdontologoRepository;
import repository.PacienteRepository;
import java.util.ArrayList;

public class CitaService {
    
    private CitaRepository citaRepository;
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;

    public CitaService(CitaRepository citaRepository, PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
    }

    public String programarCita(int idCita, String dniPaciente, int idOdontologo, String fecha, String hora) {
        if (dniPaciente == null || dniPaciente.trim().equals("")) {
            return "el dni del paciente es obligatorio";
        }

        if (fecha == null || fecha.trim().equals("")) {
            return "la fecha de la cita es obligatorio";
        }

        if (hora == null || hora.trim().equals("")) {
            return "la hora de la cita es obligatoria";
        }

        Paciente paciente = pacienteRepository.buscarPorDni(dniPaciente);
        if (paciente == null) {
            return "no existe un paciente con ese dni";
        }

        Odontologo odontologo = odontologoRepository.buscarPorId(idOdontologo);
        if (odontologo == null) {
            return "no existe un odontologo con ese id";
        }

        Cita cita = new Cita(idCita, paciente, odontologo, fecha, hora);
        boolean registrado = citaRepository.agregar(cita);

        if (registrado) {
            return "cita programada correctamente";
        } else {
            return "no se pudo programar la cita";
        }
    }

    public String cancelarCita(int idCita) {
        Cita cita = citaRepository.buscarPorId(idCita);
        cita.cancelar();
        return "cita cancelada correctamente";
    }

    public ArrayList<Cita> listarCitas() {
        return citaRepository.listar();
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return odontologoRepository.listar();
    }

    public ArrayList<Odontologo> buscarOdontologosDisponibles(String especialidad, String fecha, String hora) {
        ArrayList<Odontologo> disponibles = new ArrayList<>();
        ArrayList<Odontologo> odontologos = odontologoRepository.listar();

        for (Odontologo odontologo : odontologos) {
            boolean mismaEspecialidad = odontologo.getEspecialidad().equals(especialidad);
            boolean horarioLibre = citaRepository.horarioDisponible(odontologo.getId(), fecha, hora);

            if (mismaEspecialidad && horarioLibre) {
                disponibles.add(odontologo);
            }
        }

        return disponibles;
    }
}
