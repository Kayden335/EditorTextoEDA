package estructuras;

public class ListaDoblementeEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    // Constructor
    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return primero == null;
    }

    // Devuelve la cantidad de líneas
    public int getTamaño() {
        return tamaño;
    }

    // Inserta una línea al final
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

    // Inserta una línea en una posición
    public void insertar(int posicion, String texto) {
        if (posicion < 1 || posicion > tamaño + 1) {
            System.out.println("Posición inválida.");
            return;
        }
        if (posicion == tamaño + 1) {
            insertarFinal(texto);
            return;
        }

        Nodo nuevo = new Nodo(texto);

        // Insertar al inicio
        if (posicion == 1) {
            nuevo.setSiguiente(primero);
            if (primero != null) {
                primero.setAnterior(nuevo);
            }
            primero = nuevo;
            if (ultimo == null) {
                ultimo = nuevo;
            }
            tamaño++;
            return;
        }
        
        Nodo actual = primero;
        for (int i = 1; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        Nodo anterior = actual.getAnterior();
        anterior.setSiguiente(nuevo);
        nuevo.setAnterior(anterior);
        nuevo.setSiguiente(actual);
        actual.setAnterior(nuevo);

        tamaño++;
    }

    // Edita una línea
    public void editar(int posicion, String nuevoTexto) {
        Nodo actual = buscarNodo(posicion);
        if (actual != null) {
            actual.setTexto(nuevoTexto);
        } else {
            System.out.println("Posición inválida.");
        }
    }

    // Elimina una línea
    public void eliminar(int posicion) {
        Nodo actual = buscarNodo(posicion);
        if (actual == null) {
            System.out.println("Posición inválida.");
            return;
        }
        // Solo existe un nodo
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        }
        // Eliminar el primero
        else if (actual == primero) {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
        }
        // Eliminar el último
        else if (actual == ultimo) {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }
        // Eliminar uno del medio
        else {
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }
        tamaño--;
    }

    // Devuelve el texto de una línea
    public String obtenerTexto(int posicion) {
        Nodo actual = buscarNodo(posicion);
        if (actual == null) {
            return null;
        }
        return actual.getTexto();
    }

    // Muestra todo el documento
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

    // Busca un nodo por posición
    private Nodo buscarNodo(int posicion) {
        if (posicion < 1 || posicion > tamaño) {
            return null;
        }
        Nodo actual = primero;
        for (int i = 1; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }
}