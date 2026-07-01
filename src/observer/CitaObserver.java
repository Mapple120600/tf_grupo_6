package observer;

import model.Cita;

public interface CitaObserver {
    void actualizar(Cita cita, String accion);
}