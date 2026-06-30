package model;

public class PlanTratamiento {
    private int id;
    private Paciente paciente;
    private String descripcion;
    private String estado;

    public PlanTratamiento(int id, Paciente paciente, String descripcion, String estado) {
        this.id = id;
        this.paciente = paciente;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " +
               "paciente: " + paciente + " | " +
               "descripcion: " + descripcion + " | " +
               "estado: " + estado;
    }
}