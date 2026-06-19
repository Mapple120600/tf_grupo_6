package view;

import controller.CitaController;
import model.Cita;
import model.Odontologo;
import java.util.ArrayList;
import java.util.Scanner;

public class CitaView {
    private Scanner scanner;
    private CitaController citaController;

    public CitaView(Scanner scanner, CitaController citaController) {
        this.scanner = scanner;
        this.citaController = citaController;
    }

    public void listarOdontologos() {
        System.out.println("\n--- ODONTOLOGOS REGISTRADOS ---");
        ArrayList<Odontologo> odontologos = citaController.listarOdontologos();

        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo);
        }
    }

    public void programarCita() {
        System.out.println("\n--- PROGRAMAR CITA ---");

        System.out.print("ID de la cita: ");
        int idCita = Integer.parseInt(scanner.nextLine());

        System.out.print("DNI del paciente: ");
        String dniPaciente = scanner.nextLine();

        System.out.print("especialidad (ortodoncia/endodoncia/odontologia general): ");
        String especialidad = scanner.nextLine();

        System.out.print("fecha (dd/MM/yyyy): ");
        String fecha = scanner.nextLine();

        System.out.print("hora (HH:mm): ");
        String hora = scanner.nextLine();

        ArrayList<Odontologo> disponibles = citaController.buscarDisponibles(
                especialidad, fecha, hora);

        if (disponibles.isEmpty()) {
            System.out.println("no hay odontologos disponibles en ese horario.");
            return;
        }

        System.out.println("\n odontologos disponibles:");
        for (Odontologo odontologo : disponibles) {
            System.out.println(odontologo);
        }

        System.out.print("seleccione el ID del odontologo: ");
        int idOdontologo = Integer.parseInt(scanner.nextLine());

        boolean idValido = false;
        for (Odontologo odontologo : disponibles) {
            if (odontologo.getId() == idOdontologo) {
                idValido = true;
            }
        }

        if (!idValido) {
            System.out.println("debe seleccionar un odontologo de la lista.");
            return;
        }

        String mensaje = citaController.programarCita(
                idCita, dniPaciente, idOdontologo, fecha, hora);
        System.out.println(mensaje);
    }

    public void listarCitas() {
        System.out.println("\n--- CITAS REGISTRADAS ---");
        ArrayList<Cita> citas = citaController.listarCitas();

        if (citas.isEmpty()) {
            System.out.println("no hay citas registradas.");
        } else {
            for (Cita cita : citas) {
                System.out.println(cita);
            }
        }
    }

    public void cancelarCita() {
        System.out.println("\n--- CANCELAR CITA ---");
        System.out.print("ID de la cita: ");
        int idCita = Integer.parseInt(scanner.nextLine());

        String mensaje = citaController.cancelarCita(idCita);
        System.out.println(mensaje);
    }
}
