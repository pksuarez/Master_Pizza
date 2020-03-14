package almacenamiento;

import datos.Empleado;
import main.ProgramaPrincipal;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author olmcamca
 */
public class FicheroObjeto {

    private ObjectOutputStream escrituraObjeto;
    private FileOutputStream conexion;

    private FileInputStream conexionLectura;
    private ObjectInputStream lecturaObjeto;

    private ArrayList<Object> listaObjetos;

    public boolean escribirObjeto(Object obj, String path) {
        boolean escribio = false;
        try {
            obtnerListaObjetos(path);
            conexion = new FileOutputStream(path);
            escrituraObjeto = new ObjectOutputStream(conexion);

            if (listaObjetos != null) {
                for (Object objTemp : listaObjetos) {
                    escrituraObjeto.writeObject((Empleado) objTemp);
                }

            }

            escrituraObjeto.writeObject((Empleado) obj);
            escrituraObjeto.close();

            escribio = true;
        } catch (Exception e) {
        }

        return escribio;
    }

    public void leerObjetos(String nombreArchivo) {
        Object objetoLeido = null;
        Empleado valores = null;

        try {
            conexionLectura = new FileInputStream(nombreArchivo);
            lecturaObjeto = new ObjectInputStream(conexionLectura);

            objetoLeido = lecturaObjeto.readObject();
            // valores = (Empleado) objetoLeido;

            while (objetoLeido != null) {
                valores = (Empleado) objetoLeido;
                ProgramaPrincipal.datos.agregarEmpleado(valores);
                /*JOptionPane.showMessageDialog(null, String.format("Valores%n %s%n%s%n%s%n",
                        valores.getNombre(),
                        valores.getCedula(),
                        valores.isAdministrador() ? "Verdadero" : "Falso"));*/
                objetoLeido = lecturaObjeto.readObject();
            }//Fin del while

            lecturaObjeto.close();
        } catch (Exception e) {
        }
    }//Fin del método leerObjetos

    public void obtnerListaObjetos(String path) {
        Object objetoLeido = null;
        Object valores = null;
        listaObjetos = new ArrayList();

        try {
            conexionLectura = new FileInputStream(path);
            lecturaObjeto = new ObjectInputStream(conexionLectura);

            objetoLeido = lecturaObjeto.readObject();

            while (objetoLeido != null) {
                valores = objetoLeido;
                listaObjetos.add(valores);

                objetoLeido = lecturaObjeto.readObject();
            }//Fin del while

            lecturaObjeto.close();
        } catch (Exception e) {
        }
    }//Fin del método leerObjetos    
}// fin de la clase FicheroObjeto
