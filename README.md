# Parcial 2 - Estructuras de Datos

Integrantes: Tomas Suaza y Juan Esteban Herrera.

## Qué hay en cada carpeta

- `src/estructuras`: la pila, la cola y el árbol que hicimos en clase.
- `src/modelo`: las clases `Operacion` y `Solicitud`.
- `src/servicio/Ejercicios.java`: la solución de los puntos 1, 2, 3 y 4a.
- `src/Main.java`: prueba cada punto con los ejemplos del parcial.

## Cómo ejecutarlo

Desde la carpeta del proyecto:

    javac -d out $(find src -name "*.java")
    java -cp out Main
