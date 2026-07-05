package domain;

import patrones.CartaVisitor;

/**
 * Representa una carta de Pokemon con dano y cantidad de energias requeridas.
 */
public class CartaPokemon extends Carta {
    private int dano;
    private int cantEnergias;

    /**
     * Crea una carta de Pokemon.
     *
     * @param nombre nombre de la carta
     * @param rareza rareza numerica de la carta
     * @param dano dano que realiza la carta
     * @param cantEnergias cantidad de energias requeridas, mayor que cero
     */
    public CartaPokemon(String nombre, int rareza, int dano, int cantEnergias) {
        super(nombre, rareza, "Pokemon");
        this.dano = dano;
        setCantEnergias(cantEnergias);
    }

    /**
     * Obtiene la cantidad de energias requeridas.
     *
     * @return cantidad de energias
     */
    public int getCantEnergias() {
        return cantEnergias;
    }

    /**
     * Cambia la cantidad de energias requeridas.
     *
     * @param cantEnergias nueva cantidad de energias, mayor que cero
     * @throws IllegalArgumentException si la cantidad no es mayor que cero
     */
    public void setCantEnergias(int cantEnergias) {
        if (cantEnergias <= 0) {
            throw new IllegalArgumentException("La cantidad de energias debe ser mayor que cero.");
        }
        this.cantEnergias = cantEnergias;
    }

    /**
     * Obtiene el dano de la carta.
     *
     * @return dano numerico
     */
    public int getDano() {
        return dano;
    }

    /**
     * Cambia el dano de la carta.
     *
     * @param dano nuevo dano
     */
    public void setDano(int dano) {
        this.dano = dano;
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
