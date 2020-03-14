/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import datos.Bebida;
import datos.Caja;
import datos.Topping;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.ProgramaPrincipal;

/**
 *
 * @author Nertrox
 */
public class HiloRevisarInventario extends Thread {

    private boolean stop = false;

    private void revisarInventario() {

        ArrayList<Bebida> bebidas = ProgramaPrincipal.datos.revisarBebidas(ProgramaPrincipal.config.getCantMinBebidas());
        ArrayList<Topping> toppings = ProgramaPrincipal.datos.revisarToppings(ProgramaPrincipal.config.getCantMinTopping());
        ArrayList<Caja> cajas = ProgramaPrincipal.datos.revisarCajas(ProgramaPrincipal.config.getCantMinCajas());
        String mensaje = "Hay productos que han llegado a la cantidad dispoinible minima indicada: \n";
        boolean mostrar = false;
        String valor;
        if (bebidas.size() > 0) {
            Bebida b;
            mostrar = true;
            for (int i = 0; i < bebidas.size(); i++) {
                b = bebidas.get(i);
                valor = String.format("%,d", b.getDisponibles());
                mensaje += "        - " + b.getNombre() + " cantidad disponibles: " + valor + "\n";
            }
        }

        if (toppings.size() > 0) {
            Topping t;
            mostrar = true;
            for (int i = 0; i < toppings.size(); i++) {
                t = toppings.get(i);
                valor = String.format("%,d", t.getCantidadDisponible());
                mensaje += "        - " + t.getNombre() + " cantidad disponibles: " + valor + " gramos\n";
            }
        }

        if (cajas.size() > 0) {
            Caja c;
            mostrar = true;
            for (int i = 0; i < cajas.size(); i++) {
                c = cajas.get(i);
                valor = String.format("%,d", c.getCantidadDisponible());
                mensaje += "        - " + c.getNombre() + " cantidad disponibles: " + valor + "\n";
            }
        }

        if (mostrar) {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public void run() {

        while (!stop) {
            try {
                revisarInventario();
                sleep(600000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void parar() {
        this.stop = true;
    }

}
