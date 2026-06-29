package service;

import model.Paciente;
import repository.PacienteRepository;

import java.util.ArrayList;

public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public String registrarPaciente(int id, String nombre, String dni, String telefono) {
        if (id <= 0) {
            return "el ID debe ser mayor que cero";
        }

        if (nombre == null || nombre.trim().equals("")) {
            return "el nombre del paciente es obligatorio";
        }

        if (dni == null || dni.trim().equals("")) {
            return "el dni del paciente es obligatorio";
        }

        if (telefono == null || telefono.trim().equals("")) {
            return "el telefono del paciente es obligatorio";
        }

        Paciente pacienteEncontrado = pacienteRepository.buscarPorDni(dni);

        if (pacienteEncontrado != null) {
            return "ya existe un paciente con ese DNI";
        }

        Paciente paciente = new Paciente(id, nombre, dni, telefono);
        boolean registrado = pacienteRepository.agregar(paciente);

        if (registrado) {
            return "paciente registrado correctamente";
        } else {
            return "no se pudo registrar el paciente";
        }
    }

    public Paciente buscarPorDni(String dni) {
        return pacienteRepository.buscarPorDni(dni);
    }

    public ArrayList<Paciente> listarPacientes() {
        return pacienteRepository.listar();
    }
}
