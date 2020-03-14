/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Empleado;
import datos.Bebida;
import datos.Cliente;
import datos.Orden;
import datos.Pizza;
import datos.Producto;
import datos.Topping;
import almacenamiento.ArchivoBebida;
import almacenamiento.ArchivoCaja;
import almacenamiento.ArchivoCliente;
import almacenamiento.ArchivoCombos;
import almacenamiento.ArchivoEmpleado;
import almacenamiento.ArchivoOrdenes;
import almacenamiento.ArchivoPizza;
import almacenamiento.ArchivoProducto;
import almacenamiento.ArchivoToppings;
import datos.Caja;
import datos.Categoria;
import datos.Combo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import main.ProgramaPrincipal;

/**
 *
 * @author Nertrox
 */
public class BaseDatos {

    private final Lista clientes;
    private final Lista empleados;
    private final Lista pizzas;
    private final Lista toppings;
    private final Lista bebidas;
    private final Lista otros;
    private final Lista ordenes;
    private final Lista cajas;
    private final Lista combos;

    public BaseDatos() {

        clientes = new Lista();
        empleados = new Lista();
        pizzas = new Lista();
        toppings = new Lista();
        bebidas = new Lista();
        otros = new Lista();
        ordenes = new Lista();
        cajas = new Lista();
        combos = new Lista();

    }

    public Lista getCajas() {
        return cajas;
    }

    public Lista getClientes() {
        return clientes;
    }

    public Lista getEmpleados() {
        return empleados;
    }

    public Lista getPizzas() {
        return pizzas;
    }

    public Lista getToppings() {
        return toppings;
    }

    public Lista getBebidas() {
        return bebidas;
    }

    public Lista getOrdenes() {
        return ordenes;
    }

    public Lista getOtros() {
        return otros;
    }

    public Lista getCombos() {
        return combos;
    }

    public boolean agregarOrden(Orden orden) {
        return ordenes.agregar(orden);
    }

    public boolean agregarCombo(Combo combo) {
        return combos.agregar(combo);
    }

    public boolean removerCombo(Combo combo) {

        return combos.eliminar(combo);
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean b = clientes.agregar(cliente);
        clientes.ordenar();
        return b;
    }

    public boolean removerCliente(Cliente cliente) {

        return clientes.eliminar(cliente);
    }

    public boolean agregarEmpleado(Empleado empleado) {
        boolean b = empleados.agregar(empleado);
        empleados.ordenar();
        return b;
    }

    public boolean removerEmpleado(Empleado empleado) {

        return empleados.eliminar(empleado);
    }

    public boolean agregarProducto(Producto producto) {

        switch (producto.getCategoria()) {

            case BEBIDA: {
                boolean b = bebidas.agregar((Bebida) producto);
                bebidas.ordenar();
                return b;
            }

            case TOPPING: {
                boolean b = toppings.agregar((Topping) producto);
                toppings.ordenar();
                return b;
            }

            case OTRO: {
                boolean b = otros.agregar(producto);
                otros.ordenar();
                return b;
            }
            case PIZZA: {
                boolean b = pizzas.agregar((Pizza) producto);
                pizzas.ordenar();
                return b;
            }

            case CAJA: {
                boolean b = cajas.agregar((Caja) producto);
                cajas.ordenar();
                return b;
            }

            case COMBO: {
                boolean b = combos.agregar((Combo) producto);
                combos.ordenar();
                return b;
            }
        }

        return false;
    }

    public boolean removerProducto(Producto producto) {

        switch (producto.getCategoria()) {

            case BEBIDA: {
                return bebidas.eliminar((Bebida) producto);
            }

            case TOPPING: {
                return toppings.eliminar((Topping) producto);
            }

            case OTRO: {
                return otros.eliminar(producto);
            }

            case PIZZA: {
                return pizzas.eliminar((Pizza) producto);
            }

            case COMBO: {
                return combos.eliminar((Combo) producto);
            }
        }

        return false;
    }

    public Cliente obtenerCliente(String telefono) {
        Cliente cliente = (Cliente) clientes.consultar(new Cliente(telefono));

        return cliente;
    }

    public Empleado obtenerEmpleado(String login, String cedula) {
        Empleado empleado = (Empleado) empleados.consultar(new Empleado(cedula, login));
        return empleado;
    }

    public Pizza obtenerPizza(String nombre) {
        Pizza pizza = (Pizza) pizzas.consultar(new Pizza(nombre));
        return pizza;
    }

    public Topping obtenerTopping(String nombre) {
        Topping topping = (Topping) toppings.consultar(new Topping(nombre));
        return topping;
    }

    public Producto obtenerProducto(String nombre) {
        Producto producto = (Producto) otros.consultar(new Producto(nombre));
        return producto;
    }

    public Combo obtenerCombo(String nombre) {
        Combo combo = (Combo) combos.consultar(new Combo(nombre));
        return combo;
    }

    public Bebida obtenerBebida(String nombre) {
        Bebida bebida = (Bebida) bebidas.consultar(new Bebida(nombre));
        return bebida;
    }

    public Caja obtenerCaja(String nombre) {
        Caja caja = (Caja) cajas.consultar(new Caja(nombre));
        return caja;
    }

    public Orden obtenerOrden(int numero) {
        Orden orden = (Orden) ordenes.consultar(new Orden(numero));
        return orden;
    }

    public void cargarPizzas(String path) {
        ArchivoPizza archP = new ArchivoPizza();
        archP.leerObjetos(path);
    }

    public void guardarPizzas(String path) {
        ArchivoPizza arPizza = new ArchivoPizza();
        arPizza.escribirObjeto(path);
    }

    public void cargarCombos(String path) {
        ArchivoCombos archC = new ArchivoCombos();
        archC.leerObjetos(path);
    }

    public void guardarCombos(String path) {
        ArchivoCombos arComb = new ArchivoCombos();
        arComb.escribirObjeto(path);
    }

    public void cargarToppings(String path) {
        ArchivoToppings archivo = new ArchivoToppings();
        archivo.leerObjetos(path);
    }

    public void guardarToppings(String path) {
        ArchivoToppings archivo = new ArchivoToppings();
        archivo.escribirObjeto(path);
    }

    public void cargarBebidas(String path) {
        ArchivoBebida archivo = new ArchivoBebida();
        archivo.leerObjetos(path);
    }

    public void guardarBebidas(String path) {
        ArchivoBebida archivo = new ArchivoBebida();
        archivo.escribirObjeto(path);
    }

    public void cargarOtros(String path) {
        ArchivoProducto archivo = new ArchivoProducto();
        archivo.leerObjetos(path);
    }

    public void guardarOtros(String path) {
        ArchivoProducto archivo = new ArchivoProducto();
        archivo.escribirObjeto(path);
    }

    public void cargarClientes(String path) {
        ArchivoCliente archivo = new ArchivoCliente();
        archivo.leerObjetos(path);
    }

    public void guardarClientes(String path) {
        ArchivoCliente archivo = new ArchivoCliente();
        archivo.escribirObjeto(path);
    }

    public void cargarEmpleados(String path) {
        ArchivoEmpleado archivo = new ArchivoEmpleado();
        archivo.leerObjetos(path);
    }

    public void guardarEmpleados(String path) {
        ArchivoEmpleado archivo = new ArchivoEmpleado();
        archivo.escribirObjeto(path);
    }

    public void guardarCajas(String pathCajas) {
        ArchivoCaja archivo = new ArchivoCaja();
        archivo.escribirObjeto(pathCajas);
    }

    public void cargarCajas(String path) {
        ArchivoCaja archivo = new ArchivoCaja();
        archivo.leerObjetos(path);
    }

    public void cargarOdenes(String path) {
        ArchivoOrdenes archivo = new ArchivoOrdenes();
        archivo.leerObjetos(path);
    }

    public void guardarOrdenes(String path) {
        ArchivoOrdenes archivo = new ArchivoOrdenes();
        archivo.escribirObjeto(path);
    }

    public int obtenerNumeroOrden() {

        return (ordenes.largo() + 1);
    }

    public Map backUpToppings() {

        int largo = toppings.cantidad();
        Map<String, Integer> backUp = new HashMap<String, Integer>();

        for (int i = 0; i < largo; i++) {
            Topping t = (Topping) toppings.obtener(i);
            backUp.put(t.getNombre(), t.getCantidadDisponible());
        }

        return backUp;
    }

    public void restaurarToppings(Map backup) {
        Topping t;
        for (int i = 0; i < toppings.cantidad(); i++) {
            t = (Topping) toppings.obtener(i);
            int cantidad = (Integer) backup.get(t.getNombre());
            t.setCantidadDisponible(cantidad);
        }

    }

    public ArrayList<Bebida> revisarBebidas(int min) {
        int largo = bebidas.cantidad();
        ArrayList<Bebida> bajas = new ArrayList<>();
        for (int i = 0; i < largo; i++) {
            Bebida prod = (Bebida) bebidas.obtener(i);

            if (prod.getDisponibles() <= min) {
                bajas.add(prod);
            }
        }

        return bajas;
    }

    public ArrayList<Topping> revisarToppings(int min) {
        int largo = toppings.cantidad();
        ArrayList<Topping> bajas = new ArrayList<>();
        for (int i = 0; i < largo; i++) {
            Topping prod = (Topping) toppings.obtener(i);

            if (prod.getCantidadDisponible() <= min) {
                bajas.add(prod);
            }
        }
        return bajas;
    }

    public ArrayList<Caja> revisarCajas(int min) {
        int largo = cajas.cantidad();
        ArrayList<Caja> bajas = new ArrayList<>();
        for (int i = 0; i < largo; i++) {
            Caja prod = (Caja) cajas.obtener(i);

            if (prod.getCantidadDisponible() <= min) {
                bajas.add(prod);
            }
        }
        return bajas;
    }

    public Map backUpBebidas() {

        int largo = bebidas.cantidad();
        Map<String, Integer> backUp = new HashMap<String, Integer>();

        for (int i = 0; i < largo; i++) {
            Bebida b = (Bebida) bebidas.obtener(i);
            backUp.put(b.getNombre(), b.getDisponibles());
        }

        return backUp;
    }

    public void restaurarBebidas(Map backup) {

        for (int i = 0; i < bebidas.cantidad(); i++) {
            Bebida b = (Bebida) bebidas.obtener(i);
            int cantidad = (Integer) backup.get(b.getNombre());
            b.setDisponibles(cantidad);
        }

    }

    public void actualizarCantCajas(Orden o) {
        Lista productos = o.getProductos();
        Producto p;
        Lista prodsCombo;
        Caja c;
        for (int i = 0; i < productos.cantidad(); i++) {
            p = (Producto) productos.obtener(i);
            if (p.getCategoria() == Categoria.PIZZA) {
                Pizza pizza = (Pizza) p;
                c = (Caja) cajas.consultar(new Caja(pizza.getCaja()));
                c.reducirCantidadDisponibe(p.getCantidadOrdenada());
            }

            if (p.getCategoria() == Categoria.COMBO) {
                Combo combo = (Combo) productos.obtener(i);
                //System.out.println(combo);
                prodsCombo = combo.getProductos();

                for (int j = 0; j < prodsCombo.cantidad(); j++) {
                    Producto enCombo = (Producto) prodsCombo.obtener(j);

                    if (enCombo.getCategoria() == Categoria.PIZZA) {
                        Pizza pizzaCombo = (Pizza) enCombo;
                        c = (Caja) cajas.consultar(new Caja(pizzaCombo.getCaja()));
                        int cantCajas = pizzaCombo.getCantidadEnCombo() * p.getCantidadOrdenada();
                        //System.out.println("Cantidad de cajas: "+cantCajas);
                        c.reducirCantidadDisponibe(cantCajas);
                    }
                }
            }
        }

    }

    public void actualizarCantidadesTotales(Orden o) {

        Lista productos = o.getProductos();
        Producto p;
        for (int i = 0; i < productos.cantidad(); i++) {
            p = (Producto) productos.obtener(i);

            switch (p.getCategoria()) {
                case BEBIDA: {
                    Bebida b = (Bebida) bebidas.consultar(new Bebida(p.getNombre()));
                    //System.out.println("AUMENTANDO\n" +b);
                    b.aumetarCantOrdenadaTotal(p.getCantidadOrdenada());
                    b.aumentarIngresos(p.getCantidadOrdenada() * p.getPrecio());
                    break;
                }

                case OTRO: {
                    Producto otro = (Producto) otros.consultar(new Producto(p.getNombre()));
                    //System.out.println("AUMENTANDO\n" + otro );
                    otro.aumetarCantOrdenadaTotal(p.getCantidadOrdenada());
                    otro.aumentarIngresos(p.getCantidadOrdenada() * p.getPrecio());
                    break;
                }

                case PIZZA: {
                    Pizza pizza = (Pizza) pizzas.consultar(new Pizza(p.getNombre()));
                    //System.out.println("AUMENTANDO\n" + pizza);
                    pizza.aumentarIngresos(p.getCantidadOrdenada() * p.getPrecio());
                    pizza.aumetarCantOrdenadaTotal(p.getCantidadOrdenada());
                    break;
                }
                case COMBO: {
                    Combo combo = (Combo) combos.consultar(new Combo(p.getNombre()));
                    combo.aumentarIngresos(p.getCantidadOrdenada() * p.getPrecio());
                    //System.out.println("AUMENTANDO " + combo + " en " +p.getCantidadOrdenada() +" ingresos en: " +(p.getCantidadOrdenada() * p.getPrecio()) );
                    combo.aumetarCantOrdenadaTotal(p.getCantidadOrdenada());
                    break;
                }
            }

        }
    }

    public ArrayList<Orden> buscarOrdenesFecha(Date desde, Date hasta) {
        ArrayList<Orden> encontradas = new ArrayList<>();
        for (int i = 0; i < ordenes.cantidad(); i++) {

            Orden o = (Orden) ordenes.obtener(i);
            Date fecha = o.getFecha();
            if ((fecha.after(desde) || fecha.equals(desde)) && (fecha.before(hasta) || fecha.equals(hasta))) {
                encontradas.add(o);
            }

        }
        return encontradas;
    }

    /**
     * 0 = por cliente 1 = por empleado 2 = por numero de orden
     *
     * @param criterio
     * @param buscado
     * @param extensa true si hay que buscar por nombre
     */
    public ArrayList<Orden> buscarOrden(int criterio, String buscado, boolean extensa) {
        ArrayList<Orden> encontradas = new ArrayList<>();

        if (criterio == 2) {
            Orden o = obtenerOrden(Integer.parseInt(buscado));
            if (o != null) {
                encontradas.add(o);
            }

        } else {
            for (int i = 0; i < ordenes.cantidad(); i++) {
                Orden o = (Orden) ordenes.obtener(i);
                if (criterio == 0) {
                    if (extensa) {
                        if (o.getCliente().getNombre().toLowerCase().contains(buscado)) {
                            encontradas.add(o);
                        }
                    }

                    if (!extensa) {
                        if (o.getCliente().getTelefono().equals(buscado)) {
                            encontradas.add(o);
                        }
                    }
                }

                if (criterio == 1) {

                    if (extensa) {
                        if (o.getEmpleado().getNombre().toLowerCase().contains(buscado)) {
                            encontradas.add(o);
                        }
                    }

                    if (!extensa) {
                        if (o.getEmpleado().getLogin().toLowerCase().equals(buscado)) {
                            encontradas.add(o);
                        }
                    }

                }
            }
        }

        return encontradas;
    }

    /**
     * true = por nombre false = por telefono
     *
     * @param criterio
     * @return
     */
    public ArrayList<Cliente> buscarClientes(boolean criterio, String buscado) {

        ArrayList<Cliente> encontrados = new ArrayList<>();
        Cliente c;
        if (criterio) {
            for (int i = 0; i < clientes.cantidad(); i++) {
                c = (Cliente) clientes.obtener(i);
                if (c.getNombre().toLowerCase().contains(buscado)) {
                    encontrados.add(c);
                }
            }
        } else {
            c = obtenerCliente(buscado);
            if (c != null) {
                encontrados.add(c);
            }
        }

        return encontrados;
    }

    public void resetearIngredientesCajas() {
        Topping t;
        Caja c;
        for (int i = 0; i < toppings.cantidad(); i++) {
            t = (Topping) toppings.obtener(i);
            t.setCantidadDisponible(0);

        }

        for (int i = 0; i < cajas.cantidad(); i++) {
            c = (Caja) cajas.obtener(i);
            c.setCantidadDisponible(0);
        }

        guardarCajas(ProgramaPrincipal.pathCajas);
        guardarToppings(ProgramaPrincipal.pathT);
    }

    public void resetearVentas() {
        Pizza p;
        Combo c;
        Bebida b;
        Producto o;

        for (int i = 0; i < pizzas.cantidad(); i++) {
            p = (Pizza) pizzas.obtener(i);
            p.setCantOrdenadaTotal(0);
            p.setIngresosGenerados(0);

        }

        for (int i = 0; i < combos.cantidad(); i++) {
            c = (Combo) combos.obtener(i);
            c.setCantOrdenadaTotal(0);
            c.setIngresosGenerados(0);

        }

        for (int i = 0; i < bebidas.cantidad(); i++) {
            b = (Bebida) bebidas.obtener(i);
            b.setCantOrdenadaTotal(0);
            b.setIngresosGenerados(0);

        }

        for (int i = 0; i < otros.cantidad(); i++) {
            o = (Producto) otros.obtener(i);
            o.setCantOrdenadaTotal(0);
            o.setIngresosGenerados(0);

        }

        guardarBebidas(ProgramaPrincipal.pathB);
        guardarCombos(ProgramaPrincipal.pathCombos);
        guardarPizzas(ProgramaPrincipal.pathP);
        guardarOtros(ProgramaPrincipal.pathProd);
    }
}
