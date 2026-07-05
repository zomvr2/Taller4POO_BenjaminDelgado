package gui;

import domain.Carta;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Panel que muestra las cartas como una grilla de botones con imagen.
 */
public class CardGrid extends JPanel {
    private static final String DEFAULT_IMAGE_PATH = "src/files/imagenes/Default.png";

    private final ArrayList<Carta> cartas;

    /**
     * Crea una grilla para la lista de cartas recibida.
     *
     * @param cartas cartas que se mostraran en la grilla
     */
    public CardGrid(ArrayList<Carta> cartas) {
        this.cartas = cartas;
        setLayout(new GridLayout(0, 4, 10, 10));
        refreshCards();
    }

    /**
     * Reconstruye la grilla usando el orden y contenido actual de la lista.
     */
    public void refreshCards() {
        removeAll();

        for (Carta carta : cartas) {
            ImageIcon cardIcon = new ImageIcon(obtenerRutaImagen(carta));
            Image cardImage = cardIcon.getImage();
            Image scaledCardImage = cardImage.getScaledInstance(120, 165, Image.SCALE_SMOOTH);

            JButton card = new JButton(new ImageIcon(scaledCardImage));

            card.addActionListener(e -> {
                CardDetailsWindow cardDetailsWindow = new CardDetailsWindow(carta);
                cardDetailsWindow.setVisible(true);
            });

            add(card);
        }

        revalidate();
        repaint();
    }

    private String obtenerRutaImagen(Carta carta) {
        File imageFile = new File(carta.getRutaImagen());
        if (imageFile.exists()) {
            return carta.getRutaImagen();
        }
        return DEFAULT_IMAGE_PATH;
    }
}
