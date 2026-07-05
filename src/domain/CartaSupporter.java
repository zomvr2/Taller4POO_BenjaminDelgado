package domain;

import patrones.CartaVisitor;

/**
 * Representa una carta de supporter con efectos disponibles por turno.
 */
public class CartaSupporter extends Carta {
    private int efectosPorTurno;

    /**
     * Crea una carta de supporter.
     *
     * @param nombre nombre de la carta
     * @param rareza rareza numerica de la carta
     * @param efectosPorTurno cantidad de efectos por turno
     */
    public CartaSupporter(String nombre, int rareza, int efectosPorTurno) {
        super(nombre, rareza, "Supporter");
        this.efectosPorTurno = efectosPorTurno;
    }

    /**
     * Obtiene la cantidad de efectos por turno.
     *
     * @return efectos por turno
     */
    public int getEfectosPorTurno() {
        return efectosPorTurno;
    }

    /**
     * Cambia la cantidad de efectos por turno.
     *
     * @param efectosPorTurno nueva cantidad de efectos por turno
     */
    public void setEfectosPorTurno(int efectosPorTurno) {
        this.efectosPorTurno = efectosPorTurno;
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
