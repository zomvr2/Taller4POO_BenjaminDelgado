package domain;

import patrones.CartaVisitor;

/**
 * Representa una carta de item con una bonificacion numerica.
 */
public class CartaItem extends Carta {
    private int bonificacion;

    /**
     * Crea una carta de item.
     *
     * @param nombre nombre de la carta
     * @param rareza rareza numerica de la carta
     * @param bonificacion valor de bonificacion del item
     */
    public CartaItem(String nombre, int rareza, int bonificacion) {
        super(nombre, rareza, "Item");
        this.bonificacion = bonificacion;
    }

    /**
     * Obtiene la bonificacion del item.
     *
     * @return bonificacion numerica
     */
    public int getBonificacion() {
        return bonificacion;
    }

    /**
     * Cambia la bonificacion del item.
     *
     * @param bonificacion nueva bonificacion
     */
    public void setBonificacion(int bonificacion) {
        this.bonificacion = bonificacion;
    }

    /**
     * Acepta un visitor para calcular o procesar esta carta.
     *
     * @param visitor visitor que procesara la carta
     * @return resultado numerico del visitor
     */
    @Override
    public double aceptar(CartaVisitor visitor) {
        return visitor.visitar(this);
    }
}
