/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nertrox
 */
public class HiloPrecio extends Thread {

    private final JLabel total;
    private final JLabel express;
    private final JTable productos;
    private final JLabel subtotal;
    private boolean stop;

    public HiloPrecio(JLabel total, JLabel express, JTable productos, JLabel subtotal) {

        this.total = total;
        this.express = express;
        this.productos = productos;
        this.subtotal = subtotal;
        this.stop = false;
    }

    private String desformatear(String value){

        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i<formateado.length;i++) 
            desformateado+=formateado[i];
        
        return desformateado;
    }
    private String quitarColon(String valor){
        String desformateado;

        if (valor.charAt(0) == '₡'){
            desformateado = valor.substring(1);
            desformateado = desformatear(desformateado);
        }
        
        else{
            desformateado = desformatear(valor);
        }
        
        return desformateado;
    }
    private void actualizarTotal() {

        try {
            int precio = 0;
            DefaultTableModel model = (DefaultTableModel) productos.getModel();
            int filas = model.getRowCount();
            int pExpress = Integer.parseInt(desformatear(express.getText()));
            for (int i = 0; i < filas; i++) {
                precio += Integer.parseInt(quitarColon(String.valueOf(model.getValueAt(i, 2))));
            }
            
            String tot = String.format("%,d", (precio+pExpress));
            subtotal.setText(String.format("%,d",precio));
            total.setText(tot);

        } catch (NullPointerException ex) {

        }
        
        catch (NumberFormatException e){
            
        }

    }

    public void parar() {
        this.stop = true;
    }

    @Override
    public void run() {

        while (!stop) {
            try {
                actualizarTotal();
                sleep(100);
            } catch (InterruptedException ex) {

            }
        }

        System.out.println("El hilo ha terminado");
    }

}
