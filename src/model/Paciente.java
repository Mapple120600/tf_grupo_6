package model;

public class Paciente {
    private int id;
    private String nombre;
    private String dni;
    private String telefono;

    public Paciente(int id, String nombre, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | DNI: " + dni +
                " | Teléfono: " + telefono;
    }
}
