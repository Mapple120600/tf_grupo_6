package model;

public class EvolucionClinica {
    private int id;
    private Paciente paciente;
    private String detalle;
    private String fecha;

    public EvolucionClinica(int id, Paciente paciente, String detalle, String fecha) {
        this.id = id;
        this.paciente = paciente;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " +
               "paciente: " + paciente + " | " +
               "detalle: " + detalle + " | " +
               "fecha: " + fecha;
    }
}