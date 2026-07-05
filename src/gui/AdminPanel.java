package gui;

import domain.Carta;
import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;
import logic.Sistema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel de administracion para agregar, modificar y eliminar cartas.
 * <p>
 * Muestra la coleccion en una tabla y comunica cada operacion al sistema para
 * mantener la persistencia actualizada.
 */
public class AdminPanel extends JPanel {
    private static final String TIPO_POKEMON = "Pokemon";
    private static final String TIPO_ITEM = "Item";
    private static final String TIPO_SUPPORTER = "Supporter";
    private static final String TIPO_ENERGY = "Energy";

    private final Sistema sistema;
    private final DefaultTableModel modelo;
    private final JTable tabla;

    /**
     * Crea el panel de administracion.
     *
     * @param sistema sistema que administra la coleccion de cartas
     */
    public AdminPanel(Sistema sistema) {
        this.sistema = sistema;
        setLayout(new BorderLayout(10, 10));

        JButton addButton = new JButton("Agregar carta");
        JButton editButton = new JButton("Modificar carta");
        JButton deleteButton = new JButton("Eliminar carta");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        String[] columnas = {"Nombre", "Tipo", "Rareza", "Atributos"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addButton.addActionListener(e -> agregarCarta());
        editButton.addActionListener(e -> modificarCarta());
        deleteButton.addActionListener(e -> eliminarCarta());

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        refrescarTabla();
    }

    private void agregarCarta() {
        Carta carta = mostrarFormulario(null);
        if (carta == null) {
            return;
        }

        if (sistema.agregarCarta(carta)) {
            refrescarTabla();
            mostrarMensaje("Carta agregada correctamente.");
        } else {
            mostrarError("No se pudo agregar la carta.");
        }
    }

    private void modificarCarta() {
        int indice = obtenerIndiceSeleccionado();
        if (indice == -1) {
            mostrarError("Seleccione una carta para modificar.");
            return;
        }

        Carta cartaOriginal = sistema.getCartas().get(indice);
        Carta cartaModificada = mostrarFormulario(cartaOriginal);
        if (cartaModificada == null) {
            return;
        }

        if (sistema.modificarCarta(indice, cartaModificada)) {
            refrescarTabla();
            mostrarMensaje("Carta modificada correctamente.");
        } else {
            mostrarError("No se pudo modificar la carta.");
        }
    }

    private void eliminarCarta() {
        int indice = obtenerIndiceSeleccionado();
        if (indice == -1) {
            mostrarError("Seleccione una carta para eliminar.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "Eliminar la carta seleccionada?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        if (sistema.eliminarCarta(indice)) {
            refrescarTabla();
            mostrarMensaje("Carta eliminada correctamente.");
        } else {
            mostrarError("No se pudo eliminar la carta.");
        }
    }

    private void refrescarTabla() {
        modelo.setRowCount(0);
        ArrayList<Carta> cartas = sistema.getCartas();
        for (Carta carta : cartas) {
            modelo.addRow(new Object[]{
                    carta.getNombre(),
                    carta.getTipo(),
                    carta.getRareza(),
                    obtenerAtributos(carta)
            });
        }
    }

    private int obtenerIndiceSeleccionado() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            return -1;
        }
        return tabla.convertRowIndexToModel(filaSeleccionada);
    }

    private Carta mostrarFormulario(Carta cartaOriginal) {
        boolean modificando = cartaOriginal != null;

        JTextField nombreField = new JTextField(modificando ? cartaOriginal.getNombre() : "");
        JTextField rarezaField = new JTextField(modificando ? String.valueOf(cartaOriginal.getRareza()) : "");
        JComboBox<String> tipoCombo = new JComboBox<>(new String[]{
                TIPO_POKEMON,
                TIPO_ITEM,
                TIPO_SUPPORTER,
                TIPO_ENERGY
        });
        JTextField atributo1Field = new JTextField();
        JTextField atributo2Field = new JTextField();

        if (modificando) {
            nombreField.setEditable(false);
            rarezaField.setEditable(false);
            tipoCombo.setSelectedItem(cartaOriginal.getTipo());
            tipoCombo.setEnabled(false);
            cargarAtributos(cartaOriginal, atributo1Field, atributo2Field);
        }

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        JLabel atributo1Label = new JLabel();
        JLabel atributo2Label = new JLabel();

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Rareza:"));
        panel.add(rarezaField);
        panel.add(new JLabel("Tipo:"));
        panel.add(tipoCombo);
        panel.add(atributo1Label);
        panel.add(atributo1Field);
        panel.add(atributo2Label);
        panel.add(atributo2Field);

        Runnable actualizarAtributos = () -> actualizarCamposAtributos(
                (String) tipoCombo.getSelectedItem(),
                atributo1Label,
                atributo1Field,
                atributo2Label,
                atributo2Field
        );

        tipoCombo.addActionListener(e -> actualizarAtributos.run());
        actualizarAtributos.run();

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                panel,
                modificando ? "Modificar carta" : "Agregar carta",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (respuesta != JOptionPane.OK_OPTION) {
            return null;
        }

        try {
            return crearCartaDesdeFormulario(
                    nombreField.getText(),
                    rarezaField.getText(),
                    (String) tipoCombo.getSelectedItem(),
                    atributo1Field.getText(),
                    atributo2Field.getText()
            );
        } catch (IllegalArgumentException exception) {
            mostrarError(exception.getMessage());
            return null;
        }
    }

    private Carta crearCartaDesdeFormulario(
            String nombre,
            String rarezaTexto,
            String tipo,
            String atributo1,
            String atributo2
    ) {
        nombre = nombre.trim();
        tipo = tipo.trim();
        atributo1 = atributo1.trim();
        atributo2 = atributo2.trim();

        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }

        int rareza = parsearEntero(rarezaTexto, "La rareza debe ser un numero entero.");

        if (TIPO_POKEMON.equals(tipo)) {
            int dano = parsearEntero(atributo1, "El dano debe ser un numero entero.");
            int energias = parsearEntero(atributo2, "La cantidad de energias debe ser un numero entero.");
            if (energias <= 0) {
                throw new IllegalArgumentException("La cantidad de energias debe ser mayor que cero.");
            }
            return new CartaPokemon(nombre, rareza, dano, energias);
        }

        if (TIPO_ITEM.equals(tipo)) {
            int bonificacion = parsearEntero(atributo1, "La bonificacion debe ser un numero entero.");
            return new CartaItem(nombre, rareza, bonificacion);
        }

        if (TIPO_SUPPORTER.equals(tipo)) {
            int efectos = parsearEntero(atributo1, "Los efectos por turno deben ser un numero entero.");
            return new CartaSupporter(nombre, rareza, efectos);
        }

        if (TIPO_ENERGY.equals(tipo)) {
            if (atributo1.isEmpty()) {
                throw new IllegalArgumentException("El elemento no puede estar vacio.");
            }
            return new CartaEnergy(nombre, rareza, atributo1);
        }

        throw new IllegalArgumentException("Tipo de carta no valido.");
    }

    private void actualizarCamposAtributos(
            String tipo,
            JLabel atributo1Label,
            JTextField atributo1Field,
            JLabel atributo2Label,
            JTextField atributo2Field
    ) {
        atributo2Label.setVisible(false);
        atributo2Field.setVisible(false);

        if (TIPO_POKEMON.equals(tipo)) {
            atributo1Label.setText("Dano:");
            atributo2Label.setText("Cant. energias:");
            atributo2Label.setVisible(true);
            atributo2Field.setVisible(true);
        } else if (TIPO_ITEM.equals(tipo)) {
            atributo1Label.setText("Bonificacion:");
            atributo2Field.setText("");
        } else if (TIPO_SUPPORTER.equals(tipo)) {
            atributo1Label.setText("Efectos por turno:");
            atributo2Field.setText("");
        } else {
            atributo1Label.setText("Elemento:");
            atributo2Field.setText("");
        }
    }

    private void cargarAtributos(Carta carta, JTextField atributo1Field, JTextField atributo2Field) {
        if (carta instanceof CartaPokemon) {
            CartaPokemon pokemon = (CartaPokemon) carta;
            atributo1Field.setText(String.valueOf(pokemon.getDano()));
            atributo2Field.setText(String.valueOf(pokemon.getCantEnergias()));
        } else if (carta instanceof CartaItem) {
            CartaItem item = (CartaItem) carta;
            atributo1Field.setText(String.valueOf(item.getBonificacion()));
        } else if (carta instanceof CartaSupporter) {
            CartaSupporter supporter = (CartaSupporter) carta;
            atributo1Field.setText(String.valueOf(supporter.getEfectosPorTurno()));
        } else if (carta instanceof CartaEnergy) {
            CartaEnergy energy = (CartaEnergy) carta;
            atributo1Field.setText(energy.getElemento());
        }
    }

    private String obtenerAtributos(Carta carta) {
        if (carta instanceof CartaPokemon) {
            CartaPokemon pokemon = (CartaPokemon) carta;
            return "Dano: " + pokemon.getDano() + ", Energias: " + pokemon.getCantEnergias();
        }

        if (carta instanceof CartaItem) {
            CartaItem item = (CartaItem) carta;
            return "Bonificacion: " + item.getBonificacion();
        }

        if (carta instanceof CartaSupporter) {
            CartaSupporter supporter = (CartaSupporter) carta;
            return "Efectos por turno: " + supporter.getEfectosPorTurno();
        }

        if (carta instanceof CartaEnergy) {
            CartaEnergy energy = (CartaEnergy) carta;
            return "Elemento: " + energy.getElemento();
        }

        return "";
    }

    private int parsearEntero(String texto, String mensajeError) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
