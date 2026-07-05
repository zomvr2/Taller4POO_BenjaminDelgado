package domain;

import patrones.CartaVisitor;

public class CartaEnergy extends Carta {
    private String elemento;

    public CartaEnergy(String nombre, int rareza, String elemento) {
        super(nombre, rareza, "Energy");
        this.elemento = elemento;
    }

    @Override
    public double aceptar(CartaVisitor visitor) {
        return visitor.visitar(this);
    }
}
