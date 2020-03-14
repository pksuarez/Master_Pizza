/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Comparator;

/**
 *
 * @author Nertrox
 */
public class ComparadorIngresos implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {
        Producto p1 = (Producto) o1;
        Producto p2 = (Producto) o2;
        if (p1.ingresosGenerados < p2.ingresosGenerados)
            return 1;
        else
            return -1;
    }
    
}
