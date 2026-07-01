package strategy;

public class PagoTarjetaStrategy implements MetodoPagoStrategy {
    @Override
    public String pagar(double monto) {
        return "Pago con tarjeta realizado por S/ " + monto;
    }

    @Override
    public String getNombre() { return "Tarjeta"; }
}