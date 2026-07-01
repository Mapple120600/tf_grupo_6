package factory;

import controller.*;

public class ControllerFactory {
    public PacienteController pacienteController;
    public OdontologoController odontologoController;
    public CitaController citaController;
    public TratamientoController tratamientoController;
    public PagoController pagoController;
    public InventarioController inventarioController;
    public ReporteController reporteController;
    public HistoriaClinicaController historiaClinicaController;
    public DiagnosticoController diagnosticoController;
    public RecetaController recetaController;
    public OdontogramaController odontogramaController;
    public FacturaController facturaController;
    public AuditoriaController auditoriaController;

    public ControllerFactory(ServiceFactory services) {
        pacienteController = new PacienteController(services.pacienteService);
        odontologoController = new OdontologoController(services.odontologoService);
        citaController = new CitaController(services.citaService);
        tratamientoController = new TratamientoController(services.tratamientoService);
        pagoController = new PagoController(services.pagoService);
        inventarioController = new InventarioController(services.inventarioService);
        reporteController = new ReporteController(services.reporteService);
        historiaClinicaController = new HistoriaClinicaController(services.historiaClinicaService);
        diagnosticoController = new DiagnosticoController(services.diagnosticoService);
        recetaController = new RecetaController(services.recetaService);
        odontogramaController = new OdontogramaController(services.odontogramaService);
        facturaController = new FacturaController(services.facturaService);
        auditoriaController = new AuditoriaController(services.auditoriaService);
    }
}
