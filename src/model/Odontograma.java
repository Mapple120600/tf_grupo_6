package model;

public class Odontograma {
    private int id;
    private Paciente paciente;
    private String observacion;

    public Odontograma(int id, Paciente paciente, String observacion) {
        this.id = id;
        this.paciente = paciente;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getObservacion() {
        return observacion;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " +
               "paciente: " + paciente + " | " +
               "observacion: " + observacion;
    }
}
