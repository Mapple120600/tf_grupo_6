package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Auditoria;
import repository.AuditoriaRepository;

public class AuditoriaService {
    private AuditoriaRepository auditoriaRepository;

    public AuditoriaService(AuditoriaRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    public void registrarAccion(String accion) {
        int id = auditoriaRepository.cantidad() + 1;
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        Auditoria auditoria = new Auditoria(id, accion, "admin", fecha);
        auditoriaRepository.agregar(auditoria);
    }

    public void agregar(Auditoria objeto) {
        auditoriaRepository.agregar(objeto);
    }

    public ArrayList<Auditoria> listar() {
        return auditoriaRepository.listar();
    }
}
