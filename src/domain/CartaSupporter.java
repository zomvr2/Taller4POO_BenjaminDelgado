package domain;

import patrones.CartaVisitor;

public class CartaSupporter extends Carta {
    private int efectosPorTurno;

    public CartaSupporter(String nombre, int rareza, int efectosPorTurno) {
        super(nombre, rareza, "Supporter");
        this.efectosPorTurno = efectosPorTurno;
    }

    public int getEfectosPorTurno() {
        return efectosPorTurno;
    }

    @Override
    public double aceptar(CartaVisitor visitor) {
        return visitor.visitar(this);
    }
}
