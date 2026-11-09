import estructuras.ArbolBinario;
import estructuras.Cola;
import estructuras.Stack;
import modelo.Operacion;
import modelo.Solicitud;
import servicio.Ejercicios;

public class Main {

    public static void main(String[] args) {
        probarPunto1();
        probarPunto2();
        probarPunto3();
        probarPunto4();
    }

    private static void probarPunto1() {
        System.out.println("===== PUNTO 1 =====");
        Stack<Operacion> historial = new Stack<>();
        historial.push(new Operacion("O1", Operacion.ANULADA));
        historial.push(new Operacion("O2", Operacion.CONFIRMADA));
        historial.push(new Operacion("O3", Operacion.CONFIRMADA));
        historial.push(new Operacion("O4", Operacion.ANULADA));
        historial.push(new Operacion("O5", Operacion.CONFIRMADA));

        System.out.println("Historial: " + textoPila(historial));
        System.out.println("n = 2:  " + textoPila(Ejercicios.obtenerUltimasConfirmadas(historial, 2)));
        System.out.println("n = 10: " + textoPila(Ejercicios.obtenerUltimasConfirmadas(historial, 10)));
        System.out.println("n = 0:  " + textoPila(Ejercicios.obtenerUltimasConfirmadas(historial, 0)));
        System.out.println("Historial al final: " + textoPila(historial));
    }

    private static void probarPunto2() {
        System.out.println("\n===== PUNTO 2 =====");
        Stack<String> acciones = new Stack<>();
        acciones.push("A1");
        acciones.push("A2");
        acciones.push("A3");
        acciones.push("A4");
        acciones.push("A5");
        acciones.push("A6");

        System.out.println("Original: " + textoPila(acciones));
        System.out.println("inicio 2, fin 4: " + textoPila(Ejercicios.obtenerSegmento(acciones, 2, 4)));
        System.out.println("inicio 3, fin 3: " + textoPila(Ejercicios.obtenerSegmento(acciones, 3, 3)));
        System.out.println("inicio 0, fin 2: " + textoPila(Ejercicios.obtenerSegmento(acciones, 0, 2)));
        System.out.println("inicio 4, fin 2: " + textoPila(Ejercicios.obtenerSegmento(acciones, 4, 2)));
        System.out.println("inicio 2, fin 7: " + textoPila(Ejercicios.obtenerSegmento(acciones, 2, 7)));
        System.out.println("Original al final: " + textoPila(acciones));
    }

    private static void probarPunto3() {
        System.out.println("\n===== PUNTO 3 =====");
        Cola<Solicitud> pendientes = crearPendientes();
        System.out.println("Pendientes: " + pendientes);
        Cola<Solicitud> seleccionadas = Ejercicios.seleccionarSolicitudes(pendientes, 25);
        System.out.println("Con 25 min, seleccionadas: " + seleccionadas);
        System.out.println("Con 25 min, pendientes: " + pendientes);

        Cola<Solicitud> otras = crearPendientes();
        System.out.println("Con 0 min, seleccionadas: " + Ejercicios.seleccionarSolicitudes(otras, 0));
        System.out.println("Con 0 min, pendientes: " + otras);
    }

    private static Cola<Solicitud> crearPendientes() {
        Cola<Solicitud> pendientes = new Cola<>();
        pendientes.encolar(new Solicitud("S1", Solicitud.NORMAL, 10));
        pendientes.encolar(new Solicitud("S2", Solicitud.ALTA, 30));
        pendientes.encolar(new Solicitud("S3", Solicitud.ALTA, 15));
        pendientes.encolar(new Solicitud("S4", Solicitud.NORMAL, 5));
        return pendientes;
    }

    private static void probarPunto4() {
        System.out.println("\n===== PUNTO 4a =====");
        ArbolBinario<Integer> equipos = new ArbolBinario<>();
        int[] codigos = {50, 30, 70, 20, 40, 60, 80, 55, 65};
        for (int codigo : codigos) {
            equipos.insertar(codigo);
        }

        System.out.println("Rango 40 a 65: " + Ejercicios.contarEquiposEnRango(equipos.getRaiz(), 40, 65));
        System.out.println("Rango 20 a 80: " + Ejercicios.contarEquiposEnRango(equipos.getRaiz(), 20, 80));
        System.out.println("Rango 65 a 65: " + Ejercicios.contarEquiposEnRango(equipos.getRaiz(), 65, 65));
        System.out.println("Rango 1 a 10: " + Ejercicios.contarEquiposEnRango(equipos.getRaiz(), 1, 10));
        System.out.println("Rango 70 a 40: " + Ejercicios.contarEquiposEnRango(equipos.getRaiz(), 70, 40));
        System.out.println("Arbol vacio: " + Ejercicios.contarEquiposEnRango(null, 1, 10));
    }

    // Trabaja sobre una copia para no vaciar la pila que se quiere mostrar
    private static <T> String textoPila(Stack<T> pila) {
        Stack<T> copia = pila.clonar();
        StringBuilder sb = new StringBuilder("[");
        while (!copia.isEmpty()) {
            sb.append(copia.pop());
            if (!copia.isEmpty()) sb.append(" -> ");
        }
        return sb.append("]").toString();
    }
}
