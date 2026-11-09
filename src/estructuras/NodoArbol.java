package estructuras;

public class NodoArbol<T extends Comparable<T>> {

    private T elemento;
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;
    private NodoArbol<T> padre;

    public NodoArbol(T elemento, NodoArbol<T> padre) {
        this.padre = padre;
        this.elemento = elemento;
    }

    public NodoArbol(T elemento) { this.elemento = elemento; }

    public T getElemento() { return elemento; }

    public void setElemento(T elemento) { this.elemento = elemento; }

    public NodoArbol<T> getIzquierdo() { return izquierdo; }

    public void setIzquierdo(NodoArbol<T> izquierdo) { this.izquierdo = izquierdo; }

    public NodoArbol<T> getDerecho() { return derecho; }

    public void setDerecho(NodoArbol<T> derecho) { this.derecho = derecho; }

    public NodoArbol<T> getPadre() { return padre; }

    public void setPadre(NodoArbol<T> padre) { this.padre = padre; }
}