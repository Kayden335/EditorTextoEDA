package historial;
public class Accion {

    private TipoAccion tipo;
    private int posicion;
    private String textoAnterior;
    private String textoNuevo;

    public Accion(TipoAccion tipo, int posicion, String textoAnterior, String textoNuevo) {
        this.tipo = tipo;
        this.posicion = posicion;
        this.textoAnterior = textoAnterior;
        this.textoNuevo = textoNuevo;
    }

    public TipoAccion getTipo() {
        return tipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getTextoAnterior() {
        return textoAnterior;
    }

    public String getTextoNuevo() {
        return textoNuevo;
    }

    @Override
    public String toString() {
        return tipo + " | Línea: " + posicion;
    }

}