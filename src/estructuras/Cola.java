package estructuras;

public class Cola<T> {

    private int size;
    private NodeSimple<T> firstNode;
    private NodeSimple<T> lastNode;

    public Cola() {
        this.size = 0;
        firstNode = null;
        lastNode = null;
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return firstNode == null; }

    public void encolar(T data) {
        NodeSimple<T> newNodeSimple = new NodeSimple<>(data);
        if (isEmpty()) {
            firstNode = newNodeSimple;
            lastNode = newNodeSimple;
        } else {
            lastNode.setNext(newNodeSimple);
            lastNode = newNodeSimple;
        }
        size++;
    }

    public T desencolar() {
        if (isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        } else {
            T data = firstNode.getData();
            firstNode = firstNode.getNext();
            if (firstNode == null) {
                lastNode = null;
            }
            size--;
            return data;
        }
    }

    // Limpiar toda la cola
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

 

    //  Clonar cola
    public Cola<T> clonar() {
        Cola<T> copia = new Cola<>();
        NodeSimple<T> actual = firstNode;
        while (actual != null) {
            copia.encolar(actual.getData());
            actual = actual.getNext();
        }
        return copia;
    }

    //  Son identicas
    public boolean sonIdenticas(Cola<T> otra) {
        if (otra == null || this.size != otra.size) {
            return false;
        }
        NodeSimple<T> a = this.firstNode;
        NodeSimple<T> b = otra.firstNode;
        while (a != null) {
            if (a.getData() == null ? b.getData() != null
                                    : !a.getData().equals(b.getData())) {
                return false;
            }
            a = a.getNext();
            b = b.getNext();
        }
        return true;
    }

    //  Invertir cola recursivo
    public void invertirColaRecursivo() {
        if (isEmpty()) {
            return;
        }
        T dato = desencolar();
        invertirColaRecursivo();
        encolar(dato);
    }

    //  Invertir cola usando pila
    public void invertirColaConPila() {
        Stack<T> pila = new Stack<>();
        while (!isEmpty()) {
            pila.push(desencolar());
        }
        while (!pila.isEmpty()) {
            encolar(pila.pop());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodeSimple<T> actual = firstNode;
        while (actual != null) {
            sb.append(actual.getData());
            if (actual.getNext() != null) sb.append(", ");
            actual = actual.getNext();
        }
        return sb.append("]").toString();
    }
}