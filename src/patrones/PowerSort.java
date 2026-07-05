package patrones;

import domain.Carta;

import java.util.ArrayList;

public class PowerSort implements SortStrategy {
    private final CartaVisitor visitor = new PowerCalcVisitor();

    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> Double.compare(c2.aceptar(visitor), c1.aceptar(visitor)));
    }
}
