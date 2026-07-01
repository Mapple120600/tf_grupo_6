package service;

import repository.CitaRepository;
import repository.MaterialRepository;
import repository.PagoRepository;

public class ReporteService {

    private CitaRepository citaRepository;
    private PagoRepository pagoRepository;
    private MaterialRepository materialRepository;

    public ReporteService(
            CitaRepository citaRepository,
            PagoRepository pagoRepository,
            MaterialRepository materialRepository) {

        this.citaRepository = citaRepository;
        this.pagoRepository = pagoRepository;
        this.materialRepository = materialRepository;
    }

    public String generarResumen() {

        long citasProgramadas = citaRepository
                .listar()
                .stream()
                .filter(c -> c.getEstado().equals("PROGRAMADA"))
                .count();

        double totalPagos = pagoRepository
                .listar()
                .stream()
                .mapToDouble(p -> p.getMonto())
                .sum();

        long stockBajo = materialRepository
                .listar()
                .stream()
                .filter(m -> m.getStock() <= 10)
                .count();

        return "Citas programadas: " + citasProgramadas
                + "\nTotal pagos: S/ " + totalPagos
                + "\nMateriales con stock bajo: " + stockBajo;
    }

}