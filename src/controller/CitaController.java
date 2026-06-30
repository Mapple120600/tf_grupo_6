package controller;

import model.Cita;
import service.CitaService;
import java.util.ArrayList;

public class CitaController {

    private CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    public String programarCita(int id, String dniPaciente, int idOdontologo, String fecha, String hora) {
        return citaService.programarCita(id, dniPaciente, idOdontologo, fecha, hora);
    }

    public String cancelarCita(int id) {
        return citaService.cancelarCita(id);
    }

    public ArrayList<Cita> listarCitas() {
        return citaService.listarCitas();
    }
}
