package gui;

import logic.Sistema;
import logic.SistemaImpl;

import javax.swing.*;

/**
 * Ventana principal de la aplicacion.
 *
 * Agrupa la administracion y la visualizacion de la coleccion en pestanas.
 */
public class MainWindow extends JFrame {
    /**
     * Crea la ventana principal.
     *
     * @param sistema sistema que administra las cartas de la aplicacion
     */
    public MainWindow(Sistema sistema) {
        setTitle("TCG Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add(new AdminPanel(sistema), "Administracion");
        tabs.add(new JScrollPane(new CollectionPanel(sistema)), "Colección");

        add(tabs);
    }
}
