package util;

import javax.swing.JOptionPane;
import java.awt.Component;

public class MensajeUtil {
    public static void info(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje);
    }

    public static void error(Component padre, String mensaje) {
        JOptionPane.showMessageDialog(padre, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
