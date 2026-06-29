package controller;

import model.Cita;
import model.Odontologo;
import service.CitaService;
import java.util.ArrayList;

public class CitaController {

    private CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    public String programarCita(int idCita, String dniPaciente, int idOdontologo, String fecha, String hora) {
        return citaService.programarCita(idCita, dniPaciente, idOdontologo, fecha, hora);
    }

    public String cancelarCita(int idCita) {
        return citaService.cancelarCita(idCita);
    }

    public ArrayList<Cita> listarCitas() {
        return citaService.listarCitas();
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return citaService.listarOdontologos();
    }

    public ArrayList<Odontologo> buscarOdontologosDisponibles(String especialidad, String fecha, String hora) {
        return citaService.buscarOdontologosDisponibles(especialidad, fecha, hora);
    }
}
