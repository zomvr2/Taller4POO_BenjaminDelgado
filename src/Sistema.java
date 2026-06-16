import java.util.ArrayList;

public interface Sistema {
    void cargarCartas();
    void guardarCartas();
    void agregarCarta(Carta carta);
    void eliminarCarta(Carta carta);
    void modificarCarta(Carta carta);
    ArrayList<Carta> getCartas();
    void ordenarCartas();
    int calcularPoder(Carta carta);
}
