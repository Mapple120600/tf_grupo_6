package repository;

import model.Odontograma;

public class OdontogramaRepository extends Repository<Odontograma> {

    public Odontograma buscarPorId(int id) {

        for (Odontograma o : datos) {
            if (o.getId() == id) {
                return o;
            }
        }

        return null;
    }

}