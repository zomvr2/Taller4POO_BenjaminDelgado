package domain;

import patrones.CartaVisitor;

public abstract class Carta {
    private String nombre;
    private int rareza;
    private String rutaImagen;
    private String tipo;

    public Carta(String nombre, int rareza, String tipo) {
        this.nombre = nombre;
        this.rareza = rareza;
        this.rutaImagen = "src/files/imagenes/" + nombre + ".png";
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRareza() {
        return rareza;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.rutaImagen = "src/files/imagenes/" + nombre + ".png";
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public abstract double aceptar(CartaVisitor visitor);
}
