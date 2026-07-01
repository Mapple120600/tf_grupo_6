package controller;

import service.OdontogramaService;

public class OdontogramaController {

    private OdontogramaService odontogramaService;

    public OdontogramaController(OdontogramaService odontogramaService) {
        this.odontogramaService = odontogramaService;
    }

    public OdontogramaService getService() {
        return odontogramaService;
    }

}