package service;

import java.util.ArrayList;
import model.Receta;
import repository.RecetaRepository;

public class RecetaService {

    private RecetaRepository recetaRepository;

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public void agregar(Receta objeto) {
        recetaRepository.agregar(objeto);
    }

    public ArrayList<Receta> listar() {
        return recetaRepository.listar();
    }

}