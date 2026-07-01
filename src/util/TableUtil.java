package util;

import javax.swing.JTable;

public class TableUtil {
    public static void ajustar(JTable tabla) {
        tabla.setRowHeight(24);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
}
