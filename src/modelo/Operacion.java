package modelo;

public class Operacion {

    public static final String CONFIRMADA = "CONFIRMADA";
    public static final String ANULADA = "ANULADA";

    private String codigo;
    private String estado;

    public Operacion(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }

    public String getEstado() { return estado; }

    public boolean estaConfirmada() { return CONFIRMADA.equals(estado); }

    @Override
    public String toString() {
        return codigo + " (" + estado + ")";
    }
}
