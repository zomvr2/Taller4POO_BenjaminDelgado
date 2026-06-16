import java.util.ArrayList;

public class SistemaImpl implements Sistema {
    private static SistemaImpl instancia;
    private ArrayList<Carta> cartas;

    private SistemaImpl() {
        cartas = new ArrayList<>();
    }

    public static SistemaImpl getInstance() {
        if (instancia == null) {
            instancia = new SistemaImpl();
        }
        return instancia;
    }

    @Override
    public void cargarCartas() {

    }

    @Override
    public void guardarCartas() {

    }

    @Override
    public void agregarCarta(Carta carta) {

    }

    @Override
    public void eliminarCarta(Carta carta) {

    }

    @Override
    public void modificarCarta(Carta carta) {

    }

    @Override
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    @Override
    public void ordenarCartas() {

    }

    @Override
    public int calcularPoder(Carta carta) {
        return 0;
    }
}
