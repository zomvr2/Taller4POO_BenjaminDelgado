package domain;

public class CartaItem extends Carta {
    private int bonificacion;

    public CartaItem(String nombre, int rareza, int bonificacion) {
        super(nombre, rareza);
        this.bonificacion = bonificacion;
    }
}
