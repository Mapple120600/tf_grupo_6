package controller;

import java.util.ArrayList;
import model.HistoriaClinica;
import service.HistoriaClinicaService;

public class HistoriaClinicaController {

    private HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    public String registrarHistoria(
            int id,
            String dni,
            String antecedentes,
            String observaciones) {

        return historiaClinicaService.registrarHistoria(
                id,
                dni,
                antecedentes,
                observaciones);
    }

    public ArrayList<HistoriaClinica> listarHistorias() {
        return historiaClinicaService.listar();
    }

    public HistoriaClinicaService getService() {
        return historiaClinicaService;
    }

}