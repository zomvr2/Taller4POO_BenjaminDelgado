package patrones;

import domain.Carta;

import java.util.ArrayList;

public class PowerSort implements SortStrategy {
    CartaVisitor visitor = new PowerCalcVisitor();

    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> (int) c1.aceptar(visitor) - (int) c2.aceptar(visitor));
    }
}
