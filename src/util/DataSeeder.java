package util;

import model.*;
import repository.*;

public class DataSeeder {
    public static void cargarDatos(RepositoryFactoryData data) {
        if (data.pacienteRepository.cantidad() == 0) {
            data.pacienteRepository.agregar(new Paciente(1, "María López", "12345678", "987654321"));
            data.pacienteRepository.agregar(new Paciente(2, "Carlos Ramos", "87654321", "912345678"));
        }

        if (data.odontologoRepository.cantidad() == 0) {
            data.odontologoRepository.agregar(new Odontologo(1, "Ana Torres", "Ortodoncia"));
            data.odontologoRepository.agregar(new Odontologo(2, "Luis Mendoza", "Endodoncia"));
        }

        if (data.materialRepository.cantidad() == 0) {
            data.materialRepository.agregar(new MaterialDental(1, "Guantes", 120, "unidades"));
            data.materialRepository.agregar(new MaterialDental(2, "Resina", 20, "cajas"));
        }
    }

    public static class RepositoryFactoryData {
        public PacienteRepository pacienteRepository;
        public OdontologoRepository odontologoRepository;
        public MaterialRepository materialRepository;
    }
}
