package gui;

import domain.Carta;
import logic.Sistema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AdminPanel extends JPanel {
    public AdminPanel(Sistema sistema) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ArrayList<Carta> cartas = sistema.getCartas();

        JButton addButton = new JButton("Agregar carta");

        String[] columnas = { "Nombre", "Tipo", "Rareza" };
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        for (Carta carta : cartas) {
            modelo.addRow(new Object[]{
                    carta.getNombre(),
                    carta.getTipo(),
                    carta.getRareza()
            });
        }

        add(addButton);
        add(scrollPane);
    }
}
