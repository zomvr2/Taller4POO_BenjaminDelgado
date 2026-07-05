package patrones;

import domain.Carta;

import java.util.ArrayList;

/**
 * Estrategia que ordena cartas desde mayor a menor rareza.
 */
public class RaritySort implements SortStrategy {
    /**
     * Ordena la lista recibida por rareza descendente.
     *
     * @param cartas lista de cartas que sera ordenada
     */
    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> c2.getRareza() - c1.getRareza());
    }
}
