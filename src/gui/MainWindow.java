package gui;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("TCG Manager");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JScrollPane(new CollectionPanel()));
    }
}
