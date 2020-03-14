/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import negocio.Lista;

/**
 *
 * @author Nertrox
 */
public class Combo extends Producto {

    private Lista productos;
    private static final long serialVersionUID = 1L;

    public Combo(String nombre) {
        super(nombre);
        categoria = Categoria.COMBO;
        productos = new Lista();
    }

    public Combo(String nombre, String descripcion, int precio) {
        super(nombre);
        this.precio = precio;
        this.descripcion = descripcion;
        categoria = Categoria.COMBO;
        productos = new Lista();
    }

    public Combo(String nombre, String descripcion, int precio, long ingresosGenerados, Categoria categoria, int cantidadOrdenada, int cantOrdenadaTotal, int cantidadEnCombo, Lista productos){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingresosGenerados = ingresosGenerados;
        this.categoria = categoria;
        this.cantidadOrdenada = cantidadOrdenada;
        this.cantOrdenadaTotal = cantOrdenadaTotal;
        this.cantidadEnCombo = cantidadEnCombo;
        this.productos = productos;
    }
    public Lista getProductos() {
        return productos;
    }

    public void setProductos(Lista productos) {
        this.productos = productos;
    }

    public boolean agregarProducto(Producto producto) {
        boolean bandera = productos.agregar(producto);

        return bandera;
    }

    public void removerProducto(String nombre) {
        Producto p;
        for (int i = 0; i < productos.cantidad(); i++) {
            p = (Producto) productos.obtener(i);
            System.out.println(p);
            if (p.getNombre().equals(nombre)) {
                productos.eliminar(p);
                System.out.println("encontrado");
            }
        }
    
    }
   


    

    public void modificarProducto(String nombre, int cantidad) {
        Producto p;
        for (int i = 0; i < productos.cantidad(); i++) {
            p = (Producto) productos.obtener(i);

            if (p.getNombre().equals(nombre)) {
                p.setCantidadEnCombo(cantidad);
            }
        }
    }

    public void modificarProducto2(String nombre, int cantidad) {
        Producto p;
        for (int i = 0; i < productos.cantidad(); i++) {
            p = (Producto) productos.obtener(i);

            if (p.getNombre().equals(nombre)) {
                p.aumentarCantidadEnCombo(cantidad);
            }
        }
    }

    @Override
    public String toString() {
        return "Combo{" + "productos=" + productos + '}';
    }
    
    @Override
    public Combo crearCopia() {
        Combo combo = new Combo(nombre, descripcion, precio, ingresosGenerados, categoria, cantidadOrdenada, cantOrdenadaTotal, cantidadEnCombo, productos);
        System.out.println(combo);
        return combo;
    }
}
