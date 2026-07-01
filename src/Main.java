import view.gui.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame ventana = new MainFrame();
                ventana.setVisible(true);
            }
        });
    }
}