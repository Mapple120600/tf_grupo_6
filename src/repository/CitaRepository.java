package repository;

import model.Cita;
import java.util.ArrayList;

public class CitaRepository {
    private ArrayList<Cita> citas;

    public CitaRepository() {
        citas = new ArrayList<>();
    }

    public boolean agregar(Cita cita) {
        if (buscarPorId(cita.getId()) != null) {
            return false;
        }
        citas.add(cita);
        return true;
    }

    public Cita buscarPorId(int id) {
        for (Cita cita : citas) {
            if (cita.getId() == id) {
                return cita;
            }
        }
        return null;
    }

    public boolean horarioDisponible(int idOdontologo, String fecha, String hora) {
        for (Cita cita : citas) {
            boolean mismoOdontologo = cita.getOdontologo().getId() == idOdontologo;
            boolean mismaFecha = cita.getFecha().equals(fecha);
            boolean mismaHora = cita.getHora().equals(hora);
            boolean citaActiva = cita.getEstado().equals("PROGRAMADA");
            if (mismoOdontologo && mismaFecha && mismaHora && citaActiva) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Cita> listar() {
        return citas;
    }
}