package factory;

import repository.*;

public class RepositoryFactory {
    public PacienteRepository pacienteRepository;
    public OdontologoRepository odontologoRepository;
    public CitaRepository citaRepository;
    public TratamientoRepository tratamientoRepository;
    public PagoRepository pagoRepository;
    public MaterialRepository materialRepository;
    public HistoriaClinicaRepository historiaClinicaRepository;
    public DiagnosticoRepository diagnosticoRepository;
    public RecetaRepository recetaRepository;
    public OdontogramaRepository odontogramaRepository;
    public FacturaRepository facturaRepository;
    public AuditoriaRepository auditoriaRepository;

    public RepositoryFactory() {
        pacienteRepository = new PacienteRepository();
        odontologoRepository = new OdontologoRepository();
        materialRepository = new MaterialRepository();
        auditoriaRepository = new AuditoriaRepository();

        citaRepository = new CitaRepository(pacienteRepository, odontologoRepository);
        tratamientoRepository = new TratamientoRepository(pacienteRepository, odontologoRepository);
        pagoRepository = new PagoRepository(pacienteRepository);
        historiaClinicaRepository = new HistoriaClinicaRepository(pacienteRepository);
        facturaRepository = new FacturaRepository(pacienteRepository);

        diagnosticoRepository = new DiagnosticoRepository();
        recetaRepository = new RecetaRepository();
        odontogramaRepository = new OdontogramaRepository();
    }
}