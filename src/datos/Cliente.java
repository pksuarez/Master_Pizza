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
public class Cliente implements Serializable, Comparable<Cliente> {

    private String nombre, apellido, direccion, telefono;
    private int cantOrdenes;
    private long dineroGastado;
    private static final long serialVersionUID = 1L;

    public Cliente(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        cantOrdenes = 0;
        dineroGastado = 0;
    }

    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        cantOrdenes = 0;
        dineroGastado =0;
    }

    public Cliente(String telefono) {
        this.telefono = telefono;
    }

    public void aumentarOrdenes(int cantidad) {
        cantOrdenes += cantidad;
    }
    
    public void aumentarDineroGastado(int cantidad) {
        dineroGastado += cantidad;
    }
    
    public long getDineroGastado(){
        return dineroGastado;
    }
    public int getCantOrdenes(){
        return cantOrdenes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.telefono);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", cantOrdenes=" + cantOrdenes + '}';
    }

    

    @Override
    public int compareTo(Cliente o) {
        return nombre.compareTo(o.nombre);
    }
}
