/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import main.ProgramaPrincipal;
import negocio.Lista;

/**
 *
 * @author Nertrox
 */
public class Pizza extends Producto {

    private Lista toppings;
    private static final long serialVersionUID = 1L;
    String caja;

    public Pizza(String nombre) {
        super(nombre);
        categoria = Categoria.PIZZA;
        toppings = new Lista();
    }

    public Pizza(String nombre, String descripcion, int precio, Categoria categoria) {
        super(nombre, descripcion, precio, categoria);
        toppings = new Lista();
    }

    public Pizza(String nombre, String descripcion, int precio, Categoria categoria, String caja) {
        super(nombre, descripcion, precio, categoria);
        this.caja = caja;
        toppings = new Lista();
    }

    public Pizza(Lista toppings, String caja, String nombre, String descripcion, int precio, long ingresosGenerados, Categoria categoria, int cantidadOrdenada, int cantOrdenadaTotal) {
        super(nombre, descripcion, precio, ingresosGenerados, categoria, cantidadOrdenada, cantOrdenadaTotal);
        this.toppings = toppings;
        this.caja = caja;
    }
    public Pizza(Lista toppings, String caja, String nombre, String descripcion, int precio, long ingresosGenerados, Categoria categoria, int cantidadOrdenada, int cantOrdenadaTotal, int cantidadEnCombo) {
        super(nombre, descripcion, precio, ingresosGenerados, categoria, cantidadOrdenada, cantOrdenadaTotal);
        this.toppings = toppings;
        this.caja = caja;
        this.cantidadEnCombo = cantidadEnCombo;
    }


    public Pizza crearCopias() {
        return new Pizza(toppings, caja, nombre, descripcion, precio, ingresosGenerados, categoria, cantidadOrdenada, cantOrdenadaTotal);
    }
    public Pizza crearCopias2(int cantidadEnCombo) {
        return new Pizza(toppings, caja, nombre, descripcion, precio, ingresosGenerados, categoria, cantidadOrdenada, cantOrdenadaTotal, cantidadEnCombo);
    }

    public Pizza() {
        super();
        toppings = new Lista();
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public Lista getToppings() {
        return toppings;
    }

    public void setToppings(Lista toppings) {
        this.toppings = toppings;
    }

    public boolean agregarTopping(Topping topping, int cantidad) {

        Topping nuevo = new Topping(topping.getNombre(), topping.getDescripcion(), topping.getCategoria(), topping.getCantidadDisponible());
        nuevo.setCantidadNecesaria(cantidad);
        return toppings.agregar(nuevo);
    }

    public boolean removerTopping(String nombre) {
        return toppings.eliminar(new Topping(nombre));
    }

    public void modificarTopping(String nombre, int cantidad) {
        Topping modificar = (Topping) toppings.consultar(new Topping(nombre));
        modificar.setCantidadNecesaria(cantidad);
    }

    @Override
    public String toString() {
        return "Pizza = "+nombre + "toppings=" + toppings + ", caja=" + caja +  " cantidad en combo:" + cantidadEnCombo +'}';
    }



    @Override
    public Pizza crearCopia() {
        return new Pizza(nombre, descripcion, precio, categoria, caja);
    }

    public boolean validarPizza(int cantOrdenada) {
        boolean valida = true;
        Lista toppings = this.getToppings();
        int cantidad = toppings.cantidad();
        Topping toppingPizza;
        Topping toppingInventario;

        int cantDisponible;
        int cantidadNecesaria;
        int cantidadNecesariaTotal;
        for (int i = 0; i < cantidad; i++) {
            toppingPizza = (Topping) toppings.obtener(i);
            toppingInventario = ProgramaPrincipal.datos.obtenerTopping(toppingPizza.getNombre());
            cantDisponible = toppingInventario.getCantidadDisponible();
            cantidadNecesaria = toppingPizza.getCantidadNecesaria();

            cantidadNecesariaTotal = cantidadNecesaria * cantOrdenada;

            if (cantDisponible - cantidadNecesariaTotal < 0) {
                valida = false;

                if (!ProgramaPrincipal.config.isProhibirVenta()) {
                    toppingInventario.reducirCantidadDisponible(cantidadNecesariaTotal);
                }
            } else {
                toppingInventario.reducirCantidadDisponible(cantidadNecesariaTotal);
            }
        }
        return valida;
    }

}
