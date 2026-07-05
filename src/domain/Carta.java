package domain;

import patrones.CartaVisitor;

/**
 * Representa una carta base de la coleccion.
 * <p>
 * Guarda los datos comunes a todos los tipos de carta y delega el calculo de
 * comportamiento especifico mediante el patron Visitor.
 */
public abstract class Carta {
    private String nombre;
    private int rareza;
    private String rutaImagen;
    private String tipo;

    /**
     * Crea una carta con sus datos comunes.
     *
     * @param nombre nombre visible de la carta
     * @param rareza valor numerico usado para ordenar o comparar rareza
     * @param tipo tipo de carta
     */
    public Carta(String nombre, int rareza, String tipo) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.rutaImagen = "src/files/imagenes/" + nombre + ".png";
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre de la carta.
     *
     * @return nombre de la carta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la rareza de la carta.
     *
     * @return rareza numerica de la carta
     */
    public int getRareza() {
        return rareza;
    }

    /**
     * Obtiene la ruta de imagen asociada a la carta.
     *
     * @return ruta de la imagen de la carta
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * Obtiene el tipo de carta.
     *
     * @return tipo de carta
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Cambia el nombre de la carta y actualiza la ruta de imagen por defecto.
     *
     * @param nombre nuevo nombre de la carta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.rutaImagen = "src/files/imagenes/" + nombre + ".png";
    }

    /**
     * Cambia la rareza de la carta.
     *
     * @param rareza nueva rareza numerica
     */
    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    /**
     * Cambia la ruta de imagen de la carta.
     *
     * @param rutaImagen nueva ruta de imagen
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Acepta un visitor para ejecutar operaciones dependientes del tipo real
     * de carta.
     *
     * @param visitor visitor que procesa la carta
     * @return resultado numerico de la operacion del visitor
     */
    public abstract double aceptar(CartaVisitor visitor);
}
