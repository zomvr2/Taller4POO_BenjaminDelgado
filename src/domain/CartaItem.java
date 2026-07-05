package domain;

import patrones.CartaVisitor;

public class CartaItem extends Carta {
    private int bonificacion;

    public CartaItem(String nombre, int rareza, int bonificacion) {
        super(nombre, rareza, "Item");
        this.bonificacion = bonificacion;
    }

    public int getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(int bonificacion) {
        this.bonificacion = bonificacion;
    }

    @Override
    public double aceptar(CartaVisitor visitor) {
        return visitor.visitar(this);
    }
}
