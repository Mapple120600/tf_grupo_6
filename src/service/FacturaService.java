package service;

import java.util.ArrayList;
import model.Factura;
import model.Paciente;
import repository.FacturaRepository;
import repository.PacienteRepository;

public class FacturaService {
    private FacturaRepository facturaRepository;
    private PacienteRepository pacienteRepository;
    private AuditoriaService auditoriaService;

    public FacturaService(FacturaRepository facturaRepository, PacienteRepository pacienteRepository, AuditoriaService auditoriaService) {
        this.facturaRepository = facturaRepository;
        this.pacienteRepository = pacienteRepository;
        this.auditoriaService = auditoriaService;
    }

    public String registrarFactura(int id, String dni, double total, String fecha) {
        Paciente paciente = pacienteRepository.buscarPorDni(dni);
        if (paciente == null) return "Paciente no encontrado";
        facturaRepository.agregar(new Factura(id, paciente, total, fecha));
        auditoriaService.registrarAccion("Se genero una factura para " + paciente.getNombre());
        return "Factura registrada correctamente";
    }

    public void agregar(Factura objeto) {
        facturaRepository.agregar(objeto);
    }

    public ArrayList<Factura> listar() {
        return facturaRepository.listar();
    }
