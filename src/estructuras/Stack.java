package estructuras;

public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        } else {
            T data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return top.getData();
    }

    public void print() {
        Node<T> actual = top;
        while (actual != null) {
            System.out.println(actual.getData());
            actual = actual.getNext();
        }
    }

    // clonar pila
    public Stack<T> clonar() {
        Stack<T> aux = new Stack<>();
        Stack<T> copia = new Stack<>();

        Node<T> actual = top;
        while (actual != null) {
            aux.push(actual.getData());
            actual = actual.getNext();
        }

        while (!aux.isEmpty()) {
            copia.push(aux.pop());
        }

        return copia;
    }

    // Añadir todos los elementos de otra pila encima de esta
    public void addAll(Stack<T> otra) {
        Stack<T> aux = new Stack<>();

        Node<T> actual = otra.top;
        while (actual != null) {
            aux.push(actual.getData());
            actual = actual.getNext();
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }
    }
}
