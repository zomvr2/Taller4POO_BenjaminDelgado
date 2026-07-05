// Benjamín Felipe Delgado Sánchez - 22.223.703-3

import gui.MainWindow;
import logic.Sistema;
import logic.SistemaImpl;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = SistemaImpl.getInstance();
        MainWindow mainWindow = new MainWindow(sistema);

        mainWindow.setVisible(true);
    }
}
