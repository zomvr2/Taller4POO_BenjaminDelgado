package domain;

public class CartaPokemon extends Carta {
    private int dano;
    private int cantEnergias;

    public CartaPokemon(String nombre, int rareza, int dano, int cantEnergias) {
        super(nombre, rareza);
        this.dano = dano;
        this.cantEnergias = cantEnergias;
    }
}
