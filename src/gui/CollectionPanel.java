package gui;

import javax.swing.*;

import domain.Carta;
import logic.Sistema;
import patrones.NameSort;
import patrones.PowerSort;
import patrones.RaritySort;
import patrones.SortStrategy;

import java.util.ArrayList;

/**
 * Panel de coleccion que muestra las cartas y permite ordenarlas.
 */
public class CollectionPanel extends JPanel {
    /**
     * Crea el panel de coleccion con controles de ordenamiento.
     *
     * @param sistema sistema que entrega las cartas cargadas
     */
    public CollectionPanel(Sistema sistema) {
        ArrayList<Carta> cartas = sistema.getCartas();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] opciones = {
                "Ordenar por rareza",
                "Ordenar por nombre",
                "Ordenar por poder" };

        JComboBox<String> sortOptions = new JComboBox<>(opciones);
        CardGrid cardGrid = new CardGrid(cartas);

        sortOptions.addActionListener(e -> {
            String selected = (String) sortOptions.getSelectedItem();

            SortStrategy sortStrategy = switch (selected) {
                case "Ordenar por poder" -> new PowerSort();
                case "Ordenar por nombre" -> new NameSort();
                default -> new RaritySort();
            };

            sortStrategy.sort(cartas);
            cardGrid.refreshCards();
        });

        add(sortOptions);
        add(cardGrid);
    }
}
