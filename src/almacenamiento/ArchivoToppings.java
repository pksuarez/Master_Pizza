/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento;

import datos.Topping;
import main.ProgramaPrincipal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Nertrox
 */
public class ArchivoToppings {

    private ObjectOutputStream escrituraObjeto;
    private FileOutputStream conexion;
    private FileInputStream conexionLectura;
    private ObjectInputStream lecturaObjeto;

    public boolean escribirObjeto(String path) {
        boolean escribio = false;

        int cantidadObjetos = ProgramaPrincipal.datos.getToppings().largo();

        try {
            conexion = new FileOutputStream(path);
            escrituraObjeto = new ObjectOutputStream(conexion);
            if (cantidadObjetos > 0) {
                for (int i = 0; i < cantidadObjetos; i++) {
                    Topping obj = (Topping) ProgramaPrincipal.datos.getToppings().obtener(i);
                    escribio = true;
                    escrituraObjeto.writeObject((obj));
                }

                escrituraObjeto.close();
                return escribio;
            } else {
                Path p = Paths.get(path);
                Files.delete(p);
            }
        } catch (Exception e) {
        }

        return escribio;
    }

    public void leerObjetos(String nombreArchivo) {
        Object objetoLeido = null;
        Topping topping = null;

        try {
            conexionLectura = new FileInputStream(nombreArchivo);
            lecturaObjeto = new ObjectInputStream(conexionLectura);

            objetoLeido = lecturaObjeto.readObject();
            // valores = (Empleado) objetoLeido;

            while (objetoLeido != null) {
                topping = (Topping) objetoLeido;
                ProgramaPrincipal.datos.agregarProducto(topping);
                /*JOptionPane.showMessageDialog(null, String.format("Valores%n %s%n%s%n%s%n",
                        valores.getNombre(),
                        valores.getCedula(),
                        valores.isAdministrador() ? "Verdadero" : "Falso"));*/
                objetoLeido = lecturaObjeto.readObject();
            }//Fin del while

            lecturaObjeto.close();
        } catch (Exception e) {
        }
    }
}
