package controller;

import service.DiagnosticoService;

public class DiagnosticoController {

    private DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    public DiagnosticoService getService() {
        return diagnosticoService;
    }

}