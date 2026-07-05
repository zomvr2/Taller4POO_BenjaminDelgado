# Taller 4 - TCG Manager

Aplicacion Java Swing para administrar una coleccion de cartas tipo TCG. Permite cargar cartas desde archivo, visualizarlas, ordenarlas y administrar la coleccion agregando, modificando o eliminando cartas.

## Funcionalidades

- Carga inicial de cartas desde `src/files/sobres.txt`.
- Visualizacion de cartas en una grilla con imagen.
- Vista detallada de cada carta.
- Ordenamiento por rareza, nombre y poder.
- Administracion de cartas desde la interfaz grafica.
- Persistencia de cambios en el archivo de cartas.

## Estructura

- `src/domain`: clases del dominio de cartas.
- `src/logic`: interfaz e implementacion del sistema.
- `src/patrones`: factory, visitor y estrategias de ordenamiento.
- `src/gui`: ventanas y paneles de la interfaz grafica.
- `src/files`: archivo de datos e imagenes de cartas.

## Ejecucion

Compilar desde la raiz del proyecto:

```bash
javac -d out src/Main.java src/domain/*.java src/logic/*.java src/patrones/*.java src/gui/*.java
```

Ejecutar:

```bash
java -cp out Main
```

Tambien se puede ejecutar desde IntelliJ IDEA usando la clase `Main`.

## Formato de cartas

El archivo `src/files/sobres.txt` usa lineas con formato:

```text
Nombre;Rareza;Tipo;Atributos...
```

Ejemplos:

```text
Pikachu;3;Pokemon;60;2
Potion;1;Item;2
Fire Energy;1;Energy;Fuego
```
