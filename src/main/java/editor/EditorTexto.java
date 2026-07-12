package editor;
import estructuras.ListaDoblementeEnlazada;
import estructuras.Pila;
import historial.Accion;
import historial.TipoAccion;

public class EditorTexto {

    private ListaDoblementeEnlazada documento;
    private Pila undo;
    private Pila redo;

    public EditorTexto() {

        documento = new ListaDoblementeEnlazada();
        undo = new Pila();
        redo = new Pila();

    }
    // Inserta una nueva línea en el documento
    public void insertarLinea(int posicion, String texto) {
    documento.insertar(posicion, texto);
    Accion accion = new Accion(
            TipoAccion.INSERTAR,
            posicion,
            null,
            texto
    );
    undo.push(accion);
    redo.vaciar();

}
}