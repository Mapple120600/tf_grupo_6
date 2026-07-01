package controller;

import java.util.ArrayList;
import model.Auditoria;
import service.AuditoriaService;

public class AuditoriaController {

    private AuditoriaService auditoriaService;

    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    public ArrayList<Auditoria> listarAuditorias() {
        return auditoriaService.listar();
    }

    public AuditoriaService getService() {
        return auditoriaService;
    }

}