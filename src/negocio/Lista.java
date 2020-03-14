package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pablokalet
 */
public class Lista implements Serializable {

    protected ArrayList lista;  // coleccion que permite repetidos
    private static final long serialVersionUID = -1L;

    public Lista() {
        lista = new ArrayList();
    }

    public boolean agregar(Object obj) {
        if (lista.indexOf(obj) == -1) {
            lista.add(obj);
            return true;
        }
        return false;

    }

    public int cantidad() {
        return lista.size();
    }

    /**
     * localiza un objeto de igual estructura por medio de su clave
     *
     * @param llave: un objeto de igual estructura que al menos contiene los
     * valores que le identifican
     * @return el objeto encontrado o null si no lo halla
     */
    public Object consultar(Object llave) {
        int donde = lista.indexOf(llave);
        if (donde != -1) {
            return lista.get(donde);
        }
        return null;
    }

    public boolean modificar(Object obj) {
        int donde = lista.indexOf(obj);
        if (donde != -1) {
            lista.set(donde, obj);
            return true;
        }
        return false;
    }

    public boolean modificar(Object obj, Object nuevo) {
        int donde = lista.indexOf(obj);
        if (donde != -1) {
            lista.set(donde, nuevo);
            return true;
        }
        return false;
    }

    public boolean eliminar(Object obj) {
        int donde = lista.indexOf(obj);
        if (donde != -1) {
            lista.remove(donde);
            System.out.println("eliminado");
            return true;
        }
        System.out.println("no eliminado");
        return false;

//return lista.remove(obj);
    }

    public String toString() {
        String hilera = "";
        for (int i = 0; i < lista.size(); i++) {
            Object obj = lista.get(i);
            hilera += obj.toString() + "\n";
        }
        return hilera;
    }

    public int largo() {
        return lista.size();
    }

    public Object obtener(int index) {
        return lista.get(index);
    }
    
    public void ordenar(){
        Collections.sort(lista);
    }
    
    public ArrayList copiar(){
        ArrayList copia = new ArrayList(lista);
        return copia;
    }
}
