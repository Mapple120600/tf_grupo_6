package controller;

import model.Paciente;
import repository.PacienteRepository;
import java.util.ArrayList;

public class PacienteController {
    private PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public String registrarPaciente(int id, String nombre, String dni, String telefono) {
        if (id <= 0) {
            return "El ID debe ser mayor que cero.";
        }
        if (nombre.trim().equals("") || dni.trim().equals("")) {
            return "El nombre y el DNI son obligatorios.";
        }
        Paciente paciente = new Paciente(id, nombre, dni, telefono);
        boolean resultado = pacienteRepository.agregar(paciente);
        if (resultado) {
            return "Paciente registrado correctamente.";
        } else {
            return "No se pudo registrar. El ID o DNI ya existe.";
        }
    }

    public Paciente buscarPorDni(String dni) {
        return pacienteRepository.buscarPorDni(dni);
    }

    public ArrayList<Paciente> listarPacientes() {
        return pacienteRepository.listar();
    }
}