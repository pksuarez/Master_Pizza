/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import impresora.PrinterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import negocio.Lista;

/**
 *
 * @author Nertrox
 */
public class Factura {

    FileWriter conexion;
    BufferedWriter escritor;
    String directorio;

    public Factura() {
        directorio = "Facturas";

    }

    private void crearDirectorio() {

        File directory = new File(directorio);
        if (!directory.exists()) {
            directory.mkdir();
        }

    }

    public void imprimirFactura(String contenido, String impresora) {
        PrinterService imprimir = new PrinterService(impresora);
        imprimir.imprimirFactura(contenido);
    }

    public void reImprimirFactura(Orden o, String impresora) {
        String numero = String.valueOf(o.getNumeroOrden());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");

        String fecha = sdf.format(o.getFecha());
        String tipoPago = o.isTarjeta() ? "TARJETA" : "EFECTIVO";
        String tipoPedido = o.isExpress() ? "ORDEN EXPRESS" : "ORDEN P.LLEVAR";

        String contenido = String.format("             \nPIZZA PRONTO\n"
                +"\nced: 3-101-60-58-52"
                + "\n%s\n"
                + "\nNumero De Orden: %s"
                + "\nFecha: %s"
                + "\nCajero: %s"
                + "\nCliente: %s"
                + "\nTipo Pago: %s"
                + "\n---------------------------------------"
                + "\n               PRODUCTOS               "
                + "\n%s"
                + "\n---------------------------------------\n        Gracias por preferirnos!\n\n\n\n\n\n\n\n\n\n\n",
                tipoPedido, numero, fecha, o.getEmpleado().getNombre(), o.getCliente().getNombre(), tipoPago, obtenerProductos(o));

        System.out.println(contenido);
        imprimirFactura(contenido, impresora);
    }

    public void generarFactura(Orden o, String impresora) {

        try {
            crearDirectorio();
            String numero = String.valueOf(o.getNumeroOrden());
            
            File directory = new File(directorio);
            if (!directory.exists()) {
                directory.mkdir();
            }
            String path = directorio + "\\" + numero + ".txt";

            conexion = new FileWriter(path, false);
            escritor = new BufferedWriter(conexion);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");

            String fecha = sdf.format(o.getFecha());
            String tipoPago = o.isTarjeta() ? "TARJETA" : "EFECTIVO";
            String tipoPedido = o.isExpress() ? "ORDEN EXPRESS" : "ORDEN P.LLEVAR";

            String contenido = String.format("             \nPIZZA PRONTO\n"
                +"\nced: 3-101-60-58-52"
                + "\n%s\n"
                + "\nNumero De Orden: %s"
                + "\nFecha: %s"
                + "\nCajero: %s"
                + "\nCliente: %s"
                + "\nTipo Pago: %s"
                + "\n---------------------------------------"
                + "\n               PRODUCTOS               "
                + "\n%s"
                + "\n---------------------------------------\n        Gracias por preferirnos!\n\n\n\n\n\n\n\n\n\n\n",
                tipoPedido, numero, fecha, o.getEmpleado().getNombre(), o.getCliente().getNombre(), tipoPago, obtenerProductos(o));

            
            System.out.println(contenido);
            imprimirFactura(contenido, impresora);
            escritor.write(contenido);
            escritor.close();
            conexion.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    private String obtenerProductos(Orden o) {
        Lista lista = o.getProductos();
        String productos = "";
        String linea, precio;
        Producto p;
        String total = String.format("¢%,d", o.getTotal());

        int nombreGrande = 0;
        int cantGrande = 0;

        /*
        *Obtiene los valores mas grandes para igualar el espaciado
         */
        for (int i = 0; i < lista.cantidad(); i++) {

            p = (Producto) lista.obtener(i);
            precio = String.format("¢%,d", (p.getPrecio() * p.getCantidadOrdenada()));
            if (p.getDescripcion().length() > nombreGrande) {
                nombreGrande = p.getDescripcion().length();
            }

            if (String.valueOf(p.getCantidadOrdenada()).length() > cantGrande) {
                cantGrande = String.valueOf(p.getCantidadOrdenada()).length();
            }
        }

        System.out.println(nombreGrande + "  " + cantGrande);

        int espacio1;
        int espacio2;
        String e1 = ""; //espaciado entre desc y cant
        String e2 = "";//espaciado cant y precio

        for (int i = 0; i < lista.cantidad(); i++) {

            p = (Producto) lista.obtener(i);
            precio = String.format("¢%,d", (p.getPrecio() * p.getCantidadOrdenada()));

            espacio2 = (nombreGrande - p.getDescripcion().length()) + 5;
            espacio1 = (cantGrande - String.valueOf(p.getCantidadOrdenada()).length() + 5);

            for (int j = 0; j < espacio1; j++) {
                e1 += " ";
            }

            for (int j = 0; j < espacio2; j++) {
                e2 += " ";
            }
            linea = String.format("\n%d %s%s %s%s", p.getCantidadOrdenada(), e1, p.getDescripcion(), e2, precio);
            //linea = String.format("\n%s %20s %10d", p.getDescripcion(), precio, p.getCantidadOrdenada());
            productos += linea;

            e1 = "";
            e2 = "";
        }

        if (o.isExpress()) {
            String subtotal = String.format("¢%,d", (o.getTotal() - o.getPrecioExpress()));
            String express = String.format("¢%,d", o.getPrecioExpress());
            String lineaSub = String.format("\n\n\nDIRECCION:\n%s\n"
                    + "\nTélefono:      %s"
                    + "\n\n\nSubtotal:      %s"
                    + "\nExpress:       %s"
                    + "\nTOTAL:         %s"
                    + "\n***I.V.I***", o.getCliente().getDireccion(), o.getCliente().getTelefono(), subtotal, express, total);

            productos += lineaSub;
        } else {
            String lineaS = String.format("\n\n\nTOTAL: %s"
                    + "\n***I.V.I***", total);

            productos += lineaS;
        }

        return productos;
    }

    public void imprimirVentas(List<Orden> ordenes, String total, String impresora) {

        long tarjeta = 0;
        long efectivo = 0;
        long express = 0;

        for (Orden o : ordenes) {
            if (o.isTarjeta()) {
                tarjeta += o.getTotal();
            }
            if (!o.isTarjeta()) {
                efectivo += o.getTotal();
            }

            if (o.isExpress()) {
                express += o.getPrecioExpress();
            }
        }

        String contenido = String.format("             PIZZA PRONTO\n"
                +"\nced: 3-101-60-58-52"
                + "\n                ORDENES                "
                + "\n---------------------------------------"
                + "\n%s"
                + "\n---------------------------------------"
                + "\n\nEFECTIVO: %s"
                + "\nTARJETA: %s"
                + "\nEXPRESS: %s"
                + "\nTOTAL: %s"
                + "\n\n\n\n\n\n\n\n", obtenerOrdenes(ordenes), String.format("¢%,d", efectivo), String.format("¢%,d", tarjeta), String.format("¢%,d", express), ("¢"+total));

        System.out.println(contenido);
        imprimirFactura(contenido, impresora);

    }

    public String obtenerOrdenes(List<Orden> ordenes) {

        String contenido = "";
        String linea;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
        int ordenGrande = 0;
        int precioGrande = 0;
        String total;

        for (Orden o : ordenes) {
            if (String.valueOf(o.getNumeroOrden()).length() > ordenGrande) {
                ordenGrande = String.valueOf(o.getNumeroOrden()).length();
            }
            
            total = String.format("¢%,d", o.getTotal());
            
            if (total.length() > precioGrande){
                precioGrande = total.length();
            }

        }

        int espacio1,espacio2;
        String e1 = "";
        String e2 ="";
        String fecha;
        

        for (Orden o : ordenes) {
            total = String.format("¢%,d", o.getTotal());
            espacio1 = ordenGrande - String.valueOf(o.getNumeroOrden()).length() + 3;
            espacio2 = precioGrande - total.length() + 3;
            for (int j = 0; j < espacio1; j++) {
                e1 += " ";
            }
            
            for (int j = 0; j < espacio2; j++){
                e2+= " ";
            }
            fecha = sdf.format(o.getFecha());
            linea = String.format("\n%d %s%s %s%s", o.getNumeroOrden(), e1, total,e2,fecha);
            contenido += linea;
            e1 = "";
            e2 ="";
        }
        return contenido;

    }
}
