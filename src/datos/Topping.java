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
public class Topping extends Producto {

    private int cantidadDisponible, cantidadNecesaria;
    private static final long serialVersionUID = 1L;

        
    public Topping(String nombre) {
        super(nombre);
        categoria = Categoria.TOPPING;
    }

    public Topping(String nombre, String descripcion, Categoria categoria, int cantidadDisponible) {
        super(nombre, descripcion, categoria);
        this.cantidadDisponible = cantidadDisponible;
        cantidadNecesaria = 0;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(int cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public void aumentarCantidadDisponibe(int cantidad) {
        cantidadDisponible += cantidad;
    }
    public void reducirCantidadDisponible(int cantidad){
        cantidadDisponible -= cantidad;
    }

    @Override
    public String toString() {
        return "Topping: " + nombre + " cantidadDisponible=" + cantidadDisponible + ", cantidadNecesaria=" + cantidadNecesaria + '}';
    }

}
