package patrones;

import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;

/**
 * Visitor para ejecutar operaciones sobre cada tipo concreto de carta.
 */
public interface CartaVisitor {
    /**
     * Procesa una carta de energia.
     *
     * @param carta carta de energia
     * @return resultado numerico de la operacion
     */
    double visitar(CartaEnergy carta);

    /**
     * Procesa una carta de item.
     *
     * @param carta carta de item
     * @return resultado numerico de la operacion
     */
    double visitar(CartaItem carta);

    /**
     * Procesa una carta de Pokemon.
     *
     * @param carta carta de Pokemon
     * @return resultado numerico de la operacion
     */
    double visitar(CartaPokemon carta);

    /**
     * Procesa una carta de supporter.
     *
     * @param carta carta de supporter
     * @return resultado numerico de la operacion
     */
    double visitar(CartaSupporter carta);
}
