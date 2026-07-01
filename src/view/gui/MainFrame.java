package view.gui;

import factory.AppFactory;
import util.Constantes;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class MainFrame extends JFrame {
    private JPanel contenido;
    private AppFactory app;

    public MainFrame() {
        app = new AppFactory();
        setTitle(Constantes.NOMBRE_CLINICA);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel(Constantes.TITULO_SISTEMA, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(titulo, BorderLayout.NORTH);

        add(new MenuPanel(this), BorderLayout.WEST);
        contenido = new JPanel(new BorderLayout());
        add(contenido, BorderLayout.CENTER);
        add(new JLabel(Constantes.NOMBRE_CLINICA, SwingConstants.CENTER), BorderLayout.SOUTH);

        mostrarDashboard();
    }

    public void cambiarPanel(JPanel panel) {
        contenido.removeAll();
        contenido.add(panel, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
    }

    public void mostrarDashboard() { 
        cambiarPanel(new DashboardPanel()); 
    }
    public void mostrarPacientes() { 
        cambiarPanel(new PacientePanel(app.controllers.pacienteController)); 
    }
    public void mostrarOdontologos() { 
        cambiarPanel(new OdontologoPanel(app.controllers.odontologoController)); 
    }
    public void mostrarCitas() {
        cambiarPanel(new CitaPanel(app.controllers.citaController)); 
    }
    public void mostrarTratamientos() {
        cambiarPanel(new TratamientoPanel(app.controllers.tratamientoController)); 
    }
    public void mostrarPagos() { 
        cambiarPanel(new PagoPanel(app.controllers.pagoController)); 
    }
    public void mostrarInventario() { 
        cambiarPanel(new InventarioPanel(app.controllers.inventarioController)); 
    }
    public void mostrarReportes() { 
        cambiarPanel(new ReportePanel(app.controllers.reporteController)); 
    }
    public void mostrarHistoria() { 
        cambiarPanel(new HistoriaClinicaPanel(app.controllers.historiaClinicaController)); 
    }
    public void mostrarFacturas() { 
        cambiarPanel(new FacturaPanel(app.controllers.facturaController)); 
    }
    public void mostrarAuditoria() { 
        cambiarPanel(new AuditoriaPanel(app.controllers.auditoriaController)); 
    }
}
