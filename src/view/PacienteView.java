package view;

import controller.PacienteController;
import model.Paciente;
import java.util.ArrayList;
import java.util.Scanner;

public class PacienteView {
    private Scanner scanner;
    private PacienteController pacienteController;

    public PacienteView(Scanner scanner, PacienteController pacienteController) {
        this.scanner = scanner;
        this.pacienteController = pacienteController;
    }

    public void registrarPaciente() {
        System.out.println("\n--- REGISTRAR PACIENTE ---");

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("telefono: ");
        String telefono = scanner.nextLine();

        String mensaje = pacienteController.registrarPaciente(
                id, nombre, dni, telefono);
        System.out.println(mensaje);
    }

    public void listarPacientes() {
        System.out.println("\n PACIENTES REGISTRADOS ");
        ArrayList<Paciente> pacientes = pacienteController.listarPacientes();

        if (pacientes.isEmpty()) {
            System.out.println("no hay pacientes registrados.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }
}
