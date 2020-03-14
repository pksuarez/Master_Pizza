/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Nertrox
 */
public class HiloCambio extends Thread {

    private final int total;
    private final JTextField jPago;
    private final JTextField jCambio;
    private boolean stop = false;

    public HiloCambio(int total, JTextField pago, JTextField cambio) {
        this.total = total;
        this.jPago = pago;
        this.jCambio = cambio;
    }

    private String desformatear(String value){

        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i<formateado.length;i++) 
            desformateado+=formateado[i];
        
        return desformateado;
    }
    public void calcularCambio() {

        try {
            int pago = Integer.parseInt(desformatear(jPago.getText()));
            int cambio = total - pago;

            if (cambio >= 0) {
                jCambio.setText("0");
            } else {
                cambio *= -1;
                String camb = String.format("%,d",cambio);
                jCambio.setText(String.valueOf(camb));
            }
        } catch (Exception e){
            }

        }

        @Override
        public void run
        
            () {

        while (!stop) {
                try {
                    calcularCambio();
                    sleep(300);
                } catch (InterruptedException ex) {
                    
                } catch (Exception ex) {
                    
                }

            }
        }

    

    public void parar() {
        this.stop = true;
    }
}
