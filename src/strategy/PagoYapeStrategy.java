package strategy;

public class PagoYapeStrategy implements MetodoPagoStrategy {
    @Override
    public String pagar(double monto) {
        return "Pago con Yape realizado por S/ " + monto;
    }

    @Override
    public String getNombre() { return "Yape"; }
}
