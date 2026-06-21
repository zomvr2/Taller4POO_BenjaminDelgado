package gui;

import domain.Carta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardGrid extends JPanel {
    private final ArrayList<Carta> cartas;

    public CardGrid(ArrayList<Carta> cartas) {
        this.cartas = cartas;
        setLayout(new GridLayout(0, 4, 10, 10));
        refreshCards();
    }

    public void refreshCards() {
        removeAll();

        for (Carta carta : cartas) {
            ImageIcon cardIcon = new ImageIcon(carta.getRutaImagen());
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
}
