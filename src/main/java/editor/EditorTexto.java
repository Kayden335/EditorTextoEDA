package editor;
import estructuras.ListaDoblementeEnlazada;
import estructuras.Pila;
import historial.Accion;
import historial.TipoAccion;

public class EditorTexto {
    private ListaDoblementeEnlazada documento;
    private Pila undo;
    private Pila redo;

    // Constructor
    public EditorTexto() {
        documento = new ListaDoblementeEnlazada();
        undo = new Pila();
        redo = new Pila();
    }

    // Inserta una línea
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

    // Edita una línea
    public void editarLinea(int posicion, String nuevoTexto) {
        String textoAnterior = documento.obtenerTexto(posicion);
        if (textoAnterior == null) {
            System.out.println("La linea no existe.");
            return;
        }

        documento.editar(posicion, nuevoTexto);
        Accion accion = new Accion(
                TipoAccion.EDITAR,
                posicion,
                textoAnterior,
                nuevoTexto
        );
        undo.push(accion);
        redo.vaciar();
    }

    // Elimina una línea
    public void eliminarLinea(int posicion) {
        String texto = documento.obtenerTexto(posicion);
        if (texto == null) {
            System.out.println("La linea no existe.");
            return;
        }
        documento.eliminar(posicion);
        Accion accion = new Accion(
                TipoAccion.ELIMINAR,
                posicion,
                texto,
                null
        );
        undo.push(accion);
        redo.vaciar();
    }

    // Deshacer última acción
    public void deshacer() {
        if (undo.estaVacia()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        Accion accion = (Accion) undo.pop();
        switch (accion.getTipo()) {
            case INSERTAR:
                documento.eliminar(accion.getPosicion());
                break;
            case EDITAR:
                documento.editar(
                        accion.getPosicion(),
                        accion.getTextoAnterior());
                break;
            case ELIMINAR:
                documento.insertar(
                        accion.getPosicion(),
                        accion.getTextoAnterior());
                break;
        }
        redo.push(accion);
    }
    // Rehacer última acción
    public void rehacer() {
        if (redo.estaVacia()) {
            System.out.println("No hay acciones para rehacer.");
            return;
        }

        Accion accion = (Accion) redo.pop();
        switch (accion.getTipo()) {
            case INSERTAR:
                documento.insertar(
                    accion.getPosicion(),
                    accion.getTextoNuevo());
                break;
            case EDITAR:
                documento.editar(
                    accion.getPosicion(),
                    accion.getTextoNuevo());
                break;
            case ELIMINAR:
                documento.eliminar(
                    accion.getPosicion());
                break;
        }
        undo.push(accion);
    }
    // Muestra el documento
    public void mostrarDocumento() {
        documento.mostrar();
    }
    // Historial Undo
    public void mostrarUndo() {
        System.out.println("\n      PILA UNDO      ");
        undo.mostrar();
    }
    // Historial Redo
    public void mostrarRedo() {
        System.out.println("\n        PILA REDO     ");
        redo.mostrar();
    }
}