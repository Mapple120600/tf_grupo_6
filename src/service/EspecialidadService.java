package service;

import java.util.ArrayList;
import model.Especialidad;
import repository.Repository;

public class EspecialidadService {
    private Repository<Especialidad> especialidadRepository;

    public EspecialidadService(Repository<Especialidad> especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public void agregar(Especialidad especialidad) {
        especialidadRepository.agregar(especialidad);
    }

    public ArrayList<Especialidad> listar() {
        return especialidadRepository.listar();
    }
}