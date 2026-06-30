package util;

public class TextoUtil {
    public static boolean estaVacio(String texto) {
        return texto == null || texto.trim().equals("");
    }

    public static String limpiar(String texto) {
        if (texto == null) return "";
        return texto.trim();
    }
}
