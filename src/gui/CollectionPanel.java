package gui;

import javax.swing.*;

import domain.Carta;
import logic.Sistema;
import logic.SistemaImpl;

import java.awt.*;
import java.util.ArrayList;

public class CollectionPanel extends JPanel {
    private Sistema sistema;
    public CollectionPanel() {
        sistema = SistemaImpl.getInstance();
        setLayout(new GridLayout(0, 4, 10, 10));

        ArrayList<Carta> cartas = sistema.getCartas();

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
    }
}
