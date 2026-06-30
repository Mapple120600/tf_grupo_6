package service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import model.MaterialDental;
import repository.MaterialRepository;

public class InventarioService {
    private MaterialRepository materialRepository;
    private AuditoriaService auditoriaService;

    public InventarioService(MaterialRepository materialRepository, AuditoriaService auditoriaService) {
        this.materialRepository = materialRepository;
        this.auditoriaService = auditoriaService;
    }

    public String registrarMaterial(int id, String nombre, int stock, String unidad) {
        materialRepository.agregar(new MaterialDental(id, nombre, stock, unidad));
        auditoriaService.registrarAccion("Se registro material: " + nombre);
        return "Material registrado";
    }

    public ArrayList<MaterialDental> listarMateriales() { return materialRepository.listar(); }

    public ArrayList<MaterialDental> listarStockBajo() {
        return materialRepository.listar().stream()
                .filter(m -> m.getStock() <= 10)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}