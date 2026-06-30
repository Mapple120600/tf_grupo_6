package repository;

import model.Receta;

public class RecetaRepository extends Repository<Receta> {

    public Receta buscarPorId(int id) {

        for (Receta r : datos) {
            if (r.getId() == id) {
                return r;
            }
        }

        return null;
    }

}