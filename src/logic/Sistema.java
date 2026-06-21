package logic;

import java.util.ArrayList;
import domain.Carta;

public interface Sistema {
    void cargarCartas();
    ArrayList<Carta> getCartas();
}
