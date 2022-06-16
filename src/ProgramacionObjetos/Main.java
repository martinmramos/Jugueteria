package ProgramacionObjetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Juguete j1 = null;
        Juguete j2 = null;
        Juguete j3 = null;
        Cliente c1 = null;
        Cliente c2 = null;
        Cliente c3 = null;
        Jugueteria j = new Jugueteria(new ArrayList<>());

        /* Creación de juguetes */
        try {
            j1 = new Juguete("uno", 10, 20, 2);
            j2 = new JugueteElectronico("dos", 0, 150, 10);
            j3 = new JugueteEducativo("tres", 12, 100, 4, 15, 10);
        } catch (EinvalidPropertyException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }

        /* Creación de clientes */
        try {
            c1 = new Cliente("Martin", new HashSet<>());
            c2 = new Cliente("Luis", new HashSet<>());
            c3 = new Cliente("Antonio", new HashSet<>());
        } catch (EinvalidPropertyException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }

        /* Prueba de métodos de juguetes */
        try {
            j1.getPrecio();
            j2.getPrecio();
            j3.getPrecio();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Prueba de métodos de clientes */
        try {
            c1.addJuguete(j2);
            c2.addJuguete(j1);
            c2.addJuguete(j2);
            c3.addJuguete(j1);
            c3.addJuguete(j3);
            c2.calcularGasto();
            c2.listarJuguetes();
        } catch (EinvalidPropertyException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }

        /* Prueba de métodos de juguetería */
        try {
            j.addCliente(c1);
            j.addCliente(c2);
            j.addCliente(c3);
            j.addCliente(c1);
            j.addCliente(c3);
            j.listarJuguetesPorCliente("Antonio");
            j.listarClientes();
        } catch (EinvalidPropertyException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }

        /* Creación de fichero */
        /* El fichero se va a crear en el mismo directorio que nuestro código */
        File fichero = new File("info.txt");
        try {
            PrintWriter salida = new PrintWriter(fichero);
            for (Cliente c : j.getClientes()) {
                salida.println(c.getNombre() + " - " + c.calcularGasto() + " €");
                salida.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}


