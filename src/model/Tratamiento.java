package model;

public class Tratamiento {
    private int id;
    private Paciente paciente;
    private Odontologo odontologo;
    private String nombre;
    private double costo;
    private String estado;

    public Tratamiento(int id, Paciente paciente, Odontologo odontologo, String nombre, double costo) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.nombre = nombre;
        this.costo = costo;
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public String getEstado() {
        return estado;
    }

    public void finalizar() {
        estado = "Finalizado";
    }

    @Override
    public String toString() {
        return "id: " + id +
                " | paciente: " + paciente.getNombre() +
                " | tratamiento: " + nombre +
                " | costo: S/ " + costo +
                " | estado: " + estado;
    }
}
