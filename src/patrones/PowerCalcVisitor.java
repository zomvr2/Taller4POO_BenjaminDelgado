package patrones;

import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;

public class PowerCalcVisitor implements CartaVisitor {
    @Override
    public double visitar(CartaEnergy carta) {
        return 1;
    }

    @Override
    public double visitar(CartaItem carta) {
        return carta.getBonificacion() * 20;
    }

    @Override
    public double visitar(CartaPokemon carta) {
        if (carta.getCantEnergias() <= 0) {
            return 0;
        }
        return ((double) carta.getDano() / carta.getCantEnergias()) * 100;
    }

    @Override
    public double visitar(CartaSupporter carta) {
        return carta.getEfectosPorTurno() * 50;
    }
}
