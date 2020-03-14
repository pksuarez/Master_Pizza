/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Nertrox
 */
public class Producto implements Serializable, Comparable<Producto> {

    protected String nombre, descripcion;
    protected int precio;
    protected long ingresosGenerados;
    protected Categoria categoria;
    protected static final long serialVersionUID = 1L;
    protected int cantidadOrdenada;
    protected int cantOrdenadaTotal;
    protected int cantidadEnCombo;

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
        categoria = Categoria.OTRO;
        cantOrdenadaTotal = 0;
        ingresosGenerados = 0;
        cantidadOrdenada = 0;
    }

    public Producto(String nombre, String descripcion, int precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        cantOrdenadaTotal = 0;
        ingresosGenerados = 0;
        cantidadOrdenada = 0;
        cantidadEnCombo = 0;
    }

    public Producto(String nombre, String descripcion, int precio, long ingresosGenerados, Categoria categoria, int cantidadOrdenada, int cantOrdenadaTotal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingresosGenerados = ingresosGenerados;
        this.categoria = categoria;
        this.cantidadOrdenada = cantidadOrdenada;
        this.cantOrdenadaTotal = cantOrdenadaTotal;
    }

    public Producto(String nombre, String descripcion, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        cantOrdenadaTotal = 0;
        ingresosGenerados = 0;
        cantidadOrdenada = 0;
        cantidadEnCombo = 0;
    }

    public int getCantidadOrdenada() {
        return cantidadOrdenada;
    }

    public void setCantidadOrdenada(int cantidadOrdenada) {
        this.cantidadOrdenada = cantidadOrdenada;
    }

    public void setIngresosGenerados(long ingresosGenerados) {
        this.ingresosGenerados = ingresosGenerados;
    }

    public void setCantOrdenadaTotal(int cantOrdenadaTotal) {
        this.cantOrdenadaTotal = cantOrdenadaTotal;
    }

    public long getIngresosGenerados() {
        return ingresosGenerados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEnCombo() {
        return cantidadEnCombo;
    }

    public void setCantidadEnCombo(int cantidadEnCombo) {
        this.cantidadEnCombo = cantidadEnCombo;
    }

    
    public void aumetarCantOrdenadaTotal(int cantidad) {
        this.cantOrdenadaTotal += cantidad;

    }

    public void aumentarIngresos(int cantidad) {
        this.ingresosGenerados += cantidad;
    }

    public int getCantOrdenadaTotal() {
        return cantOrdenadaTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase())) {
            return false;
        }
        return true;
    }
    public void aumentarCantidadEnCombo(int cantidad){
        this.cantidadEnCombo+=cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", categoria=" + categoria + ", cantidadOrdenada=" + cantidadOrdenada + ", cantOrdenadaTotal=" + cantOrdenadaTotal + " cantidad en combo:" + cantidadEnCombo + '}';
    }

    public Producto crearCopia() {
        return new Producto(nombre, descripcion, precio, categoria);
    }

    @Override
    public int compareTo(Producto o) {
        return nombre.compareTo(o.nombre);
    }
}
