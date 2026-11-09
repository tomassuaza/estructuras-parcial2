package servicio;

import estructuras.Cola;
import estructuras.NodoArbol;
import estructuras.Stack;
import modelo.Operacion;
import modelo.Solicitud;

public class Ejercicios {

    // ---------- Punto 1 ----------
    public static Stack<Operacion> obtenerUltimasConfirmadas(Stack<Operacion> historial, int n) {
        Stack<Operacion> resultado = new Stack<>();
        if (historial == null || n <= 0) {
            return resultado;
        }

        Stack<Operacion> aux = new Stack<>();
        Stack<Operacion> confirmadas = new Stack<>();
        int contador = 0;

        // Sacamos desde el tope hasta completar n confirmadas o acabar la pila
        while (!historial.isEmpty() && contador < n) {
            Operacion operacion = historial.pop();
            aux.push(operacion);
            if (operacion.estaConfirmada()) {
                confirmadas.push(operacion);
                contador++;
            }
        }

        // Devolvemos al historial lo que sacamos para dejarlo igual
        while (!aux.isEmpty()) {
            historial.push(aux.pop());
        }

        // Confirmadas quedo al reves, asi la mas reciente termina en el tope
        while (!confirmadas.isEmpty()) {
            resultado.push(confirmadas.pop());
        }
        return resultado;
    }

    // ---------- Punto 2 ----------
    public static Stack<String> obtenerSegmento(Stack<String> pila, int inicio, int fin) {
        Stack<String> resultado = new Stack<>();
        if (pila == null || inicio < 1 || inicio > fin || fin > pila.getSize()) {
            return resultado;
        }

        Stack<String> aux = new Stack<>();
        Stack<String> segmento = new Stack<>();
        int posicion = 1;

        // Solo hay que sacar hasta la posicion fin
        while (posicion <= fin) {
            String accion = pila.pop();
            aux.push(accion);
            if (posicion >= inicio) {
                segmento.push(accion);
            }
            posicion++;
        }

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }

        // Al pasarlo queda la accion de la posicion inicio en el tope
        while (!segmento.isEmpty()) {
            resultado.push(segmento.pop());
        }
        return resultado;
    }

    // ---------- Punto 3 ----------
    public static Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> pendientes, int minutos) {
        Cola<Solicitud> seleccionadas = new Cola<>();
        if (pendientes == null || minutos <= 0) {
            return seleccionadas;
        }

        int restante = seleccionarPorPrioridad(pendientes, seleccionadas, Solicitud.ALTA, minutos);
        seleccionarPorPrioridad(pendientes, seleccionadas, Solicitud.NORMAL, restante);
        return seleccionadas;
    }

    // Da una vuelta completa a la cola y retorna los minutos que quedan
    private static int seleccionarPorPrioridad(Cola<Solicitud> pendientes, Cola<Solicitud> seleccionadas,
                                               String prioridad, int restante) {
        int tamano = pendientes.getSize();
        for (int i = 0; i < tamano; i++) {
            Solicitud solicitud = pendientes.desencolar();
            if (solicitud.getPrioridad().equals(prioridad) && solicitud.getDuracion() <= restante) {
                seleccionadas.encolar(solicitud);
                restante -= solicitud.getDuracion();
            } else {
                pendientes.encolar(solicitud);
            }
        }
        return restante;
    }

    // ---------- Punto 4a ----------
    public static int contarEquiposEnRango(NodoArbol<Integer> raiz, int inferior, int superior) {
        if (raiz == null || inferior > superior) {
            return 0;
        }

        int codigo = raiz.getElemento();

        // Si el codigo es menor al rango, a la izquierda solo hay codigos mas pequenos
        if (codigo < inferior) {
            return contarEquiposEnRango(raiz.getDerecho(), inferior, superior);
        }
        // Si el codigo es mayor al rango, a la derecha solo hay codigos mas grandes
        if (codigo > superior) {
            return contarEquiposEnRango(raiz.getIzquierdo(), inferior, superior);
        }

        return 1 + contarEquiposEnRango(raiz.getIzquierdo(), inferior, superior)
                 + contarEquiposEnRango(raiz.getDerecho(), inferior, superior);
    }
}
