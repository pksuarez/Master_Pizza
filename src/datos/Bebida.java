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
public class Bebida extends Producto {

    String marca, sabor;
    int disponibles, tamano;
    private static final long serialVersionUID = 1L;

    public Bebida(String nombre, String descripcion, int precio, Categoria categoria, String marca, String sabor, int tamano, int disponibles) {
        super(nombre, descripcion, precio, categoria);
        this.marca = marca;
        this.sabor = sabor;
        this.tamano = tamano;
        this.disponibles = disponibles;
        this.cantidadEnCombo = 0;
    }

    public Bebida(String nombre) {
        super(nombre);
        categoria = Categoria.BEBIDA;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Bebida{" + "marca=" + marca + ", sabor=" + sabor + ", disponibles=" + disponibles + ", tamano=" + tamano + "cantOrdenada: " + cantidadOrdenada + "cant ordenadaTot: " + cantOrdenadaTotal +  " cantidad en combo:" + cantidadEnCombo ;
    }

    

    public void aumentarCantidadDisponibe(int cantidad) {
        this.disponibles += cantidad;
    }

    public void reducirDisponibles(int cantidad) {
        this.disponibles -= cantidad;
    }

    public Bebida crearCopia(){
        return new Bebida(nombre, descripcion, precio, categoria, marca, sabor, tamano, disponibles);
    }
}
