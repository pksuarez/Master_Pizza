/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import main.ProgramaPrincipal;
import datos.Bebida;
import datos.Caja;
import datos.Combo;
import datos.Pizza;
import datos.Producto;
import datos.Topping;
import java.awt.Font;
import negocio.Lista;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Nertrox
 */
public class FrModificarProductos extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    private final DefaultListModel<String> listModelPizza = new DefaultListModel<String>();

    public FrModificarProductos() {

        initComponents();
        setLocationRelativeTo(null);
        llenarTablaOtros();
        llenarTablaBebidas();
        llenarTablaCajas();
        llenarTablaToppings();
        llenarTablaPizzas();
        llenarTablaCombos();

    }

    private void llenarTablaCajas() {
        JTabbleCajas.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) JTabbleCajas.getModel();
        int cantidad = ProgramaPrincipal.datos.getCajas().largo();
        Lista otros = ProgramaPrincipal.datos.getCajas();
        Caja caja;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                caja = (Caja) otros.obtener(i);
                model.addRow(new Object[]{caja.getNombre(), caja.getCantidadDisponible(), caja.getTamano()});
            }
        }
    }

    private void llenarTablaPizzas() {
        jTablePizzas.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel modelo = (DefaultTableModel) jTablePizzas.getModel();
        int cantidad = ProgramaPrincipal.datos.getPizzas().largo();
        Lista pizzas = ProgramaPrincipal.datos.getPizzas();
        Pizza pizza;
        String tam;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                pizza = (Pizza) pizzas.obtener(i);
                tam = String.valueOf(jComboBox1.getSelectedItem()).toLowerCase();
                if (pizza.getNombre().toLowerCase().contains(tam)) {
                    modelo.addRow(new Object[]{pizza.getNombre()});
                }
            }
        }
    }


    private void llenarTablaToppings() {

        int cant = ProgramaPrincipal.datos.getToppings().largo();
        jTableToppings.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        if (cant > 0) {
            DefaultTableModel tablaToppings = (DefaultTableModel) jTableToppings.getModel();
            Object fila[] = new Object[1];
            Topping topping;
            for (int i = 0; i < cant; i++) {
                topping = (Topping) ProgramaPrincipal.datos.getToppings().obtener(i);
                fila[0] = topping.getNombre();
                tablaToppings.addRow(fila);

            }
        }

    }

    private void formatearTablaBebidas() {

        String value = "₡";
        String value2 = "";
        String precio;

        for (int i = 0; i < jTableBebidas.getRowCount(); i++) {
            precio = String.valueOf(jTableBebidas.getValueAt(i, 5));
            String tamano = String.valueOf(jTableBebidas.getValueAt(i, 3));
            value += String.format("%,d", Integer.valueOf(precio));
            value2 = String.format("%,d", Integer.valueOf(tamano));
            jTableBebidas.setValueAt(value, i, 5);
            jTableBebidas.setValueAt(value2, i, 3);
            value = "₡";
            value2 = "";
        }

    }

    private void formatearTablaOtros() {

        String value = "₡";
        String precio;

        for (int i = 0; i < jTableOtros.getRowCount(); i++) {
            precio = String.valueOf(jTableOtros.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(precio));
            jTableOtros.setValueAt(value, i, 2);
            value = "₡";
        }
    }

    private void llenarTablaCombos() {
        jTableCombos.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) jTableCombos.getModel();
        int cantidad = ProgramaPrincipal.datos.getCombos().largo();
        Lista combos = ProgramaPrincipal.datos.getCombos();
        Combo combo;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                combo = (Combo) combos.obtener(i);
                model.addRow(new Object[]{combo.getNombre()});
            }
        }

    }

    private void llenarTablaBebidas() {
        jTableBebidas.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) jTableBebidas.getModel();
        model.setRowCount(0);
        int cantidadBebidas = ProgramaPrincipal.datos.getBebidas().largo();
        Lista bebidas = ProgramaPrincipal.datos.getBebidas();
        Bebida bebida;
        if (cantidadBebidas > 0) {
            for (int i = 0; i < cantidadBebidas; i++) {
                bebida = (Bebida) bebidas.obtener(i);
                model.addRow(new Object[]{bebida.getNombre(), bebida.getDescripcion(), bebida.getMarca(), bebida.getTamano(), bebida.getSabor(), bebida.getPrecio()});
            }
        }

        formatearTablaBebidas();
        for (int i = 0; i < jTableBebidas.getColumnCount(); i++) {
            TableColumn col = jTableBebidas.getColumnModel().getColumn(i);
            col.setCellEditor(new MyTableCellEditor());
            col.setCellRenderer(new MyTableCellRenderer());
        }
    }

    private void llenarTablaOtros() {
        jTableOtros.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) jTableOtros.getModel();
        model.setRowCount(0);
        int cantidad = ProgramaPrincipal.datos.getOtros().largo();
        Lista otros = ProgramaPrincipal.datos.getOtros();
        Producto producto;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                producto = (Producto) otros.obtener(i);
                model.addRow(new Object[]{producto.getNombre(), producto.getDescripcion(), producto.getPrecio()});
            }
        }

        formatearTablaOtros();

        for (int i = 0; i < jTableOtros.getColumnCount(); i++) {
            TableColumn col = jTableOtros.getColumnModel().getColumn(i);
            col.setCellEditor(new MyTableCellEditor());
            col.setCellRenderer(new MyTableCellRenderer());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButtonEditarPizza = new javax.swing.JButton();
        jButtonEliminarPizza = new javax.swing.JButton();
        jButtonAddTopping = new javax.swing.JButton();
        jButtonSalirPizza = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePizzas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCombos = new javax.swing.JTable();
        jButtonEditarPizza1 = new javax.swing.JButton();
        jButtonEliminarPizza1 = new javax.swing.JButton();
        jButtonSalirPizza1 = new javax.swing.JButton();
        jButtonAddTopping1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBebidas = new javax.swing.JTable();
        jButtonEliminarBebida = new javax.swing.JButton();
        jButtonGuardarBebidas = new javax.swing.JButton();
        jButtonEliminarBebida1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonGuardarOtros = new javax.swing.JButton();
        jButtonEliminarOtros = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOtros = new javax.swing.JTable();
        jButtonEliminarOtros1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTabbleCajas = new javax.swing.JTable();
        jButtonElimCajas = new javax.swing.JButton();
        jButtonElimCajas1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableToppings = new javax.swing.JTable();
        jButtonElimTop = new javax.swing.JButton();
        jButtonElimTop1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 107, 70), 10, true));

        JTabbedPane.setBackground(new java.awt.Color(149, 165, 166));
        JTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        JTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        JTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(149, 165, 166));

        jButtonEditarPizza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEditarPizza.setText("Editar");
        jButtonEditarPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPizzaActionPerformed(evt);
            }
        });

        jButtonEliminarPizza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminarPizza.setText("Eliminar");
        jButtonEliminarPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPizzaActionPerformed(evt);
            }
        });

        jButtonAddTopping.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddTopping.setText("Agregar Toppings");
        jButtonAddTopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddToppingActionPerformed(evt);
            }
        });

        jButtonSalirPizza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSalirPizza.setText("Salir");
        jButtonSalirPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirPizzaActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERSONAL", "MEDIANA", "GRANDE", "FAMILIAR", "FIESTA", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTablePizzas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTablePizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePizzas.setRowHeight(40);
        jTablePizzas.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTablePizzas);
        if (jTablePizzas.getColumnModel().getColumnCount() > 0) {
            jTablePizzas.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalirPizza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddTopping, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
                        .addComponent(jButtonEliminarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonEditarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAddTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButtonEditarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jButtonEliminarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButtonSalirPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("Pizzas", jPanel2);

        jPanel7.setBackground(new java.awt.Color(149, 165, 166));

        jTableCombos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCombos.setRowHeight(40);
        jTableCombos.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableCombos);
        if (jTableCombos.getColumnModel().getColumnCount() > 0) {
            jTableCombos.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonEditarPizza1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEditarPizza1.setText("Editar");
        jButtonEditarPizza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarPizza1ActionPerformed(evt);
            }
        });

        jButtonEliminarPizza1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminarPizza1.setText("Eliminar");
        jButtonEliminarPizza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPizza1ActionPerformed(evt);
            }
        });

        jButtonSalirPizza1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSalirPizza1.setText("Salir");
        jButtonSalirPizza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirPizza1ActionPerformed(evt);
            }
        });

        jButtonAddTopping1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddTopping1.setText("Agregar Productos");
        jButtonAddTopping1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTopping1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonSalirPizza1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditarPizza1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEliminarPizza1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                    .addComponent(jButtonAddTopping1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButtonAddTopping1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButtonEditarPizza1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButtonEliminarPizza1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButtonSalirPizza1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );

        JTabbedPane.addTab("Combos", jPanel7);

        jPanel3.setBackground(new java.awt.Color(149, 165, 166));

        jTableBebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Marca", "Tamaño (mL)", "Sabor", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBebidas.setRowHeight(40);
        jTableBebidas.getTableHeader().setReorderingAllowed(false);
        jTableBebidas.getTableHeader().setResizingAllowed(false);
        jTableBebidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableBebidas);
        if (jTableBebidas.getColumnModel().getColumnCount() > 0) {
            jTableBebidas.getColumnModel().getColumn(0).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(0).setPreferredWidth(125);
            jTableBebidas.getColumnModel().getColumn(1).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableBebidas.getColumnModel().getColumn(2).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(3).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTableBebidas.getColumnModel().getColumn(4).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(5).setResizable(false);
        }

        jButtonEliminarBebida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminarBebida.setText("Eliminar");
        jButtonEliminarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarBebidaActionPerformed(evt);
            }
        });

        jButtonGuardarBebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonGuardarBebidas.setText("Guardar Cambios");
        jButtonGuardarBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarBebidasActionPerformed(evt);
            }
        });

        jButtonEliminarBebida1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminarBebida1.setText("Salir");
        jButtonEliminarBebida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarBebida1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonEliminarBebida1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(jButtonEliminarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminarBebida1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardarBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        JTabbedPane.addTab("Bebidas", jPanel3);

        jPanel5.setBackground(new java.awt.Color(149, 165, 166));

        jButtonGuardarOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonGuardarOtros.setText("Guardar Cambios");
        jButtonGuardarOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarOtrosActionPerformed(evt);
            }
        });

        jButtonEliminarOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminarOtros.setText("Eliminar");
        jButtonEliminarOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarOtrosActionPerformed(evt);
            }
        });

        jTableOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableOtros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOtros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableOtros.setRowHeight(40);
        jTableOtros.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableOtros);
        if (jTableOtros.getColumnModel().getColumnCount() > 0) {
            jTableOtros.getColumnModel().getColumn(0).setResizable(false);
            jTableOtros.getColumnModel().getColumn(1).setResizable(false);
            jTableOtros.getColumnModel().getColumn(2).setResizable(false);
        }

        jButtonEliminarOtros1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEliminarOtros1.setText("Salir");
        jButtonEliminarOtros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarOtros1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonEliminarOtros1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminarOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jButtonGuardarOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardarOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarOtros1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        JTabbedPane.addTab("Otros", jPanel5);

        jPanel4.setBackground(new java.awt.Color(149, 165, 166));

        JTabbleCajas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JTabbleCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTabbleCajas.setFocusable(false);
        JTabbleCajas.setRowHeight(40);
        JTabbleCajas.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(JTabbleCajas);
        if (JTabbleCajas.getColumnModel().getColumnCount() > 0) {
            JTabbleCajas.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonElimCajas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonElimCajas.setText("Eliminar");
        jButtonElimCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimCajasActionPerformed(evt);
            }
        });

        jButtonElimCajas1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonElimCajas1.setText("Salir");
        jButtonElimCajas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimCajas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonElimCajas1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonElimCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(406, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonElimCajas1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonElimCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        JTabbedPane.addTab("Cajas", jPanel4);

        jPanel6.setBackground(new java.awt.Color(149, 165, 166));

        jTableToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableToppings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableToppings.setRowHeight(40);
        jScrollPane4.setViewportView(jTableToppings);
        if (jTableToppings.getColumnModel().getColumnCount() > 0) {
            jTableToppings.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonElimTop.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonElimTop.setText("Eliminar");
        jButtonElimTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimTopActionPerformed(evt);
            }
        });

        jButtonElimTop1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonElimTop1.setText("Salir");
        jButtonElimTop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimTop1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jButtonElimTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jButtonElimTop, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonElimTop, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonElimTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        JTabbedPane.addTab("Toppings", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1291, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPizzaActionPerformed
        String pizza = String.valueOf(jTablePizzas.getValueAt(jTablePizzas.getSelectedRow(), 0));
        FrEditarPizza frpizza = new FrEditarPizza(pizza);
        frpizza.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonEditarPizzaActionPerformed

    private void jButtonEliminarPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPizzaActionPerformed
        String pizza = String.valueOf(jTablePizzas.getValueAt(jTablePizzas.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar esta pizza?", "Eliminar Pizza", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        DefaultTableModel modelo = (DefaultTableModel) jTablePizzas.getModel();
        if (opcion == JOptionPane.YES_OPTION) {
            modelo.removeRow(jTablePizzas.getSelectedRow());
            ProgramaPrincipal.datos.removerProducto(new Pizza(pizza));
            ProgramaPrincipal.datos.guardarPizzas(ProgramaPrincipal.pathP);
        }


    }//GEN-LAST:event_jButtonEliminarPizzaActionPerformed

    private void jButtonGuardarBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarBebidasActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableBebidas.getModel();
        int filas = jTableBebidas.getRowCount();
        Bebida bebida;
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea guardar los cambios?", "Guardar", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            for (int i = 0; i < filas; i++) {
                String nombre = String.valueOf(model.getValueAt(i, 0));
                String descripcion = String.valueOf(model.getValueAt(i, 1));
                String marca = String.valueOf(model.getValueAt(i, 2));
                String tamano = String.valueOf(model.getValueAt(i, 3));
                String sabor = String.valueOf(model.getValueAt(i, 4));
                String precio = String.valueOf(model.getValueAt(i, 5));
                if (descripcion.equals("") || marca.equals("") || tamano.equals("") || sabor.equals("") || precio.equals("")) {
                    JOptionPane.showMessageDialog(this, "Ha dejado algun dato en blanco!");
                }
                try {

                    precio = quitarColon(precio);
                    tamano = desformatear(tamano);
                    int p = Integer.parseInt(precio);
                    int t = Integer.parseInt(tamano);

                    bebida = ProgramaPrincipal.datos.obtenerBebida(nombre);
                    bebida.setDescripcion(descripcion);
                    bebida.setTamano(t);
                    bebida.setMarca(marca);
                    bebida.setSabor(sabor);
                    bebida.setPrecio(p);
                } catch (NumberFormatException e) {
                    JOptionPane.showConfirmDialog(this, "Ha ingresado una letra en el precio o en el tamaño!");
                }

            }
            llenarTablaBebidas();
            ProgramaPrincipal.datos.guardarBebidas(ProgramaPrincipal.pathB);

        } else {
            llenarTablaBebidas();
        }

    }//GEN-LAST:event_jButtonGuardarBebidasActionPerformed

    private String desformatear(String value) {

        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i < formateado.length; i++) {
            desformateado += formateado[i];
        }

        return desformateado;
    }

    private String quitarColon(String valor) {
        String desformateado;

        if (valor.charAt(0) == '₡') {
            desformateado = valor.substring(1);
            desformateado = desformatear(desformateado);
        } else {
            desformateado = desformatear(valor);
        }

        return desformateado;
    }


    private void jButtonEliminarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarBebidaActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableBebidas.getModel();
        String nombre = String.valueOf(model.getValueAt(jTableBebidas.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar esta bebida?", "Eliminar Bebida", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            model.removeRow(jTableBebidas.getSelectedRow());
            ProgramaPrincipal.datos.getBebidas().eliminar(new Bebida(nombre));
            ProgramaPrincipal.datos.guardarBebidas(ProgramaPrincipal.pathB);
        }


    }//GEN-LAST:event_jButtonEliminarBebidaActionPerformed

    private void jButtonGuardarOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarOtrosActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableOtros.getModel();
        int filas = jTableOtros.getRowCount();
        Producto producto;

        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea guardar los cambios?", "Guardar", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            for (int i = 0; i < filas; i++) {
                String nombre = String.valueOf(model.getValueAt(i, 0));
                String descripcion = String.valueOf(model.getValueAt(i, 1));
                String precio = String.valueOf(model.getValueAt(i, 2));
                if (descripcion.equals("") || precio.equals("")) {
                    JOptionPane.showMessageDialog(this, "Ha dejado algun dato en blanco!");
                }
                try {
                    precio = quitarColon(precio);
                    int p = Integer.parseInt(precio);
                    producto = ProgramaPrincipal.datos.obtenerProducto(nombre);
                    producto.setDescripcion(descripcion);
                    producto.setPrecio(p);

                } catch (NumberFormatException e) {
                    JOptionPane.showConfirmDialog(this, "Ha ingresado una letra en el precio!");
                }

            }
            ProgramaPrincipal.datos.guardarOtros(ProgramaPrincipal.pathProd);
            llenarTablaOtros();

        } else {
            llenarTablaOtros();
        }

    }//GEN-LAST:event_jButtonGuardarOtrosActionPerformed

    private void jButtonEliminarOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarOtrosActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableOtros.getModel();
        String nombre = String.valueOf(model.getValueAt(jTableOtros.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este producto?", "Eliminar Producto", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        int seleccionada = jTableOtros.getSelectedRow();
        //jTableOtros.setRowSelectionInterval(0, 0);
        if (opcion == JOptionPane.YES_OPTION) {
            model.removeRow(seleccionada);
            ProgramaPrincipal.datos.getOtros().eliminar(new Producto(nombre));
            ProgramaPrincipal.datos.guardarOtros(ProgramaPrincipal.pathProd);
        }
    }//GEN-LAST:event_jButtonEliminarOtrosActionPerformed

    private void jButtonAddToppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddToppingActionPerformed
        String pizza = String.valueOf(jTablePizzas.getValueAt(jTablePizzas.getSelectedRow(), 0));
        JFrameToppingAPizza fr = new JFrameToppingAPizza(pizza);
        fr.setVisible(true);
    }//GEN-LAST:event_jButtonAddToppingActionPerformed

    private void jButtonSalirPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirPizzaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirPizzaActionPerformed

    private void jButtonEliminarBebida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarBebida1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonEliminarBebida1ActionPerformed

    private void jButtonEliminarOtros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarOtros1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonEliminarOtros1ActionPerformed

    private void jButtonElimCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimCajasActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTabbleCajas.getModel();
        String nombre = String.valueOf(model.getValueAt(JTabbleCajas.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este producto?", "Eliminar Producto", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            model.removeRow(JTabbleCajas.getSelectedRow());

            ProgramaPrincipal.datos.getCajas().eliminar(new Caja(nombre));
            ProgramaPrincipal.datos.guardarCajas(ProgramaPrincipal.pathCajas);
        }
    }//GEN-LAST:event_jButtonElimCajasActionPerformed

    private void jButtonElimTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimTopActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableToppings.getModel();
        String nombre = String.valueOf(model.getValueAt(jTableToppings.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este producto?", "Eliminar Producto", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            model.removeRow(jTableToppings.getSelectedRow());
            ProgramaPrincipal.datos.getToppings().eliminar(new Topping(nombre));
            ProgramaPrincipal.datos.guardarToppings(ProgramaPrincipal.pathT);
        }
    }//GEN-LAST:event_jButtonElimTopActionPerformed

    private void jButtonElimCajas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimCajas1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonElimCajas1ActionPerformed

    private void jButtonElimTop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimTop1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonElimTop1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTablePizzas.getModel();
        modelo.setRowCount(0);
        int cantidad = ProgramaPrincipal.datos.getPizzas().largo();
        Lista pizzas = ProgramaPrincipal.datos.getPizzas();
        Pizza pizza;
        String tam;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                pizza = (Pizza) pizzas.obtener(i);
                tam = String.valueOf(jComboBox1.getSelectedItem()).toLowerCase();
                if (pizza.getNombre().toLowerCase().contains(tam)) {
                    modelo.addRow(new Object[]{pizza.getNombre()});
                }
            }
        }

        //llenarTablaPizzas2();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonEditarPizza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarPizza1ActionPerformed
        String combo = String.valueOf(jTableCombos.getValueAt(jTableCombos.getSelectedRow(), 0));
        FrEditarCombo fr = new FrEditarCombo(combo);
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEditarPizza1ActionPerformed

    private void jButtonEliminarPizza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPizza1ActionPerformed
        String combo = String.valueOf(jTableCombos.getValueAt(jTableCombos.getSelectedRow(), 0));
        int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este combo?", "Eliminar Combo", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        DefaultTableModel modelo = (DefaultTableModel) jTableCombos.getModel();
        if (opcion == JOptionPane.YES_OPTION) {
            modelo.removeRow(jTableCombos.getSelectedRow());
            ProgramaPrincipal.datos.removerProducto(new Combo(combo));
            ProgramaPrincipal.datos.guardarCombos(ProgramaPrincipal.pathCombos);
        }
    }//GEN-LAST:event_jButtonEliminarPizza1ActionPerformed

    private void jButtonSalirPizza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirPizza1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirPizza1ActionPerformed

    private void jButtonAddTopping1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTopping1ActionPerformed
        String nombre = String.valueOf(jTableCombos.getValueAt(jTableCombos.getSelectedRow(), 0));
        Combo combo = ProgramaPrincipal.datos.obtenerCombo(nombre);
        FrAgregarCombo fr = new FrAgregarCombo(combo);
        fr.setVisible(true);
    }//GEN-LAST:event_jButtonAddTopping1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JTable JTabbleCajas;
    private javax.swing.JButton jButtonAddTopping;
    private javax.swing.JButton jButtonAddTopping1;
    private javax.swing.JButton jButtonEditarPizza;
    private javax.swing.JButton jButtonEditarPizza1;
    private javax.swing.JButton jButtonElimCajas;
    private javax.swing.JButton jButtonElimCajas1;
    private javax.swing.JButton jButtonElimTop;
    private javax.swing.JButton jButtonElimTop1;
    private javax.swing.JButton jButtonEliminarBebida;
    private javax.swing.JButton jButtonEliminarBebida1;
    private javax.swing.JButton jButtonEliminarOtros;
    private javax.swing.JButton jButtonEliminarOtros1;
    private javax.swing.JButton jButtonEliminarPizza;
    private javax.swing.JButton jButtonEliminarPizza1;
    private javax.swing.JButton jButtonGuardarBebidas;
    private javax.swing.JButton jButtonGuardarOtros;
    private javax.swing.JButton jButtonSalirPizza;
    private javax.swing.JButton jButtonSalirPizza1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableBebidas;
    private javax.swing.JTable jTableCombos;
    private javax.swing.JTable jTableOtros;
    private javax.swing.JTable jTablePizzas;
    private javax.swing.JTable jTableToppings;
    // End of variables declaration//GEN-END:variables
}
