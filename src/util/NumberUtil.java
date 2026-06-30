package util;

public class NumberUtil {
    public static int convertirEntero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (Exception e) {
            return -1;
        }
    }

    public static double convertirDecimal(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
