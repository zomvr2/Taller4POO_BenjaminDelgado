package patrones;

import domain.Carta;

import java.util.ArrayList;

public class RaritySort implements SortStrategy {
    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> c2.getRareza() - c1.getRareza());
    }
}
