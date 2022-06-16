package ProgramacionObjetos;

import java.util.Objects;

public class Juguete {

    private String nombre;
    private int edadMin;
    private int precioBase;
    private int jugadores;

    public Juguete(String nombre, int edadMin, int precioBase) throws EinvalidPropertyException {
        validarParametros(nombre, edadMin, precioBase);
        this.jugadores = 0;
    }

    public Juguete(String nombre, int edadMin, int precioBase, int jugadores) throws EinvalidPropertyException {
        validarParametros(nombre, edadMin, precioBase);
        if (jugadores <= 0) throw new EinvalidPropertyException("El número de jugadores no puede ser 0.");
        this.jugadores = jugadores;
    }

    private void validarParametros(String nombre, int edadMin, int precioBase) throws EinvalidPropertyException {
        if (nombre == null) throw new EinvalidPropertyException("El nombre no puede ser null.");
        this.nombre = nombre;
        if (edadMin < 0) throw new EinvalidPropertyException("La edad no puede ser inferior a 0.");
        this.edadMin = edadMin;
        if (precioBase <= 0) throw new EinvalidPropertyException("El precio no puede ser 0.");
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public int getJugadores() {
        return jugadores;
    }

    public int getPrecio() {
        return precioBase;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juguete)) return false;
        Juguete juguete = (Juguete) o;
        return nombre.equals(juguete.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        if (jugadores <= 0) {
            return "-Juguete-" +
                    "\nNombre: " + nombre +
                    "\nEdad Mínima: " + edadMin +
                    "\nPrecio Base: " + precioBase + " €";
        } else {
            return "-Juguete-" +
                    "\nNombre: " + nombre +
                    "\nEdad Mínima: " + edadMin +
                    "\nNº Jugadores: " + jugadores +
                    "\nPrecio Base: " + precioBase + " €";
        }
    }
}
