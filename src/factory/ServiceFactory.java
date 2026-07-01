package factory;

import observer.CitaEventManager;
import observer.NotificacionCitaObserver;
import repository.Repository;
import service.*;
import model.Especialidad;

public class ServiceFactory {
    public PacienteService pacienteService;
    public OdontologoService odontologoService;
    public CitaService citaService;
    public TratamientoService tratamientoService;
    public PagoService pagoService;
    public InventarioService inventarioService;
    public ReporteService reporteService;
    public HistoriaClinicaService historiaClinicaService;
    public DiagnosticoService diagnosticoService;
    public RecetaService recetaService;
    public EspecialidadService especialidadService;
    public OdontogramaService odontogramaService;
    public FacturaService facturaService;
    public AuditoriaService auditoriaService;

    public ServiceFactory(RepositoryFactory repos) {
        CitaEventManager manager = new CitaEventManager();
        manager.agregarObservador(new NotificacionCitaObserver());

        auditoriaService = new AuditoriaService(repos.auditoriaRepository);
        pacienteService = new PacienteService(repos.pacienteRepository, auditoriaService);
        odontologoService = new OdontologoService(repos.odontologoRepository, auditoriaService);
        citaService = new CitaService(repos.citaRepository, repos.pacienteRepository, repos.odontologoRepository, manager, auditoriaService);
        tratamientoService = new TratamientoService(repos.tratamientoRepository, repos.pacienteRepository, repos.odontologoRepository, auditoriaService);
        pagoService = new PagoService(repos.pagoRepository, repos.pacienteRepository, auditoriaService);
        inventarioService = new InventarioService(repos.materialRepository, auditoriaService);
        reporteService = new ReporteService(repos.citaRepository, repos.pagoRepository, repos.materialRepository);
        historiaClinicaService = new HistoriaClinicaService(repos.historiaClinicaRepository, repos.pacienteRepository, auditoriaService);
        diagnosticoService = new DiagnosticoService(repos.diagnosticoRepository);
        recetaService = new RecetaService(repos.recetaRepository);
        especialidadService = new EspecialidadService(new Repository<Especialidad>());
        odontogramaService = new OdontogramaService(repos.odontogramaRepository);
        facturaService = new FacturaService(repos.facturaRepository, repos.pacienteRepository, auditoriaService);
    }
}
