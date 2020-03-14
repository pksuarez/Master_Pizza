/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import negocio.Lista;
import java.util.Date;

/**
 *
 * @author Nertrox
 */
public class Orden implements Serializable {

    private Lista productos;
    private Cliente cliente;
    private int numeroOrden;
    private Date fecha;
    private boolean express;
    private boolean completa;
    private boolean tarjeta;
    private int precioExpress;
    private int total;
    private static final long serialVersionUID = 1L;
    private Empleado empleado;

    public Orden() {
        productos = new Lista();
    }

    public Orden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
        completa = false;
        productos = new Lista();
    }

    public Orden(Cliente cliente, int numeroOrden, Date hora, boolean express, Empleado empleado) {
        this.cliente = cliente;
        this.numeroOrden = numeroOrden;
        this.fecha = hora;
        this.express = express;
        this.empleado = empleado;
        completa = false;
        productos = new Lista();
        
    }

    public boolean isTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getPrecioExpress() {
        return precioExpress;
    }

    public void setPrecioExpress(int precioExpress) {
        this.precioExpress = precioExpress;
    }
    
    

    public Orden(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numeroOrden = numero;
        completa = false;
        productos = new Lista();
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Lista getProductos() {
        return productos;
    }

    public void setProductos(Lista productos) {
        this.productos = productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date hora) {
        this.fecha = hora;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public boolean isExpress() {
        return express;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }

    @Override
    public String toString() {
        return "Orden{" + "productos=" + productos + ", cliente=" + cliente + ", numeroOrden=" + numeroOrden + ", fecha=" + fecha + ", express=" + express + ", completa=" + completa + ", total=" + total + ", empleado=" + empleado + '}';
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.numeroOrden;
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
        final Orden other = (Orden) obj;
        if (this.numeroOrden != other.numeroOrden) {
            return false;
        }
        return true;
    }

}
