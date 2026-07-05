package logic;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import domain.Carta;
import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;
import patrones.CartaFactory;

public class SistemaImpl implements Sistema {
    private static final String RUTA_ARCHIVO = "src/files/sobres.txt";
    private static SistemaImpl instancia;
    private final ArrayList<Carta> cartas;

    private SistemaImpl() {
        cartas = new ArrayList<>();
        cargarCartas();
    }

    public static SistemaImpl getInstance() {
        if (instancia == null) {
            instancia = new SistemaImpl();
        }
        return instancia;
    }

    @Override
    public void cargarCartas() {
        cartas.clear();
        File file = new File(RUTA_ARCHIVO);
        try (Scanner scanner = new Scanner(file)) {
            String linea;
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                if (linea.trim().isEmpty()) {
                    continue;
                }

                Carta carta = CartaFactory.crearCarta(linea);
                if (carta != null) {
                    cartas.add(carta);
                }
            }

            System.out.println("Cartas cargadas: " + cartas.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    @Override
    public boolean agregarCarta(Carta carta) {
        if (carta == null) {
            return false;
        }

        cartas.add(carta);
        return guardarCartas();
    }

    @Override
    public boolean eliminarCarta(int indice) {
        if (!indiceValido(indice)) {
            return false;
        }

        cartas.remove(indice);
        return guardarCartas();
    }

    @Override
    public boolean modificarCarta(int indice, Carta cartaModificada) {
        if (!indiceValido(indice) || cartaModificada == null) {
            return false;
        }

        Carta cartaOriginal = cartas.get(indice);
        if (!mismaCartaBase(cartaOriginal, cartaModificada)) {
            return false;
        }

        cartas.set(indice, cartaModificada);
        return guardarCartas();
    }

    @Override
    public boolean guardarCartas() {
        File file = new File(RUTA_ARCHIVO);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Carta carta : cartas) {
                writer.println(convertirCartaALinea(carta));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < cartas.size();
    }

    private boolean mismaCartaBase(Carta cartaOriginal, Carta cartaModificada) {
        return cartaOriginal.getNombre().equals(cartaModificada.getNombre())
                && cartaOriginal.getRareza() == cartaModificada.getRareza()
                && cartaOriginal.getTipo().equals(cartaModificada.getTipo());
    }

    private String convertirCartaALinea(Carta carta) {
        if (carta instanceof CartaPokemon) {
            CartaPokemon pokemon = (CartaPokemon) carta;
            return carta.getNombre() + ";" + carta.getRareza() + ";" + carta.getTipo() + ";"
                    + pokemon.getDano() + ";" + pokemon.getCantEnergias();
        }

        if (carta instanceof CartaItem) {
            CartaItem item = (CartaItem) carta;
            return carta.getNombre() + ";" + carta.getRareza() + ";" + carta.getTipo() + ";"
                    + item.getBonificacion();
        }

        if (carta instanceof CartaSupporter) {
            CartaSupporter supporter = (CartaSupporter) carta;
            return carta.getNombre() + ";" + carta.getRareza() + ";" + carta.getTipo() + ";"
                    + supporter.getEfectosPorTurno();
        }

        if (carta instanceof CartaEnergy) {
            CartaEnergy energy = (CartaEnergy) carta;
            return carta.getNombre() + ";" + carta.getRareza() + ";" + carta.getTipo() + ";"
                    + energy.getElemento();
        }

        throw new IllegalArgumentException("Tipo de carta no soportado: " + carta.getTipo());
    }
}
