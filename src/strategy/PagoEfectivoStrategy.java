package strategy;

public class PagoEfectivoStrategy implements MetodoPagoStrategy {
    @Override
    public String pagar(double monto) {
        return "Pago en efectivo realizado por S/ " + monto;
    }

    @Override
    public String getNombre() { return "Efectivo"; }
}