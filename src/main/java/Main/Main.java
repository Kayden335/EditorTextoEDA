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
    }
}
