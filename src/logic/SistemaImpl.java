package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import domain.Carta;
import patrones.CartaFactory;

public class SistemaImpl implements Sistema {
    private static SistemaImpl instancia;
    private ArrayList<Carta> cartas;

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
        File file = new File("src/files/sobres.txt");
        try (Scanner scanner = new Scanner(file)) {
            String linea;
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();

                Carta carta = CartaFactory.crearCarta(linea);
                cartas.add(carta);
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
}
