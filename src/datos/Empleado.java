/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Nertrox
 */
public class Empleado implements Serializable, Comparable<Empleado> {

    private String nombre, apellido, cedula, login, contrasena;
    private Date contratado, terminado;
    private ArrayList<ClockIn> entradaSalida;
    private String telefono;
    private boolean administrador;
    private static final long serialVersionUID = 1L;
    private boolean usuarioMaestro;

    public Empleado(String nombre, String apellido, String cedula, String login, String contrasena, String numero, boolean administrador, Date contratado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.login = login;
        this.contrasena = contrasena;
        this.telefono = numero;
        this.administrador = administrador;
        this.contratado = contratado;
        this.entradaSalida = new ArrayList<>();
    }

    public Empleado(String cedula, String login) {
        this.cedula = cedula;
        this.login = login;
    }

    public Empleado(String nombre, String apellido, String cedula, String login, String contrasena, Date contratado, Date terminado, String numero, boolean administrador) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.login = login;
        this.contrasena = contrasena;
        this.contratado = contratado;
        this.terminado = terminado;
        this.telefono = numero;
        this.administrador = administrador;
        this.entradaSalida = new ArrayList<>();
    }

    public void marcarRegistro(ClockIn registro) {
        entradaSalida.add(registro);
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getContratado() {
        return contratado;
    }

    public void setContratado(Date contratado) {
        this.contratado = contratado;
    }

    public Date getTerminado() {
        return terminado;
    }

    public void setTerminado(Date terminado) {
        this.terminado = terminado;
    }

    public String getNumero() {
        return telefono;
    }

    public void setNumero(String numero) {
        this.telefono = numero;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isUsuarioMaestro() {
        return usuarioMaestro;
    }

    public void setUsuarioMaestro(boolean usuarioMaestro) {
        this.usuarioMaestro = usuarioMaestro;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.cedula);
        hash = 13 * hash + Objects.hashCode(this.login);
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
        final Empleado other = (Empleado) obj;
        if ((!Objects.equals(this.cedula, other.cedula)) && (!Objects.equals(this.login.toLowerCase(), other.login.toLowerCase()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", login=" + login + ", contrasena=" + contrasena + ", contratado=" + contratado + ", terminado=" + terminado + ", entradaSalida=" + entradaSalida + ", numero=" + telefono + ", administrador=" + administrador + '}';
    }

    @Override
    public int compareTo(Empleado o) {
        return nombre.compareTo(o.nombre);
    }

    public ArrayList<ClockIn> obtenerFechas(Date desde, Date hasta) {
        ArrayList<ClockIn> fechas = new ArrayList<>();
        ClockIn clock;
        for (int i = 0; i < entradaSalida.size(); i++) {

            Date d1 = entradaSalida.get(i).getEntrada();
            Date d2 = entradaSalida.get(i).getSalida();

            if (d1.after(desde) || d1.equals(desde)) {
                if (d2.before(hasta) || d2.equals(hasta)) {
                    clock = new ClockIn(d1, d2);
                    fechas.add(clock);
                }
            }
        }
        return fechas;
    }

}
