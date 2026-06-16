package domain;

public class CartaEnergy extends Carta {
    private String elemento;

    public CartaEnergy(String nombre, int rareza, String elemento) {
        super(nombre, rareza);
        this.elemento = elemento;
    }
}
