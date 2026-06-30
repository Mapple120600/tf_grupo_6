package repository;

import java.util.ArrayList;

public class Repository<T> {
    protected ArrayList<T> datos;

    public Repository() {
        datos = new ArrayList<>();
    }

    public void agregar(T objeto) {
        datos.add(objeto);
    }

    public ArrayList<T> listar() {
        return datos;
    }

    public int cantidad() {
        return datos.size();
    }
}
