/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datos.Categoria;
import datos.Combo;
import datos.Pizza;
import datos.Producto;


/**
 *
 * @author Nertrox
 */
public class NewClass {

    private static String formatear(String num) {
        String s1 = num.substring(0, 4) + "-";
        s1 += num.substring(4);
        return s1;
    }

    private static String desformatear(String num) {
        String[] formateado = num.split("-");
        String desformateado = "";
        for (int i = 0; i < formateado.length; i++) {
            desformateado += formateado[i];
        }
        return desformateado;
    }

    public static void main(String args[]) {

        
        Combo c = new Combo("Prueba");
        Producto p = new Producto("Testin", "test", Categoria.PIZZA);
        Pizza pizza = (Pizza) p;
        Combo c2 = (Combo) p;
        System.out.println(p);

    }

    /*    private void formatearNumeros() {

        String value = "₡";

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String numero = String.valueOf(jTable1.getValueAt(i, 4));
            value += String.format("%,d", Integer.valueOf(numero));
            jTable1.setValueAt(value, i, 4);
            value = "₡";
        }
    }


private String desformatear(String value){

        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i<formateado.length;i++) 
            desformateado+=formateado[i];
        
        return desformateado;
    }


private static String quitarColon(String valor){
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
    

for (int i = 0; i < jTableBebidas.getColumnCount(); i++) {
            TableColumn col = jTableBebidas.getColumnModel().getColumn(i);
            col.setCellEditor(new MyTableCellEditor());
            col.setCellRenderer(new MyTableCellRenderer());
        }

     */
}
