package service;

import java.util.ArrayList;
import model.Odontograma;
import repository.OdontogramaRepository;

public class OdontogramaService {

    private OdontogramaRepository odontogramaRepository;

    public OdontogramaService(OdontogramaRepository odontogramaRepository) {
        this.odontogramaRepository = odontogramaRepository;
    }

    public void agregar(Odontograma objeto) {
        odontogramaRepository.agregar(objeto);
    }

    public ArrayList<Odontograma> listar() {
        return odontogramaRepository.listar();
    }

}