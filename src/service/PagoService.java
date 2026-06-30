package service;

import java.util.ArrayList;
import model.Paciente;
import model.Pago;
import repository.PacienteRepository;
import repository.PagoRepository;
import strategy.MetodoPagoStrategy;

public class PagoService {
    private PagoRepository pagoRepository;
    private PacienteRepository pacienteRepository;
    private AuditoriaService auditoriaService;

    public PagoService(PagoRepository pagoRepository, PacienteRepository pacienteRepository, AuditoriaService auditoriaService) {
        this.pagoRepository = pagoRepository;
        this.pacienteRepository = pacienteRepository;
        this.auditoriaService = auditoriaService;
    }

    public String registrarPago(int id, String dni, double monto, String fecha, MetodoPagoStrategy estrategia) {
        Paciente paciente = pacienteRepository.buscarPorDni(dni);
        if (paciente == null) return "Paciente no encontrado";
        pagoRepository.agregar(new Pago(id, paciente, monto, estrategia.getNombre(), fecha));
        auditoriaService.registrarAccion("Se registro un pago de S/ " + monto + " para " + paciente.getNombre());
        return estrategia.pagar(monto);
    }

    public ArrayList<Pago> listarPagos() { return pagoRepository.listar(); }
}
