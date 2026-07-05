package gui;

import domain.Carta;
import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Ventana que muestra la vista ampliada de una carta.
 *
 * Incluye imagen, datos base y atributos especificos segun el tipo de carta.
 */
public class CardDetailsWindow extends JFrame {
    private static final String DEFAULT_IMAGE_PATH = "src/files/imagenes/Default.png";

    /**
     * Crea una ventana de detalle para la carta indicada.
     *
     * @param carta carta cuyos datos se mostraran
     */
    public CardDetailsWindow(Carta carta) {
        setTitle("Detalles de " + carta.getNombre());
        setSize(480, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        ImageIcon cardIcon = new ImageIcon(obtenerRutaImagen(carta));
        Image cardImage = cardIcon.getImage();
        Image scaledCardImage = cardImage.getScaledInstance(150, 205, Image.SCALE_SMOOTH);

        JLabel card = new JLabel(new ImageIcon(scaledCardImage));
        card.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 12));
        imagePanel.add(card, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createEmptyBorder(18, 12, 18, 18));
        infoPanel.setLayout(new BorderLayout(0, 14));

        JLabel title = new JLabel(carta.getNombre());
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));

        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));

        agregarDetalle(detailsPanel, 0, "Tipo", carta.getTipo());
        agregarDetalle(detailsPanel, 1, "Rareza", String.valueOf(carta.getRareza()));
        agregarAtributos(detailsPanel, carta);

        infoPanel.add(title, BorderLayout.NORTH);
        infoPanel.add(detailsPanel, BorderLayout.CENTER);

        add(imagePanel, BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
    }

    private void agregarDetalle(JPanel panel, int fila, String etiqueta, String valor) {
        GridBagConstraints etiquetaConstraints = new GridBagConstraints();
        etiquetaConstraints.gridx = 0;
        etiquetaConstraints.gridy = fila;
        etiquetaConstraints.anchor = GridBagConstraints.WEST;
        etiquetaConstraints.insets = new Insets(0, 0, 8, 16);

        JLabel etiquetaLabel = new JLabel(etiqueta + ":");
        etiquetaLabel.setFont(etiquetaLabel.getFont().deriveFont(Font.BOLD));
        panel.add(etiquetaLabel, etiquetaConstraints);

        GridBagConstraints valorConstraints = new GridBagConstraints();
        valorConstraints.gridx = 1;
        valorConstraints.gridy = fila;
        valorConstraints.weightx = 1;
        valorConstraints.fill = GridBagConstraints.HORIZONTAL;
        valorConstraints.anchor = GridBagConstraints.WEST;
        valorConstraints.insets = new Insets(0, 0, 8, 0);

        panel.add(new JLabel(valor), valorConstraints);
    }

    private void agregarAtributos(JPanel panel, Carta carta) {
        if (carta instanceof CartaPokemon) {
            CartaPokemon pokemon = (CartaPokemon) carta;
            agregarDetalle(panel, 2, "Dano", String.valueOf(pokemon.getDano()));
            agregarDetalle(panel, 3, "Energias", String.valueOf(pokemon.getCantEnergias()));
        } else if (carta instanceof CartaItem) {
            CartaItem item = (CartaItem) carta;
            agregarDetalle(panel, 2, "Bonificacion", String.valueOf(item.getBonificacion()));
        } else if (carta instanceof CartaSupporter) {
            CartaSupporter supporter = (CartaSupporter) carta;
            agregarDetalle(panel, 2, "Efectos por turno", String.valueOf(supporter.getEfectosPorTurno()));
        } else if (carta instanceof CartaEnergy) {
            CartaEnergy energy = (CartaEnergy) carta;
            agregarDetalle(panel, 2, "Elemento", energy.getElemento());
        }
    }

    private String obtenerRutaImagen(Carta carta) {
        File imageFile = new File(carta.getRutaImagen());
        if (imageFile.exists()) {
            return carta.getRutaImagen();
        }
        return DEFAULT_IMAGE_PATH;
    }
}
