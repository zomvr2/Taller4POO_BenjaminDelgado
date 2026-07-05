package patrones;

import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;

/**
 * Visitor que calcula el poder estimado de cada tipo de carta.
 */
public class PowerCalcVisitor implements CartaVisitor {
    /**
     * Calcula el poder de una carta de energia.
     *
     * @param carta carta evaluada
     * @return poder fijo de energia
     */
    @Override
    public double visitar(CartaEnergy carta) {
        return 1;
    }

    /**
     * Calcula el poder de una carta de item.
     *
     * @param carta carta evaluada
     * @return poder segun la bonificacion del item
     */
    @Override
    public double visitar(CartaItem carta) {
        return carta.getBonificacion() * 20;
    }

    /**
     * Calcula el poder de una carta de Pokemon.
     *
     * @param carta carta evaluada
     * @return poder segun dano y energias requeridas
     */
    @Override
    public double visitar(CartaPokemon carta) {
        if (carta.getCantEnergias() <= 0) {
            return 0;
        }
        return ((double) carta.getDano() / carta.getCantEnergias()) * 100;
    }

    /**
     * Calcula el poder de una carta de supporter.
     *
     * @param carta carta evaluada
     * @return poder segun sus efectos por turno
     */
    @Override
    public double visitar(CartaSupporter carta) {
        return carta.getEfectosPorTurno() * 50;
    }
}
