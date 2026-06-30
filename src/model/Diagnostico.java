package model;

public class Diagnostico {
    private int id;
    private Paciente paciente;
    private String descripcion;
    private String fecha;

    public Diagnostico(int id, Paciente paciente, String descripcion, String fecha) {
        this.id = id;
        this.paciente = paciente;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDescripcion() {
        return  descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + "paciente: " + paciente + " | " + "descripcion: " + descripcion + " | " + "fecha: " + fecha;
    }
}
