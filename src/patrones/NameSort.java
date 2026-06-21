package patrones;

import domain.Carta;

import java.util.ArrayList;

public class NameSort implements SortStrategy {
    @Override
    public void sort(ArrayList<Carta> cartas) {
        cartas.sort((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()));
    }
}
