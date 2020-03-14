/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datos.Factura;
import datos.Orden;
import datos.Pizza;
import datos.Topping;
import interfaz.FrNoDatos;
import interfaz.FrPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import negocio.BaseDatos;
import negocio.Configuracion;

/**
 *
 * @author Nertrox
 */
public class ProgramaPrincipal {

    public static BaseDatos datos;
    public static Configuracion config;
    public static String pathP = "datos\\Pizzas";
    public static String pathC = "datos\\Clientes";
    public static String pathE = "datos\\Empleados";
    public static String pathO = "datos\\Ordenes";
    public static String pathProd = "datos\\Productos";
    public static String pathB = "datos\\Bebidas";
    public static String pathT = "datos\\Toppings";
    public static String pathCajas = "datos\\Cajas";
    public static String pathCombos = "datos\\Combos";

    public static void generarFactura(Orden o) throws IOException {
        //  FileWriter conexion = new FileWriter("\\Facturas", false);
        //  BufferedWriter escritor = new BufferedWriter(conexion);
        String numero = String.valueOf(o.getNumeroOrden());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");

        String fecha = sdf.format(o.getFecha());
        String tipoPago = o.isTarjeta() ? "TARJETA" : "EFECTIVO";
        String tipoPedido = o.isExpress() ? "ORDEN EXPRESS" : "ORDEN P.LLEVAR";
        
        String contenido = String.format("\nMASTER PIZZA\n"
                + "\nNumero Orden: %s"
                + "\n%s"
                + "\nFecha: %s"
                + "\nCajero: %s"
                + "\nCliente: %s"
                + "\nTipo Pago: %s"
                , numero, tipoPedido, fecha, o.getEmpleado().getNombre(), o.getCliente().getNombre(), tipoPago);

        System.out.println(contenido);
    }

    private static boolean revisarUsuarios() {

        boolean empleado = true;
        if (ProgramaPrincipal.datos.getEmpleados().cantidad() == 0) {
            FrNoDatos fr = new FrNoDatos();
            fr.setVisible(true);
            return false;
        }
        return empleado;
    }

    public static void main(String[] args) throws IOException {

        File directory = new File("datos");
        if (!directory.exists()) {
            directory.mkdir();
        }
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        FontUIResource font = new FontUIResource("Tahoma", Font.PLAIN, 24);
        UIManager.put("Panel.background", new Color(149, 165, 166));
        UIManager.put("Panel.font", font);
        UIManager.put("OptionPane.background", new Color(149, 165, 166));
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);
        UIManager.put("OptionPane.buttonFont", font);
        UIManager.put("OptionPane.tittleFont", font);
        UIManager.put("TextField.font", font);
        UIManager.put("OptionPane.messageFont", font);

        datos = new BaseDatos();
        config = new Configuracion();
        config.cargarConfig();
        datos.cargarPizzas(pathP);
        datos.cargarBebidas(pathB);
        datos.cargarToppings(pathT);
        datos.cargarOtros(pathProd);
        datos.cargarClientes(pathC);
        datos.cargarEmpleados(pathE);
        datos.cargarOdenes(pathO);
        datos.cargarCajas(pathCajas);
        datos.cargarCombos(pathCombos);

        if (revisarUsuarios()) {
           FrPrincipal ventanaPrincipal = new FrPrincipal();
          ventanaPrincipal.setVisible(true);
        }
        
        /**for(int i=0; i<datos.getPizzas().largo();i++){
            Pizza p= (Pizza) datos.getPizzas().obtener(i);       
            p.removerTopping("queso");
            p.removerTopping("Queso");
            p.removerTopping("@ueso ");
            p.removerTopping("Queso ");
            
        }
        
        datos.guardarPizzas(pathP);**/
    }

}
