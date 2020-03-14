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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nertrox
 */
public class JFrameInventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public JFrameInventario() {

        initComponents();
        llenarBebidas();
        llenarToppings();
        llenarTablaPizzas();
        llenarTablaOtros();
        llenarTablaCajas();
        llenarTablaCombos();
        //formatearNumeros();
        setLocationRelativeTo(null);
    }

    private void formatearPizzas() {
        String value = "₡";
        String numero;
        for (int i = 0; i < jTablePizzas.getRowCount(); i++) {
            numero = String.valueOf(jTablePizzas.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTablePizzas.setValueAt(value, i, 2);
            value = "₡";
        }
    }

    private void formatearNumeros() {

        String value = "₡";
        String numero;
        String numero2;
        String value2;
        for (int i = 0; i < jTablePizzas.getRowCount(); i++) {
            numero = String.valueOf(jTablePizzas.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTablePizzas.setValueAt(value, i, 2);
            value = "₡";
        }

        for (int i = 0; i < jTableToppings.getRowCount(); i++) {
            numero = String.valueOf(jTableToppings.getValueAt(i, 1));
            value2 = String.format("%,d", Integer.valueOf(numero));
            jTableToppings.setValueAt(value2, i, 1);
        }

        for (int i = 0; i < jTableOtros.getRowCount(); i++) {
            numero = String.valueOf(jTableOtros.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTableOtros.setValueAt(value, i, 2);
            value = "₡";
        }
        
        for (int i = 0; i < jTableCombos.getRowCount(); i++) {
            numero = String.valueOf(jTableCombos.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTableOtros.setValueAt(value, i, 2);
            value = "₡";
        }

        for (int i = 0; i < jTableBebidas.getRowCount(); i++) {
            numero = String.valueOf(jTableBebidas.getValueAt(i, 4));
            numero2 = String.valueOf(jTableBebidas.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            value2 = String.format("%,d", Integer.valueOf(numero2));
            jTableBebidas.setValueAt(value, i, 4);
            jTableBebidas.setValueAt(value2, i, 2);
            value = "₡";
        }

    }

    private void llenarTablaOtros() {
        jTableOtros.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) jTableOtros.getModel();
        int cantidad = ProgramaPrincipal.datos.getOtros().largo();
        Lista otros = ProgramaPrincipal.datos.getOtros();
        Producto producto;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                producto = (Producto) otros.obtener(i);
                model.addRow(new Object[]{producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantOrdenadaTotal()});
            }
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
                model.addRow(new Object[]{combo.getNombre(), combo.getDescripcion(), combo.getPrecio(), combo.getCantOrdenadaTotal()});
            }
        }

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
                    modelo.addRow(new Object[]{pizza.getNombre(), pizza.getDescripcion(), pizza.getPrecio(), pizza.getCaja(),pizza.getCantOrdenadaTotal()});
                }
            }
        }
    }

    private void llenarBebidas() {

        jTableBebidas.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        int cant = ProgramaPrincipal.datos.getBebidas().largo();
        if (cant > 0) {
            DefaultTableModel tablaBebidas = (DefaultTableModel) jTableBebidas.getModel();
            Object fila[] = new Object[7];
            Bebida bebida;
            for (int i = 0; i < cant; i++) {
                bebida = (Bebida) ProgramaPrincipal.datos.getBebidas().obtener(i);
                fila[0] = bebida.getNombre();
                fila[1] = bebida.getMarca();
                fila[2] = bebida.getTamano();
                fila[3] = bebida.getSabor();
                fila[4] = bebida.getPrecio();
                fila[5] = bebida.getDisponibles();
                fila[6] = bebida.getCantOrdenadaTotal();
                tablaBebidas.addRow(fila);

            }
        }

    }

    private void llenarToppings() {

        int cant = ProgramaPrincipal.datos.getToppings().largo();
        jTableToppings.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        if (cant > 0) {
            DefaultTableModel tablaToppings = (DefaultTableModel) jTableToppings.getModel();
            Object fila[] = new Object[2];
            Topping topping;
            for (int i = 0; i < cant; i++) {
                topping = (Topping) ProgramaPrincipal.datos.getToppings().obtener(i);
                fila[0] = topping.getNombre();
                fila[1] = topping.getCantidadDisponible();
                tablaToppings.addRow(fila);

            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTabbedPane = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableCombos = new javax.swing.JTable();
        jButtonVerToppings2 = new javax.swing.JButton();
        jButtonVerToppings3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePizzas = new javax.swing.JTable();
        jButtonVerToppings = new javax.swing.JButton();
        jButtonVerToppings1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableToppings = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableOtros = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTabbleCajas = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBebidas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 107, 70), 10, true));

        JTabbedPane.setBackground(new java.awt.Color(149, 165, 166));
        JTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        JTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        JTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(149, 165, 166));
        jPanel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jTableCombos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Cantidad Ordenes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCombos.setFocusable(false);
        jTableCombos.setRowHeight(40);
        jTableCombos.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTableCombos);
        if (jTableCombos.getColumnModel().getColumnCount() > 0) {
            jTableCombos.getColumnModel().getColumn(0).setResizable(false);
            jTableCombos.getColumnModel().getColumn(1).setResizable(false);
            jTableCombos.getColumnModel().getColumn(2).setResizable(false);
            jTableCombos.getColumnModel().getColumn(3).setResizable(false);
        }

        jButtonVerToppings2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonVerToppings2.setText("Salir");
        jButtonVerToppings2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerToppings2ActionPerformed(evt);
            }
        });

        jButtonVerToppings3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonVerToppings3.setText("Ver Productos");
        jButtonVerToppings3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerToppings3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButtonVerToppings2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonVerToppings3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerToppings2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerToppings3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("Combos", jPanel7);

        jPanel2.setBackground(new java.awt.Color(149, 165, 166));

        jTablePizzas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTablePizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Caja", "Cantidad Ordenes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePizzas.setFocusable(false);
        jTablePizzas.setRowHeight(40);
        jTablePizzas.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTablePizzas);
        if (jTablePizzas.getColumnModel().getColumnCount() > 0) {
            jTablePizzas.getColumnModel().getColumn(0).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(1).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(2).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(3).setResizable(false);
            jTablePizzas.getColumnModel().getColumn(4).setResizable(false);
        }

        jButtonVerToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonVerToppings.setText("Ver Toppings");
        jButtonVerToppings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerToppingsActionPerformed(evt);
            }
        });

        jButtonVerToppings1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonVerToppings1.setText("Salir");
        jButtonVerToppings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerToppings1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERSONAL", "MEDIANA", "GRANDE", "FAMILIAR", "FIESTA", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jButtonVerToppings1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVerToppings, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerToppings1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerToppings, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("Pizzas", jPanel2);

        jPanel4.setBackground(new java.awt.Color(149, 165, 166));

        jTableToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableToppings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad Disponible (gramos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableToppings.getTableHeader().setReorderingAllowed(false);
        jTableToppings.getTableHeader().setResizingAllowed(false);
        jTableToppings.setRowHeight(40);
        jScrollPane2.setViewportView(jTableToppings);
        if (jTableToppings.getColumnModel().getColumnCount() > 0) {
            jTableToppings.getColumnModel().getColumn(0).setResizable(false);
            jTableToppings.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        JTabbedPane.addTab("Toppings", jPanel4);

        jPanel5.setBackground(new java.awt.Color(149, 165, 166));

        jTableOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableOtros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Cantidad Ordenes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOtros.setFocusable(false);
        jTableOtros.setRowHeight(40);
        jTableOtros.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableOtros);
        if (jTableOtros.getColumnModel().getColumnCount() > 0) {
            jTableOtros.getColumnModel().getColumn(0).setResizable(false);
            jTableOtros.getColumnModel().getColumn(1).setResizable(false);
            jTableOtros.getColumnModel().getColumn(2).setResizable(false);
            jTableOtros.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("Otros", jPanel5);

        jPanel6.setBackground(new java.awt.Color(149, 165, 166));

        JTabbleCajas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JTabbleCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad Disponible", "Tamaño (pulgadas)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            JTabbleCajas.getColumnModel().getColumn(1).setResizable(false);
            JTabbleCajas.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        JTabbedPane.addTab("Cajas", jPanel6);

        jPanel3.setBackground(new java.awt.Color(149, 165, 166));

        jTableBebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Tamaño (mL)", "Sabor", "Precio", "Disponibles", "Cantidad Ordenes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBebidas.setRowHeight(40);
        jTableBebidas.getTableHeader().setResizingAllowed(false);
        jTableBebidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableBebidas);
        if (jTableBebidas.getColumnModel().getColumnCount() > 0) {
            jTableBebidas.getColumnModel().getColumn(0).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTableBebidas.getColumnModel().getColumn(1).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(2).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableBebidas.getColumnModel().getColumn(3).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(4).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(5).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        JTabbedPane.addTab("Bebidas", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerToppingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerToppingsActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTablePizzas.getModel();
        if (jTablePizzas.getRowCount() > 0) {
            String nombre = String.valueOf(model.getValueAt(jTablePizzas.getSelectedRow(), 0));
            FrVerToppingsPizza frTop = new FrVerToppingsPizza(nombre);
            frTop.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay pizzas para las cuales mostrar toppings!");
        }
    }//GEN-LAST:event_jButtonVerToppingsActionPerformed

    private void jButtonVerToppings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerToppings1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVerToppings1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                    modelo.addRow(new Object[]{pizza.getNombre(), pizza.getDescripcion(), pizza.getPrecio(), pizza.getCaja(),pizza.getCantOrdenadaTotal()});
                }
            }
        }

        formatearPizzas();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonVerToppings2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerToppings2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVerToppings2ActionPerformed

    private void jButtonVerToppings3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerToppings3ActionPerformed
        
        String orden = String.valueOf(jTableCombos.getValueAt(jTableCombos.getSelectedRow(), 0));
        FrVerProductosCombo fr = new FrVerProductosCombo(orden);
        fr.setVisible(true);
    }//GEN-LAST:event_jButtonVerToppings3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JTable JTabbleCajas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonVerToppings;
    private javax.swing.JButton jButtonVerToppings1;
    private javax.swing.JButton jButtonVerToppings2;
    private javax.swing.JButton jButtonVerToppings3;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTableBebidas;
    private javax.swing.JTable jTableCombos;
    private javax.swing.JTable jTableOtros;
    private javax.swing.JTable jTablePizzas;
    private javax.swing.JTable jTableToppings;
    // End of variables declaration//GEN-END:variables
}
