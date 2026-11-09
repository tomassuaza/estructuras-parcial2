package estructuras;

public class ArbolBinario<T extends Comparable<T>> {

    private NodoArbol<T> raiz;

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    // ---------- Altura ----------
    public int obtenerAltura() {
        return obtenerAltura(raiz);
    }

    private int obtenerAltura(NodoArbol<T> raiz) {
        if (raiz == null) {
            return 0;
        }
        int alturaIzquierda = obtenerAltura(raiz.getIzquierdo());
        int alturaDerecha = obtenerAltura(raiz.getDerecho());

        return 1 + (alturaIzquierda > alturaDerecha ? alturaIzquierda : alturaDerecha);
    }

    // ---------- Existe ----------
    public boolean existe(T elemento) {
        return existe(raiz, elemento);
    }

    private boolean existe(NodoArbol<T> raizAux, T elemento) {

        if (raizAux == null) {
            return false;
        }
        int comp = raizAux.getElemento().compareTo(elemento);

        if (comp == 0) {
            return true;
        }
        if (comp > 0) {
            return existe(raizAux.getIzquierdo(), elemento);
        } else {
            return existe(raizAux.getDerecho(), elemento);
        }
    }

    // ---------- Insertar ----------
    public void insertar(T elemento) {
        raiz = insertar(raiz, elemento);
    }

    private NodoArbol<T> insertar(NodoArbol<T> raizAux, T elemento) {
        if (raizAux == null) {
            return new NodoArbol<>(elemento);
        } else {
            int comp = raizAux.getElemento().compareTo(elemento);
            if (comp == 0) {
                throw new RuntimeException("Error: Ya existe ese elemento");
            }

            if (comp > 0) {
                raizAux.setIzquierdo(insertar(raizAux.getIzquierdo(), elemento));
            } else {
                raizAux.setDerecho(insertar(raizAux.getDerecho(), elemento));
            }
        }
        return raizAux;
    }
    // ---------- Eliminar ----------

    public void eliminar(T elemento) {
        raiz = eliminar(raiz, elemento);
    }

    private NodoArbol<T> eliminar(NodoArbol<T> raizAux, T elemento) {
        if (raizAux == null) {
            throw new RuntimeException("Error: No existe ese elemento");
        }

        int comp = raizAux.getElemento().compareTo(elemento);

        if (comp > 0) {
            raizAux.setIzquierdo(eliminar(raizAux.getIzquierdo(), elemento));
        } else if (comp < 0) {
            raizAux.setDerecho(eliminar(raizAux.getDerecho(), elemento));
        } else {
            // Encontramos el nodo a eliminar

            // Caso 1: hoja
            if (raizAux.getIzquierdo() == null && raizAux.getDerecho() == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (raizAux.getIzquierdo() == null) {
                return raizAux.getDerecho();
            }
            if (raizAux.getDerecho() == null) {
                return raizAux.getIzquierdo();
            }
            // Caso 3: dos hijos
            NodoArbol<T> mayor = obtenerMayor(raizAux.getIzquierdo());
            raizAux.setElemento(mayor.getElemento());
            raizAux.setIzquierdo(eliminar(raizAux.getIzquierdo(), mayor.getElemento()));
        }
        return raizAux;
    }

    private NodoArbol<T> obtenerMayor(NodoArbol<T> nodo) {
        while (nodo.getDerecho() != null) {
            nodo = nodo.getDerecho();
        }
        return nodo;
    }
}
