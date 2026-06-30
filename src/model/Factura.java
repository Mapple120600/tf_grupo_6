package model;

public class Factura {
    private int id;
    private Paciente paciente;
    private double total;
    private String fecha;

    public Factura(int id, Paciente paciente, double total, String fecha) {
        this.id = id;
        this.paciente = paciente;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public double getTotal() {
        return total;
    }
    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + "paciente: " + paciente + " | " + "total: " + total + " | " + "fecha: " + fecha;
    }

}
