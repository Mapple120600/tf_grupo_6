package controller;

import service.ReporteService;

public class ReporteController {

    private ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    public String generarResumen() {
        return reporteService.generarResumen();
    }

}