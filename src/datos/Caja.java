/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Nertrox
 */
public class Caja extends Producto{
    
    private static final long serialVersionUID = 1L;
    private int cantidadDisponible;
    private int tamano;

    public Caja(int cantidadDisponible, String nombre, String descripcion, int tamano, Categoria categoria) {
        super(nombre, descripcion, categoria);
        this.tamano = tamano;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Caja(String nombre) {
        super(nombre);
        this.cantidadDisponible=0;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void aumentarCantidadDisponibe(int cantidad) {
        this.cantidadDisponible+=cantidad;
    }
    
    public void reducirCantidadDisponibe(int cantidad) {
        this.cantidadDisponible-=cantidad;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Caja{" + "cantidadDisponible=" + cantidadDisponible + ", tamano=" + tamano + '}';
    }
    
    @Override
    public Caja crearCopia() {
        return new Caja(cantidadDisponible, nombre, descripcion, tamano, categoria);
    }
    
    
}

