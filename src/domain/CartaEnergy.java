package domain;

import patrones.CartaVisitor;

/**
 * Representa una carta de energia.
 */
public class CartaEnergy extends Carta {
    private String elemento;

    /**
     * Crea una carta de energia.
     *
     * @param nombre nombre de la carta
     * @param rareza rareza numerica de la carta
     * @param elemento elemento asociado a la energia
     */
    public CartaEnergy(String nombre, int rareza, String elemento) {
        super(nombre, rareza, "Energy");
        this.elemento = elemento;
    }

    /**
     * Obtiene el elemento de la energia.
     *
     * @return elemento de la carta
     */
    public String getElemento() {
        return elemento;
    }

    /**
     * Cambia el elemento de la energia.
     *
     * @param elemento nuevo elemento
     */
    public void setElemento(String elemento) {
        this.elemento = elemento;
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
