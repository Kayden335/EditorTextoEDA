package Main;
import editor.EditorTexto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        EditorTexto editor = new EditorTexto();
        int opcion;
        do {
            System.out.println("\n---------------------------------");
            System.out.println("      EDITOR DE TEXTO ");
            System.out.println("---------------------------------");
            System.out.println("1. Mostrar documento");
            System.out.println("2. Insertar linea");
            System.out.println("3. Editar linea");
            System.out.println("4. Eliminar linea");
            System.out.println("5. Deshacer (Undo)");
            System.out.println("6. Rehacer (Redo)");
            System.out.println("7. Mostrar pila Undo");
            System.out.println("8. Mostrar pila Redo");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    editor.mostrarDocumento();
                    break;
                case 2:
                    System.out.print("Posicion: ");
                    int posInsertar = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Texto: ");
                    String texto = teclado.nextLine();
                    editor.insertarLinea(posInsertar, texto);
                    break;
                case 3:
                    System.out.print("Posicion: ");
                    int posEditar = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nuevo texto: ");
                    String nuevoTexto = teclado.nextLine();
                    editor.editarLinea(posEditar, nuevoTexto);
                    break;
                case 4:
                    System.out.print("Posicion: ");
                    int posEliminar = teclado.nextInt();
                    editor.eliminarLinea(posEliminar);
                    break;
                case 5:
                    editor.deshacer();
                    break;
                case 6:
                    editor.rehacer();
                    break;
                case 7:
                    editor.mostrarUndo();
                    break;
                case 8:
                    editor.mostrarRedo();
                    break;
                case 9:
                    System.out.println("\nPrograma finalizado.");
                    break;
                default:
                    System.out.println("\nOpcion invalida.");
            }
        } while (opcion != 9);
        teclado.close();
    }
}