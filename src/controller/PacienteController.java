package controller;

import model.Paciente;
import service.PacienteService;
import java.util.ArrayList;

public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public String registrarPaciente(int id, String nombre, String dni, String telefono) {
        return pacienteService.registrarPaciente(id, nombre, dni, telefono);
    }

    public Paciente buscarPorDni(String dni) {
        return pacienteService.buscarPorDni(dni);
    }

    public ArrayList<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }
}