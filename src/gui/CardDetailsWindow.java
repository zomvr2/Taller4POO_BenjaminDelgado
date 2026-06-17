package gui;

import domain.Carta;

import javax.swing.*;
import java.awt.*;

public class CardDetailsWindow extends JFrame {
    public CardDetailsWindow(Carta carta) {
        setTitle("Detalles de " + carta.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ImageIcon cardIcon = new ImageIcon(carta.getRutaImagen());
        Image cardImage = cardIcon.getImage();
        Image scaledCardImage = cardImage.getScaledInstance(120, 165, Image.SCALE_SMOOTH);

        JLabel card = new JLabel(new ImageIcon(scaledCardImage));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel nombre = new JLabel("Nombre: " + carta.getNombre());
        JLabel rareza = new JLabel("Rareza: " + carta.getRareza());

        infoPanel.add(nombre);
        infoPanel.add(rareza);

        add(card);
        add(infoPanel);
    }
}
