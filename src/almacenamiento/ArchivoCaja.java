/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento;

import datos.Caja;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import main.ProgramaPrincipal;

/**
 *
 * @author Nertrox
 */
public class ArchivoCaja {
    
    private ObjectOutputStream escrituraObjeto;
    private FileOutputStream conexion;
    private FileInputStream conexionLectura;
    private ObjectInputStream lecturaObjeto;


    public boolean escribirObjeto(String path) {
        boolean escribio = false;

        int cantidadObjetos = ProgramaPrincipal.datos.getCajas().largo();

        try {
            conexion = new FileOutputStream(path);
            escrituraObjeto = new ObjectOutputStream(conexion);
            if (cantidadObjetos > 0) {
                for (int i = 0; i < cantidadObjetos; i++) {
                    Caja obj = (Caja) ProgramaPrincipal.datos.getCajas().obtener(i);
                    escribio = true;
                    escrituraObjeto.writeObject((obj));
                }

                escrituraObjeto.close();
                return escribio;
            } 
            else {
                Path p = Paths.get(path);
                Files.delete(p);
            }
        } catch (Exception e) {
        }

        return escribio;
    }

    public void leerObjetos(String nombreArchivo) {
        Object objetoLeido = null;
        Caja caja = null;

        try {
            conexionLectura = new FileInputStream(nombreArchivo);
            lecturaObjeto = new ObjectInputStream(conexionLectura);

            objetoLeido = lecturaObjeto.readObject();
            // valores = (Empleado) objetoLeido;

            while (objetoLeido != null) {
                caja = (Caja) objetoLeido;
                ProgramaPrincipal.datos.agregarProducto(caja);
                objetoLeido = lecturaObjeto.readObject();
            }//Fin del while

            lecturaObjeto.close();
        } catch (Exception e) {
        }
    }
}
