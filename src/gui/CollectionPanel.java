package gui;

import javax.swing.*;

import logic.Sistema;
import patrones.SortStrategy;

public class CollectionPanel extends JPanel {
    public CollectionPanel(Sistema sistema) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        SortStrategy sortBy;

        String[] opciones = {
                "Ordenar por rareza",
                "Ordenar por nombre",
                "Ordenar por poder" };

        JComboBox<String> sortOptions = new JComboBox<>(opciones);
        CardGrid cardGrid = new CardGrid(sistema);

        sortOptions.addActionListener(e -> {
            String selected = (String) sortOptions.getSelectedItem();
        });

        add(sortOptions);
        add(cardGrid);
    }
}
