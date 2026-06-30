package controller;

import java.util.ArrayList;
import model.Tratamiento;
import service.TratamientoService;

public class TratamientoController {

    private TratamientoService tratamientoService;

    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }

    public String registrarTratamiento(
            int id,
            String dni,
            int idOdontologo,
            String nombre,
            double costo) {

        return tratamientoService.registrarTratamiento(
                id,
                dni,
                idOdontologo,
                nombre,
                costo);
    }

    public ArrayList<Tratamiento> listarTratamientos() {
        return tratamientoService.listarTratamientos();
    }

}