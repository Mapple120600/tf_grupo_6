package service;

import model.Odontologo;
import repository.OdontologoRepository;
import java.util.ArrayList;

public class OdontologoService {
    
    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public String registrarOdontologo(int id, String nombre, String especialidad) {
        if (id <= 0) {
            return "el id del odontologo deber ser mayor a cero :c";
        }

        if (nombre == null || nombre.trim().equals("")) {
            return "el nombre del odontologo es obligatorio";
        }

        if (especialidad == null || especialidad.trim().equals("")) {
            return "la especilidad del odontologo es obligatorio";
        }

        Odontologo odontologo = new Odontologo(id, nombre, especialidad);
        odontologoRepository.agregar(odontologo);
        return "odontologo registrado con exito";
    }

    public Odontologo buscarPorId(int id) {
        return odontologoRepository.buscarPorId(id);
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return odontologoRepository.listar();
    }
}   
