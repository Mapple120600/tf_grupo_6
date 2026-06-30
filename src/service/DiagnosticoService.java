package service;

import java.util.ArrayList;
import model.Diagnostico;
import repository.DiagnosticoRepository;

public class DiagnosticoService {

    private DiagnosticoRepository diagnosticoRepository;

    public DiagnosticoService(DiagnosticoRepository diagnosticoRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
    }

    public void agregar(Diagnostico objeto) {
        diagnosticoRepository.agregar(objeto);
    }

    public ArrayList<Diagnostico> listar() {
        return diagnosticoRepository.listar();
    }

}