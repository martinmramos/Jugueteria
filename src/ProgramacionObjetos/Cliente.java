package ProgramacionObjetos;

import java.util.HashSet;
import java.util.Objects;

public class Cliente {

    /* La colección elegida es "HashSet", ya que no necesitamos ningún orden en la lista y la
    inserción de datos con esta colección es más rápida.
     */

    private String nombre;
    private HashSet<Juguete> listado;

    public Cliente(String nombre, HashSet<Juguete> listado) throws EinvalidPropertyException {
        if (nombre == null) throw new EinvalidPropertyException("El nombre no puede ser null.");
        this.nombre = nombre;
        if (listado == null) this.listado = new HashSet<>();
        else this.listado = listado;
    }

    public String getNombre() {
        return nombre;
    }

    public void addJuguete(Juguete juguete) throws EinvalidPropertyException {
        if (juguete == null) {
            throw new EinvalidPropertyException("No se puede añadir un juguete no creado.");
        } else {
            this.listado.add(juguete);
        }
    }

    public int calcularGasto() {
        int result = 0;
        for (Juguete j : listado) {
            result += j.getPrecio();
        }
        return result;
    }

    public Juguete listarJuguetes() throws EinvalidPropertyException {
        if (listado.isEmpty() || listado == null) {
            throw new EinvalidPropertyException("El cliente " + this.nombre + " no tiene juguetes asignados.");
        } else {
            System.out.println("El listado de juguetes del cliente " + this.nombre + " es:");
            for (Juguete j : listado) {
                System.out.println(j);
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
