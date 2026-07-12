package estructuras;

public class Pila {

    private NodoPila cima;
    private int tamaño;

    // Constructor
    public Pila() {
        cima = null;
        tamaño = 0;
    }

    // Verifica si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Devuelve la cantidad de elementos
    public int getTamaño() {
        return tamaño;
    }

    // Agrega un elemento a la pila
    public void push(Object dato) {
        NodoPila nuevo = new NodoPila(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamaño++;
    }

    // Elimina el elemento superior
    public Object pop() {
        if (estaVacia()) {
            return null;
        }
        Object dato = cima.getDato();
        cima = cima.getSiguiente();
        tamaño--;
        return dato;
    }

    // Devuelve el elemento superior sin eliminarlo
    public Object peek() {
        if (estaVacia()) {
            return null;
        }
        return cima.getDato();
    }

    // Vacía completamente la pila
    public void vaciar() {
        cima = null;
        tamaño = 0;
    }

    // Muestra el contenido de la pila
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La pila esta vacia.");
            return;
        }
        NodoPila actual = cima;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

}