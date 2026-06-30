package model;

public class DetalleFactura {
    private int id;
    private String concepto;
    private double monto;

    public DetalleFactura(int id, String concepto, double monto) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }
    public String getConcepto() {
        return concepto;
    }
    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "id: " + id + " | " + "concepto: " + concepto + " | " + "monto: " + monto;
    }
}
