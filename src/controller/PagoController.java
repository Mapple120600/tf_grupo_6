package controller;

import java.util.ArrayList;
import model.Pago;
import service.PagoService;
import strategy.MetodoPagoStrategy;

public class PagoController {
    private PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    public String registrarPago(int id, String dni, double monto, String fecha, MetodoPagoStrategy estrategia) {
        return pagoService.registrarPago(id, dni, monto, fecha, estrategia);
    }

    public ArrayList<Pago> listarPagos() { return pagoService.listarPagos(); }
}