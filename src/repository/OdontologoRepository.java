package repository;

import model.Odontologo;
import java.util.ArrayList;

public class OdontologoRepository {
    private ArrayList<Odontologo> odontologos;

    public OdontologoRepository() {
        odontologos = new ArrayList<>();
    }

    public boolean agregar(Odontologo odontologo) {
        if (buscarPorId(odontologo.getId()) != null) {
            return false;
        }
        odontologos.add(odontologo);
        return true;
    }

    public Odontologo buscarPorId(int id) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getId() == id) {
                return odontologo;
            }
        }
        return null;
    }

    public ArrayList<Odontologo> listar() {
        return odontologos;
    }
}