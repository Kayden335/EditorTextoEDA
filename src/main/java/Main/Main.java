package Main;
import estructuras.ListaDoblementeEnlazada;

public class Main {

    public static void main(String[] args) {
        ListaDoblementeEnlazada documento = new ListaDoblementeEnlazada();
        documento.insertarFinal("Hola");
        documento.insertarFinal("Bienvenidos");
        documento.insertarFinal("Proyecto EDA");
        documento.insertarFinal("Editor de Texto");
        documento.mostrar();
        
        System.out.println();
        documento.editar(2, "Estructuras de Datos");
        System.out.println("Despues de editar:");
        documento.mostrar();
        
        System.out.println();
        documento.eliminar(3);
        System.out.println("Despues de eliminar:");
        documento.mostrar();
        
        System.out.println();
        String texto = documento.obtenerTexto(2);
        System.out.println("Texto de la linea 2:");
        System.out.println(texto);
    }
}
