package patrones;

import domain.Carta;

import java.util.ArrayList;

public interface SortStrategy {
    void sort(ArrayList<Carta> cartas);
}
