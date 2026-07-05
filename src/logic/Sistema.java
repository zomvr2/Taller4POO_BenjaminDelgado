package logic;

import java.util.ArrayList;
import domain.Carta;

public interface Sistema {
    void cargarCartas();
    ArrayList<Carta> getCartas();
    boolean agregarCarta(Carta carta);
    boolean eliminarCarta(int indice);
    boolean modificarCarta(int indice, Carta cartaModificada);
    boolean guardarCartas();
}
