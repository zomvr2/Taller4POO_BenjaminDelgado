package patrones;

import domain.Carta;

import java.util.ArrayList;

/**
 * Estrategia que ordena cartas desde mayor a menor poder calculado.
 */
public class PowerSort implements SortStrategy {
    private final CartaVisitor visitor = new PowerCalcVisitor();

    /**
     * Ordena la lista recibida usando {@link PowerCalcVisitor}.
     *
     * @param cartas lista de cartas que sera ordenada
     */
    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> Double.compare(c2.aceptar(visitor), c1.aceptar(visitor)));
    }
}
