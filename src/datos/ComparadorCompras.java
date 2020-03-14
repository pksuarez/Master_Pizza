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
public class ComparadorCompras implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        Cliente c1 = (Cliente) o1;
        Cliente c2 = (Cliente) o2;
        if (c1.getCantOrdenes() < c2.getCantOrdenes()) {
            return 1;
        } else {
            return -1;
        }
    }

}
