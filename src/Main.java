import controller.CitaController;
import controller.PacienteController;
import model.Odontologo;
import repository.CitaRepository;
import repository.OdontologoRepository;
import repository.PacienteRepository;
import service.CitaService;
import service.PacienteService;
import view.CitaView;
import view.MenuView;
import view.PacienteView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PacienteRepository pacienteRepository = new PacienteRepository();
        OdontologoRepository odontologoRepository = new OdontologoRepository();
        CitaRepository citaRepository = new CitaRepository();

        odontologoRepository.agregar(
                new Odontologo(1, "Ana Torres", "Ortodoncia"));
        odontologoRepository.agregar(
                new Odontologo(2, "Luis Mendoza", "Endodoncia"));
        odontologoRepository.agregar(
                new Odontologo(3, "Carla Ruiz", "Odontología general"));

        PacienteService pacienteService = new PacienteService(pacienteRepository);
        CitaService citaService = new CitaService(citaRepository, pacienteRepository, odontologoRepository);    
        PacienteController pacienteController = new PacienteController(pacienteService);
        CitaController citaController = new CitaController(citaService);

        MenuView menuView = new MenuView();
        PacienteView pacienteView =
                new PacienteView(scanner, pacienteController);
        CitaView citaView = new CitaView(scanner, citaController);

        int opcion = -1;

        while (opcion != 0) {
            try {
                menuView.mostrarMenu();
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        pacienteView.registrarPaciente();
                        break;
                    case 2:
                        pacienteView.listarPacientes();
                        break;
                    case 3:
                        citaView.listarOdontologos();
                        break;
                    case 4:
                        citaView.programarCita();
                        break;
                    case 5:
                        citaView.listarCitas();
                        break;
                    case 6:
                        citaView.cancelarCita();
                        break;
                    case 0:
                        System.out.println("programa finalizado.");
                        break;
                    default:
                        System.out.println("opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("debe ingresar un numero.");
            }
        }

        scanner.close();
    }
}
