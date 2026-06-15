package model;

public class Cita {
    private int id;
    private Paciente paciente;
    private Odontologo odontologo;
    private String fecha;
    private String hora;
    private String estado;

    public Cita(int id, Paciente paciente, Odontologo odontologo, String fecha, String hora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = "PROGRAMADA";
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

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public void cancelar() {
        estado = "CANCELADA";
    }

    @Override
    public String toString() {
        return "ID cita: " + id + " | Paciente: " + paciente.getNombre() + " | Odontólogo: " + odontologo.getNombre()
                + " | Fecha: " + fecha + " | Hora: " + hora + " | Estado: " + estado;
    }
}