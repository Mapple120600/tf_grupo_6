package util;

public class FechaUtil {
    public static boolean esFechaValida(String fecha) {
        return fecha != null && fecha.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean esHoraValida(String hora) {
        return hora != null && hora.matches("\\d{2}:\\d{2}");
    }
}
