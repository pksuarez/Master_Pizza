/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nertrox
 */
public class Configuracion {

    private int cantMinTopping;
    private int cantMinBebidas;
    private int cantMinCajas;
    private boolean prohibirVenta;
    private String pathGuardarConfig;
    private String impresora;
    private String directorio;

    public Configuracion(int cantMinTopping, int cantMinBebidas, int cantMinCajas) {
        this.cantMinTopping = cantMinTopping;
        this.cantMinBebidas = cantMinBebidas;
        this.cantMinCajas = cantMinCajas;
        pathGuardarConfig = "config\\ajustes.txt";
        directorio = "config";
        prohibirVenta = true;
        impresora = null;
    }

    public Configuracion() {
        pathGuardarConfig = "config\\ajustes.txt";
        directorio = "config";
        prohibirVenta = true;
        impresora = null;
    }

    public int getCantMinTopping() {
        return cantMinTopping;
    }

    public boolean isProhibirVenta() {
        return prohibirVenta;
    }

    public void setProhibirVenta(boolean prohibirVenta) {
        this.prohibirVenta = prohibirVenta;
    }

    public void setCantMinTopping(int cantMinTopping) {
        this.cantMinTopping = cantMinTopping;
    }

    public int getCantMinBebidas() {
        return cantMinBebidas;
    }

    public void setCantMinBebidas(int cantMinBebidas) {
        this.cantMinBebidas = cantMinBebidas;
    }

    public String getPathGuardarConfig() {
        return pathGuardarConfig;
    }

    public void setPathGuardarConfig(String pathGuardarConfig) {
        this.pathGuardarConfig = pathGuardarConfig;
    }

    public int getCantMinCajas() {
        return cantMinCajas;
    }

    public void setCantMinCajas(int cantMinCajas) {
        this.cantMinCajas = cantMinCajas;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    public String getImpresora() {
        return impresora;
    }

    public void guardarConfig() {
        try {
            
            File directory = new File(directorio);
            if (!directory.exists()) {
                directory.mkdir();
            }
            FileWriter conexion = new FileWriter(pathGuardarConfig, false);
            int prohibir = prohibirVenta ? 1 : 0;
            String s = cantMinBebidas + "\n"
                    + cantMinCajas + "\n"
                    + cantMinTopping + "\n"
                    + prohibir +"\n"
                    +impresora;
            conexion.write(s);
            conexion.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void cargarConfig() {

        try {
            FileReader lector = new FileReader(pathGuardarConfig);
            BufferedReader buffer = new BufferedReader(lector);
            String leido;
            try {
                leido = buffer.readLine();
                int i = 0;
                String[] datos = new String[5];
                while (i < 5) {
                    datos[i] = leido;
                    leido = buffer.readLine();
                    i++;
                }
                cantMinBebidas = Integer.valueOf(datos[0]);
                cantMinCajas = Integer.valueOf(datos[1]);
                cantMinTopping = Integer.valueOf(datos[2]);

                int prohibir = Integer.valueOf(datos[3]);
                prohibirVenta = prohibir == 1 ? true : false;
                impresora = datos[4];
                buffer.close();
                lector.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

}
