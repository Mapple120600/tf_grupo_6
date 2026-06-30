package repository;

import model.Diagnostico;

public class DiagnosticoRepository extends Repository<Diagnostico> {

    public Diagnostico buscarPorId(int id) {
        for (Diagnostico d : datos) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

}