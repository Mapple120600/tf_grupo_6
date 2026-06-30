package service;

import model.Odontologo;
import repository.OdontologoRepository;
import java.util.ArrayList;

public class OdontologoService {
    
    private OdontologoRepository odontologoRepository;
    private AuditoriaService auditoriaService;

    public OdontologoService(OdontologoRepository odontologoRepository, AuditoriaService auditoriaService) {
        this.odontologoRepository = odontologoRepository;
        this.auditoriaService = auditoriaService;
    }

    public String registrarOdontologo(int id, String nombre, String especialidad) {
        if (odontologoRepository.buscarPorId(id) != null) return "Ya existe un odontólogo con ese ID";
        odontologoRepository.agregar(new Odontologo(id, nombre, especialidad));
        auditoriaService.registrarAccion("Se registro un odontologo: " + nombre);
        return "Odontólogo registrado correctamente";
    }

    public Odontologo buscarPorId(int id) { return odontologoRepository.buscarPorId(id); }
    public ArrayList<Odontologo> listarOdontologos() { return odontologoRepository.listar(); }
}   
