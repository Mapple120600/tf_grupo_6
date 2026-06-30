package service;

import java.util.ArrayList;
import model.HistoriaClinica;
import model.Paciente;
import repository.HistoriaClinicaRepository;
import repository.PacienteRepository;

public class HistoriaClinicaService {

    private HistoriaClinicaRepository historiaClinicaRepository;
    private PacienteRepository pacienteRepository;
    private AuditoriaService auditoriaService;

    public HistoriaClinicaService(
            HistoriaClinicaRepository historiaClinicaRepository,
            PacienteRepository pacienteRepository,
            AuditoriaService auditoriaService) {

        this.historiaClinicaRepository = historiaClinicaRepository;
        this.pacienteRepository = pacienteRepository;
        this.auditoriaService = auditoriaService;
    }

    public String registrarHistoria(
            int id,
            String dni,
            String antecedentes,
            String observaciones) {

        Paciente paciente = pacienteRepository.buscarPorDni(dni);

        if (paciente == null) {
            return "Paciente no encontrado";
        }

        historiaClinicaRepository.agregar(
                new HistoriaClinica(
                        id,
                        paciente,
                        antecedentes,
                        observaciones));

        auditoriaService.registrarAccion(
                "Se registro historia clinica de " + paciente.getNombre());

        return "Historia clínica registrada";
    }

    public void agregar(HistoriaClinica objeto) {
        historiaClinicaRepository.agregar(objeto);
    }

    public ArrayList<HistoriaClinica> listar() {
        return historiaClinicaRepository.listar();
    }

}