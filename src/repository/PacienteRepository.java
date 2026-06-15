package repository;

import model.Paciente;
import java.util.ArrayList;

public class PacienteRepository {
    private ArrayList<Paciente> pacientes;

    public PacienteRepository() {
        pacientes = new ArrayList<>();
    }

    public boolean agregar(Paciente paciente) {
        if (buscarPorId(paciente.getId()) != null) {
            return false;
        }
        if (buscarPorDni(paciente.getDni()) != null) {
            return false;
        }
        pacientes.add(paciente);
        return true;
    }

    public Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPorDni(String dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente;
            }
        }
        return null;
    }

    public ArrayList<Paciente> listar() {
        return pacientes;
    }
}
