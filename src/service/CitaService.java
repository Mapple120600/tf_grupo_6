package service;

import model.Cita;
import model.Odontologo;
import model.Paciente;
import observer.CitaEventManager;
import repository.CitaRepository;
import repository.OdontologoRepository;
import repository.PacienteRepository;
import java.util.ArrayList;

public class CitaService {
    
    private CitaRepository citaRepository;
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;
    private CitaEventManager eventManager;
    private AuditoriaService auditoriaService;

    public CitaService(CitaRepository citaRepository, PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository, CitaEventManager eventManager, AuditoriaService auditoriaService) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
        this.eventManager = eventManager;
        this.auditoriaService = auditoriaService;
    }

    public String programarCita(int id, String dniPaciente, int idOdontologo, String fecha, String hora) {
        Paciente paciente = pacienteRepository.buscarPorDni(dniPaciente);

        if (paciente == null) {
            return "no existe un paciente con ese dni";
        }

        Odontologo odontologo = odontologoRepository.buscarPorId(idOdontologo);

        if (odontologo == null) {
            return "no existe un odontologo con ese id";
        }

        if (!citaRepository.horarioDisponible(idOdontologo, fecha, hora)) {
            return "el odontolgo no esta disponible en ese horario";
        }

        Cita cita = new Cita(id, paciente, odontologo, fecha, hora);
        citaRepository.agregar(cita);
        auditoriaService.registrarAccion("Se programo una cita para " + paciente.getNombre());
        eventManager.notificar(cita, "PROGRAMADA");
        return "Cita programada correctamente";
    }

    public String cancelarCita(int id) {
        Cita cita = citaRepository.buscarPorId(id);

        if (cita == null) {
            return "no se encontro la cita";
        }

        cita.cancelar();
        citaRepository.guardarCambios();
        auditoriaService.registrarAccion("Se cancelo la cita ID " + id);
        eventManager.notificar(cita, "CANCELADA");
        return "Cita cancelada";
    }

    public ArrayList<Cita> listarCitas() { 
        return citaRepository.listar(); 
    }
}
