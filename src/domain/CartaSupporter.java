package domain;

public class CartaSupporter extends Carta {
    private int efectosPorTurno;

    public CartaSupporter(String nombre, int rareza, int efectosPorTurno) {
        super(nombre, rareza);
        this.efectosPorTurno = efectosPorTurno;
    }
}
