package controller;

import service.RecetaService;

public class RecetaController {

    private RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    public RecetaService getService() {
        return recetaService;
    }

}