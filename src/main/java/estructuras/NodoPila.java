package estructuras;

public class NodoPila {

    private Object dato;
    private NodoPila siguiente;

    // Constructor
    public NodoPila(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Getters y Setters
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}