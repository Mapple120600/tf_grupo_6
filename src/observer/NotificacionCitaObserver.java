package observer;

import model.Cita;

public class NotificacionCitaObserver implements CitaObserver {
    @Override
    public void actualizar(Cita cita, String accion) {
        System.out.println("Notificación de cita: " + accion + " - " + cita);
    }
}