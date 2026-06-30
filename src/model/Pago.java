package model;

public class Pago {
    private int id;
    private Paciente paciente;
    private double monto;
    private String metodo;
    private String fecha;

    public Pago(int id, Paciente paciente, double monto, String metodo, String fecha) {
        this.id = id;
        this.paciente = paciente;
        this.monto = monto;
        this.metodo = metodo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public double getMonto() {
        return monto;
    }
    public String getMetodo() {
        return metodo;
    }
    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Paciente: " + paciente.getNombre() + " | Monto: S/ " + monto + " | Método: " + metodo + " | Fecha: " + fecha;
    }
}
