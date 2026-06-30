package service;

import model.Paciente;
import repository.PacienteRepository;
import util.TextoUtil;
import util.ValidadorDNI;
import java.util.ArrayList;

public class PacienteService {

    private PacienteRepository pacienteRepository;
    private AuditoriaService auditoriaService;

    public PacienteService(PacienteRepository pacienteRepository, AuditoriaService auditoriaService) {
        this.pacienteRepository = pacienteRepository;
        this.auditoriaService = auditoriaService;
    }

     public String registrarPaciente(int id, String nombre, String dni, String telefono) {
        if (id <= 0) return "El ID debe ser mayor que cero";
        if (TextoUtil.estaVacio(nombre)) return "El nombre es obligatorio";
        if (!ValidadorDNI.esValido(dni)) return "El DNI debe tener 8 dígitos";
        if (pacienteRepository.buscarPorDni(dni) != null) return "Ya existe un paciente con ese DNI";
        pacienteRepository.agregar(new Paciente(id, nombre, dni, telefono));
        auditoriaService.registrarAccion("Se registro un paciente: " + nombre);
        return "Paciente registrado correctamente";
    }

    public Paciente buscarPorDni(String dni) { return pacienteRepository.buscarPorDni(dni); }
    public ArrayList<Paciente> listarPacientes() { return pacienteRepository.listar(); }
}
