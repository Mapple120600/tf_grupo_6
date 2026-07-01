package strategy;

public interface MetodoPagoStrategy {
    String pagar(double monto);
    String getNombre();
}