package model;

public class Auditoria {
    private int id;
    private String accion;
    private String usuario;
    private String fecha;

    public Auditoria(int id, String accion, String usuario, String fecha) {
        this.id = id;
        this.accion = accion;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getAccion() {
        return accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "id: " + id + 
                " | " + "accion: " + accion + 
                " | " + "usuario: " + usuario + 
                " | " + "fecha: " + fecha;
    }
}