package patrones;

import domain.Carta;

import java.util.ArrayList;

/**
 * Estrategia que ordena cartas alfabeticamente por nombre.
 */
public class NameSort implements SortStrategy {
    /**
     * Ordena la lista recibida por nombre, sin distinguir mayusculas.
     *
     * @param cartas lista de cartas que sera ordenada
     */
    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
    }
}
