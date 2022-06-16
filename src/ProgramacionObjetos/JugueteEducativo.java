package ProgramacionObjetos;

public class JugueteEducativo extends Juguete {

    private int edadMax;
    private int bonificacion;

    public JugueteEducativo(String nombre, int edadMin, int precioBase, int edadMax, int bonificacion) throws EinvalidPropertyException {
        super(nombre, edadMin, precioBase);
        validarParametros(edadMin, precioBase, edadMax, bonificacion);
        setJugadores(0);
    }

    public JugueteEducativo(String nombre, int edadMin, int precioBase, int jugadores, int edadMax, int bonificacion) throws EinvalidPropertyException {
        super(nombre, edadMin, precioBase, jugadores);
        validarParametros(edadMin, precioBase, edadMax, bonificacion);
    }

    private void validarParametros(int edadMin, int precioBase, int edadMax, int bonificacion) throws EinvalidPropertyException {
        if (edadMax <= edadMin)
            throw new EinvalidPropertyException("La edad máxima no puede ser superior o igual a la edad mínima.");
        this.edadMax = edadMax;
        if (bonificacion >= precioBase)
            throw new EinvalidPropertyException("La bonificación no puede ser igual o superior al precio base.");
        this.bonificacion = bonificacion;
    }

    @Override
    public int getPrecio() {
        return this.getPrecioBase() - this.bonificacion;
    }

    @Override
    public String toString() {
        if (getJugadores() <= 0) {
            return "-Juguete Educativo-" +
                    "\nNombre: " + getNombre() +
                    "\nEdad Mínima: " + getEdadMin() +
                    "\nEdad Máxima: " + edadMax +
                    "\nPrecio Base: " + getPrecioBase() + " €" +
                    "\nBonificación: " + bonificacion + " €" +
                    "\nPrecio final: " + getPrecio() + " €";
        } else {
            return "-Juguete Educativo-" +
                    "\nNombre: " + getNombre() +
                    "\nEdad Mínima: " + getEdadMin() +
                    "\nEdad Máxima: " + edadMax +
                    "\nNº Jugadores: " + getJugadores() +
                    "\nPrecio Base: " + getPrecioBase() + " €" +
                    "\nBonificación: " + bonificacion + " €" +
                    "\nPrecio final: " + getPrecio() + " €";
        }
    }
}
