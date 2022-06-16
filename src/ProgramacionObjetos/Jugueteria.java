package ProgramacionObjetos;

import java.util.ArrayList;

public class Jugueteria {
/*
Se ha elegido la colección "ArrayList", ya que el método 'addCliente' necesita saber la posición de un elemento
para sustituirlo por el cliente con los datos nuevos siempre que el cliente ya exista en la lista.
 */
    private ArrayList<Cliente> clientes;

    public Jugueteria(ArrayList<Cliente> clientes) {
        if (clientes == null) this.clientes = new ArrayList<>();
        else this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).equals(cliente)) {
                    clientes.set(i, cliente);
                }
            }
        } else {
            this.clientes.add(cliente);
        }
    }

    public void listarJuguetesPorCliente(String nombre) throws EinvalidPropertyException {
        boolean existe = false;
        for (Cliente c : clientes) {
            if (c.getNombre() == nombre) {
                c.listarJuguetes();
                existe = true;
            }
        }
        if (!existe) throw new EinvalidPropertyException("El cliente no existe.");
    }

    public Cliente listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i);
        }
        return null;
    }
}
