package logic;

import java.util.ArrayList;
import domain.Carta;

/**
 * Define las operaciones principales del sistema de gestion de cartas.
 */
public interface Sistema {
    /**
     * Carga las cartas desde la fuente de datos configurada.
     */
    void cargarCartas();

    /**
     * Obtiene la coleccion actual de cartas.
     *
     * @return lista de cartas cargadas en memoria
     */
    ArrayList<Carta> getCartas();

    /**
     * Agrega una carta a la coleccion y persiste el cambio.
     *
     * @param carta carta que se agregara
     * @return {@code true} si la carta fue agregada y guardada correctamente
     */
    boolean agregarCarta(Carta carta);

    /**
     * Elimina una carta segun su indice en la coleccion.
     *
     * @param indice posicion de la carta que se eliminara
     * @return {@code true} si la carta fue eliminada y el cambio fue guardado
     */
    boolean eliminarCarta(int indice);

    /**
     * Reemplaza una carta existente por una version modificada.
     *
     * @param indice posicion de la carta original
     * @param cartaModificada carta con los nuevos atributos permitidos
     * @return {@code true} si la modificacion fue aceptada y guardada
     */
    boolean modificarCarta(int indice, Carta cartaModificada);

    /**
     * Guarda la coleccion actual en la fuente de datos configurada.
     *
     * @return {@code true} si el guardado finalizo correctamente
     */
    boolean guardarCartas();
}
