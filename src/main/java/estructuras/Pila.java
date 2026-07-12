package estructuras;

public class Pila {

    private NodoPila cima;
    private int tamaño;

    public Pila() {
        cima = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getTamaño() {
        return tamaño;
    }
    // Agrega un elemento a la cima de la pila
    public void push(Object dato) {
    NodoPila nuevo = new NodoPila(dato);
    nuevo.setSiguiente(cima);
    cima = nuevo;
    tamaño++;

    }
    // Devuelve el elemento de la cima sin eliminarlo
    public Object peek() {
        if (estaVacia()) {
        return null;
        }
        return cima.getDato();
     }
    // Elimina y devuelve el elemento de la cima
    public Object pop() {
    if (estaVacia()) {
        return null;
    }
    Object dato = cima.getDato();
    cima = cima.getSiguiente();
    tamaño--;
    return dato;
    }
}