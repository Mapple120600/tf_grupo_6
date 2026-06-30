package controller;

import java.util.ArrayList;
import model.Factura;
import service.FacturaService;

public class FacturaController {
    private FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public String registrarFactura(int id, String dni, double total, String fecha) {
        return facturaService.registrarFactura(id, dni, total, fecha);
    }

    public ArrayList<Factura> listarFacturas() {
        return facturaService.listar();
    }

    public FacturaService getService() {
        return facturaService;
    }
}