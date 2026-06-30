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

        Odontologo odontologoEncontrado = odontologoRepository.buscarPorId(id);

        if (odontologoEncontrado != null) {
            return "ya existe un odnotologo con ese id";
        }

        Odontologo odontologo = new Odontologo(id, nombre, especialidad);
        boolean registrado = odontologoRepository.agregar(odontologo);

        if (registrado) {
            return "odontologo registrado correctamente";
        } else {
            return "no se pudo registrar el odontolog";
        }
    }

    public Odontologo buscarPorId(int id) {
        return odontologoRepository.buscarPorId(id);
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return odontologoRepository.listar();
    }
}   
