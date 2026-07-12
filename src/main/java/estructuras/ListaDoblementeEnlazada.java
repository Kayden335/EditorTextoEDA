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
// Edita el texto de una línea
public void editar(int posicion, String nuevoTexto) {

    if (posicion < 1 || posicion > tamaño) {
        System.out.println("Posición inválida.");
        return;
    }

    Nodo actual = primero;

    for (int i = 1; i < posicion; i++) {
        actual = actual.getSiguiente();
    }

    actual.setTexto(nuevoTexto);
}

// Elimina una línea del documento
public void eliminar(int posicion) {

    if (posicion < 1 || posicion > tamaño) {
        System.out.println("Posición inválida.");
        return;
    }

    // Caso 1: solo existe un nodo
    if (tamaño == 1) {
        primero = null;
        ultimo = null;
        tamaño--;
        return;
    }

    // Caso 2: eliminar el primero
    if (posicion == 1) {
        primero = primero.getSiguiente();
        primero.setAnterior(null);
        tamaño--;
        return;
    }

    // Caso 3: eliminar el último
    if (posicion == tamaño) {
        ultimo = ultimo.getAnterior();
        ultimo.setSiguiente(null);
        tamaño--;
        return;
    }

    // Caso 4: eliminar un nodo intermedio
    Nodo actual = primero;

    for (int i = 1; i < posicion; i++) {
        actual = actual.getSiguiente();
    }

    Nodo anterior = actual.getAnterior();
    Nodo siguiente = actual.getSiguiente();

    anterior.setSiguiente(siguiente);
    siguiente.setAnterior(anterior);

    tamaño--;
}
// Devuelve el texto de una línea
public String obtenerTexto(int posicion) {

    if (posicion < 1 || posicion > tamaño) {
        return null;
    }

    Nodo actual = primero;

    for (int i = 1; i < posicion; i++) {
        actual = actual.getSiguiente();
    }

    return actual.getTexto();

}
}
