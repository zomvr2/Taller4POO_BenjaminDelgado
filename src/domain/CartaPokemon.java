package domain;

import patrones.CartaVisitor;

public class CartaPokemon extends Carta {
    private int dano;
    private int cantEnergias;

    public CartaPokemon(String nombre, int rareza, int dano, int cantEnergias) {
        super(nombre, rareza, "Pokemon");
        this.dano = dano;
        this.cantEnergias = cantEnergias;
    }

    public int getCantEnergias() {
        return cantEnergias;
    }

    public void setCantEnergias(int cantEnergias) {
        this.cantEnergias = cantEnergias;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    @Override
    public double aceptar(CartaVisitor visitor) {
        return visitor.visitar(this);
    }
}
