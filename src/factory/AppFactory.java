package factory;

import util.DataSeeder;

public class AppFactory {
    public RepositoryFactory repositories;
    public ServiceFactory services;
    public ControllerFactory controllers;

    public AppFactory() {
        repositories = new RepositoryFactory();
        cargarDatos();
        services = new ServiceFactory(repositories);
        controllers = new ControllerFactory(services);
    }

    private void cargarDatos() {
        DataSeeder.RepositoryFactoryData data = new DataSeeder.RepositoryFactoryData();
        data.pacienteRepository = repositories.pacienteRepository;
        data.odontologoRepository = repositories.odontologoRepository;
        data.materialRepository = repositories.materialRepository;
        DataSeeder.cargarDatos(data);
    }
}
