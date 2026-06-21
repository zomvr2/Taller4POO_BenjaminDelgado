package gui;

import logic.Sistema;
import logic.SistemaImpl;

import javax.swing.*;

public class MainWindow extends JFrame {
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
