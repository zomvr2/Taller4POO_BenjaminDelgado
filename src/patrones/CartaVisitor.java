package patrones;

import domain.CartaEnergy;
import domain.CartaItem;
import domain.CartaPokemon;
import domain.CartaSupporter;

public interface CartaVisitor {
    double visitar(CartaEnergy carta);
    double visitar(CartaItem carta);
    double visitar(CartaPokemon carta);
    double visitar(CartaSupporter carta);
}
