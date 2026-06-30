package model;

public class MaterialDental {
    private int id;
    private String nombre;
    private int stock;
    private String unidad;

    public MaterialDental(int id, String nombre, int stock, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.unidad = unidad;
    }

    public int getId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public int getStock() { 
        return stock; 
    }
    public String getUnidad() { 
        return unidad; 
    }
    public void aumentarStock(int cantidad) { 
        stock += cantidad; 
    }
    public void disminuirStock(int cantidad) { 
        if (cantidad <= stock) stock -= cantidad; 
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Material: " + nombre + " | Stock: " + stock + " " + unidad;
    }
}