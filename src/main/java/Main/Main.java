package Main;
import estructuras.ListaDoblementeEnlazada;
import estructuras.Pila;
public class Main {

    public static void main(String[] args) {
        
        ListaDoblementeEnlazada documento = new ListaDoblementeEnlazada();
        documento.insertarFinal("Hola");
        documento.insertarFinal("Bienvenidos");
        documento.insertarFinal("Proyecto EDA");
        documento.insertarFinal("Editor de Texto");
        documento.mostrar();
        // Edita el texto de una línea
        System.out.println();
        documento.editar(2, "Estructuras de Datos");
        System.out.println("Despues de editar:");
        documento.mostrar();
        //Eliminar un nodo 
        System.out.println();
        documento.eliminar(3);
        System.out.println("Despues de eliminar:");
        documento.mostrar();
        // Devuelve el texto de una línea
        System.out.println();
        String texto = documento.obtenerTexto(2);
        System.out.println("Texto de la linea 2:");
        System.out.println(texto);
        //Implementacion pila
        Pila pila = new Pila();
        System.out.println();
        System.out.println("¿La pila esta vacia?: " + pila.estaVacia());
        System.out.println("Tamano de la pila: " + pila.getTamaño());
        //poner algo a la pila en la cima
        pila.push("Insertar");
        pila.push("Editar");
        pila.push("Eliminar");

        System.out.println();
        System.out.println("Elementos en la pila: " + pila.getTamaño());
        //Elemento en la cima
        System.out.println();
        System.out.println("Elemento en la cima:");
        System.out.println(pila.peek());
        
        //Eliminar y mostrar
        System.out.println();
        System.out.println("Elemento eliminado:");
        System.out.println(pila.pop());
        System.out.println();
        System.out.println("Nueva cima:");
        System.out.println(pila.peek());
        System.out.println();
        System.out.println("Cantidad:");
        System.out.println(pila.getTamaño());
    }
}
