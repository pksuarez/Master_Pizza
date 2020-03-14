/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nertrox
 */
public class ClockIn implements Serializable{
    
    private Date entrada;
    private Date salida;
    private static final long serialVersionUID = 1L;

    public ClockIn(Date entrada, Date salida) {
        this.entrada = entrada;
        this.salida = salida;
    }

    public ClockIn(Date entrada) {
        this.entrada = entrada;
    }

    public ClockIn() {
        entrada = null;
        salida = null;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        return "ClockIn{" + "entrada=" + entrada + ", salida=" + salida + '}';
    }
    
    
}
