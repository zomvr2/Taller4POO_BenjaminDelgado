package patrones;

import domain.Carta;

import java.util.ArrayList;

/**
 * Contrato para estrategias de ordenamiento de cartas.
 */
public interface SortStrategy {
    /**
     * Ordena la lista de cartas recibida.
     *
     * @param cartas lista de cartas que sera ordenada
     */
    void sort(ArrayList<Carta> cartas);
}
