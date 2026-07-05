// Benjamín Felipe Delgado Sánchez - 22.223.703-3

import gui.MainWindow;
import logic.Sistema;
import logic.SistemaImpl;

/**
 * Punto de entrada de la aplicacion de gestion de cartas.
 */
public class Main {
    /**
     * Inicializa el sistema y muestra la ventana principal.
     *
     * @param args argumentos de linea de comandos no utilizados
     */
    public static void main(String[] args) {
        Sistema sistema = SistemaImpl.getInstance();
        MainWindow mainWindow = new MainWindow(sistema);

        mainWindow.setVisible(true);
    }
}
