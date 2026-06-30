package model;

public class Procedimiento {
    private int id;
    private String nombre;
    private double costo;

    public Procedimiento(int id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " +
               "nombre: " + nombre + " | " +
               "costo: " + costo;
    }
}