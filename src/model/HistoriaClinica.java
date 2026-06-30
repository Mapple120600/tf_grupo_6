package model;

public class HistoriaClinica {
    private int id;
    private Paciente paciente;
    private String antecedentes;
    private String observaciones;

    public HistoriaClinica(int id, Paciente paciente, String antecedentes, String observaciones) {
        this.id = id;
        this.paciente = paciente;
        this.antecedentes = antecedentes;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + "paciente: " + paciente + " | " + "antecedentes: " + antecedentes + " | " + "observaciones: " + observaciones;
    }
}
