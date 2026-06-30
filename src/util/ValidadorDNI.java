package util;

public class ValidadorDNI {
    public static boolean esValido(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }
}
