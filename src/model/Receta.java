package model;

public class Receta {
    private int id;
    private Paciente paciente;
    private String indicaciones;
    private String fecha;

    public Receta(int id, Paciente paciente, String indicaciones, String fecha) {
        this.id = id;
        this.paciente = paciente;
        this.indicaciones = indicaciones;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " +
               "paciente: " + paciente + " | " +
               "indicaciones: " + indicaciones + " | " +
               "fecha: " + fecha;
    }
}