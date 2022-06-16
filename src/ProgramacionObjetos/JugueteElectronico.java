package ProgramacionObjetos;

public class JugueteElectronico extends Juguete {

    private int recargo;

    public JugueteElectronico(String nombre, int edadMin, int precioBase, int recargo) throws EinvalidPropertyException {
        super(nombre, edadMin, precioBase);
        validExcepcion(recargo, precioBase);
        setJugadores(0);
    }

    public JugueteElectronico(String nombre, int edadMin, int precioBase, int jugadores, int recargo) throws EinvalidPropertyException {
        super(nombre, edadMin, precioBase, jugadores);
        validExcepcion(recargo, precioBase);
    }

    private void validExcepcion(int recargo, int precioBase) throws EinvalidPropertyException {
        if (recargo >= precioBase)
            throw new EinvalidPropertyException("El recargo tiene que ser inferior al precio base.");
        this.recargo = recargo;
    }

    @Override
    public int getPrecio() {
        return this.getPrecioBase() + this.recargo;
    }

    @Override
    public String toString() {
        if (getJugadores() <= 0) {
            return "-Juguete Electrónico-" +
                    "\nNombre: " + getNombre() +
                    "\nEdad Mínima: " + getEdadMin() +
                    "\nPrecio Base: " + getPrecioBase() +
                    "\nRecargo: " + recargo +
                    "\nPrecio final: " + getPrecio();
        } else {
            return "-Juguete Electrónico-" +
                    "\nNombre: " + getNombre() +
                    "\nEdad Mínima: " + getEdadMin() +
                    "\nNº Jugadores: " + getJugadores() +
                    "\nPrecio Base: " + getPrecioBase() + " €" +
                    "\nRecargo: " + recargo + " €" +
                    "\nPrecio final: " + getPrecio() + " €";
        }
    }
}
