package observer;

import java.util.ArrayList;
import model.Cita;

public class CitaEventManager {
    private ArrayList<CitaObserver> observadores;

    public CitaEventManager() {
        observadores = new ArrayList<>();
    }

    public void agregarObservador(CitaObserver observador) {
        observadores.add(observador);
    }

    public void notificar(Cita cita, String accion) {
        for (CitaObserver observador : observadores) {
            observador.actualizar(cita, accion);
        }
    }
}
