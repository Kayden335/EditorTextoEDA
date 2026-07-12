package estructuras;

public class Nodo {

    private String texto;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(String texto) {
        this.texto = texto;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}