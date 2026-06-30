package controller;

import java.util.ArrayList;
import model.MaterialDental;
import service.InventarioService;

public class InventarioController {
    private InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public String registrarMaterial(int id, String nombre, int stock, String unidad) {
        return inventarioService.registrarMaterial(id, nombre, stock, unidad);
    }

    public ArrayList<MaterialDental> listarMateriales() { return inventarioService.listarMateriales(); }
}