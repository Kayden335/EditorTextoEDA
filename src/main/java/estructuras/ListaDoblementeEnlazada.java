package estructuras;

public class ListaDoblementeEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }
    public boolean estaVacia() {
        return tamaño == 0;
    }
    public int getTamaño() {
        return tamaño;
    }
    
    // Inserta una nueva línea al final del documento
public void insertarFinal(String texto) {
    Nodo nuevo = new Nodo(texto);
    if (estaVacia()) {
        primero = nuevo;
        ultimo = nuevo;
    } else {
        ultimo.setSiguiente(nuevo);
        nuevo.setAnterior(ultimo);
        ultimo = nuevo;
    }
    tamaño++;
}

// Muestra todas las líneas del documento
public void mostrar() {
    if (estaVacia()) {
        System.out.println("El documento está vacío.");
        return;
    }
    
    Nodo actual = primero;
    int linea = 1;
    while (actual != null) {
        System.out.println(linea + ". " + actual.getTexto());
        actual = actual.getSiguiente();
        linea++;

    }
  }
}
