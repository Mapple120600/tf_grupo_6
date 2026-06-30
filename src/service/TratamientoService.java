package service;

import java.util.ArrayList;
import model.Odontologo;
import model.Paciente;
import model.Tratamiento;
import repository.OdontologoRepository;
import repository.PacienteRepository;
import repository.TratamientoRepository;

public class TratamientoService {

    private TratamientoRepository tratamientoRepository;
    private PacienteRepository pacienteRepository;
    private OdontologoRepository odontologoRepository;
    private AuditoriaService auditoriaService;

    public TratamientoService(
            TratamientoRepository tratamientoRepository,
            PacienteRepository pacienteRepository,
            OdontologoRepository odontologoRepository,
            AuditoriaService auditoriaService) {

        this.tratamientoRepository = tratamientoRepository;
        this.pacienteRepository = pacienteRepository;
        this.odontologoRepository = odontologoRepository;
        this.auditoriaService = auditoriaService;
    }

    public String registrarTratamiento(
            int id,
            String dni,
            int idOdontologo,
            String nombre,
            double costo) {

        Paciente paciente = pacienteRepository.buscarPorDni(dni);
        Odontologo odontologo = odontologoRepository.buscarPorId(idOdontologo);

        if (paciente == null) {
            return "Paciente no encontrado";
        }

        if (odontologo == null) {
            return "Odontólogo no encontrado";
        }

        tratamientoRepository.agregar(
                new Tratamiento(
                        id,
                        paciente,
                        odontologo,
                        nombre,
                        costo));

        auditoriaService.registrarAccion(
                "Se registro un tratamiento para " + paciente.getNombre());

        return "Tratamiento registrado";
    }

    public ArrayList<Tratamiento> listarTratamientos() {
        return tratamientoRepository.listar();
    }

}