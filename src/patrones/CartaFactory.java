package patrones;

import domain.*;

/**
 * Fabrica responsable de convertir lineas de texto en instancias de cartas.
 */
public class CartaFactory {
    /**
     * Crea una carta desde una linea con formato {@code Nombre;Rareza;Tipo;...}.
     *
     * @param linea linea leida desde el archivo de cartas
     * @return carta creada segun su tipo, o {@code null} si el tipo no existe
     */
    public static Carta crearCarta(String linea) {
        String[] partes = linea.split(";");

        String nombre = partes[0];
        int rareza = Integer.parseInt(partes[1]);
        String tipo = partes[2];

        switch (tipo) {
            case "Pokemon":
                int dano = Integer.parseInt(partes[3]);
                int energias = Integer.parseInt(partes[4]);
                return new CartaPokemon(nombre, rareza, dano, energias);
            case "Item":
                int bonificacion = Integer.parseInt(partes[3]);
                return new CartaItem(nombre, rareza, bonificacion);
            case "Supporter":
                int efectos = Integer.parseInt(partes[3]);
                return new CartaSupporter(nombre, rareza, efectos);
            case "Energy":
                String elemento = partes[3];
                return new CartaEnergy(nombre, rareza, elemento);
            default:
                return null;
        }
    }
}
