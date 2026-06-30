package controller;

import model.Odontologo;
import service.OdontologoService;
import java.util.ArrayList;

public class OdontologoController {
    
    private OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    public String registrarOdontologo(int id, String nombre, String especialidad) {
        return odontologoService.registrarOdontologo(id, nombre, especialidad);
    }

    public Odontologo buscarPorId(int id) {
        return odontologoService.buscarPorId(id);
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }
}
