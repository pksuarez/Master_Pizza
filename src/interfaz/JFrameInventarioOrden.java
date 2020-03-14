package interfaz;

import main.ProgramaPrincipal;
import datos.Bebida;
import datos.Categoria;
import datos.Combo;
import datos.Pizza;
import datos.Producto;
import java.awt.Font;
import negocio.Lista;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class JFrameInventarioOrden extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private final FrOrdenar orden;

    public JFrameInventarioOrden(FrOrdenar fr) {

        initComponents();
        setLocationRelativeTo(null);
        llenarBebidas();
        llenarTablaPizzas();
        llenarTablaOtros();
        llenarTablaCombos();
        formatearNumeros();
        orden = fr;

    }

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

    private void formatearNumeros() {

        String value = "₡";
        String value2 = "";
        String numero;
        String numero2;
        for (int i = 0; i < jTableBebidas.getRowCount(); i++) {
            numero = String.valueOf(jTableBebidas.getValueAt(i, 4));
            value += String.format("%,d", Integer.valueOf(numero));
            numero2 = String.valueOf(jTableBebidas.getValueAt(i, 2));
            value2 = String.format("%,d", Integer.valueOf(numero2));
            jTableBebidas.setValueAt(value, i, 4);
            jTableBebidas.setValueAt(value2, i, 2);
            value = "₡";
            value2 = "";
        }

        for (int i = 0; i < jTablePizzas.getRowCount(); i++) {
            numero = String.valueOf(jTablePizzas.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTablePizzas.setValueAt(value, i, 2);
            value = "₡";
        }

        for (int i = 0; i < jTableOtros.getRowCount(); i++) {
            numero = String.valueOf(jTableOtros.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTableOtros.setValueAt(value, i, 2);
            value = "₡";
        }

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

    public void llenarTablaOtros() {
        jTableOtros.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) jTableOtros.getModel();
        int cantidad = ProgramaPrincipal.datos.getOtros().largo();
        Lista otros = ProgramaPrincipal.datos.getOtros();
        Producto producto;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                producto = (Producto) otros.obtener(i);
                model.addRow(new Object[]{producto.getNombre(), producto.getDescripcion(), producto.getPrecio()});
            }
        }

    }

    public void llenarTablaCombos() {
        jTableOtros.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) jTableCombos.getModel();
        int cantidad = ProgramaPrincipal.datos.getCombos().largo();
        Lista otros = ProgramaPrincipal.datos.getCombos();
        Combo combo;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                combo = (Combo) otros.obtener(i);
                model.addRow(new Object[]{combo.getNombre(), combo.getDescripcion(), combo.getPrecio()});
            }
        }

    }

    private void llenarTablaPizzas() {
        jTablePizzas.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        modelo = (DefaultTableModel) jTablePizzas.getModel();
        int cantidad = ProgramaPrincipal.datos.getPizzas().largo();
        Lista pizzas = ProgramaPrincipal.datos.getPizzas();
        Pizza pizza;
        String tam;
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                pizza = (Pizza) pizzas.obtener(i);
                tam = String.valueOf(jComboBox1.getSelectedItem()).toLowerCase();
                if (pizza.getNombre().toLowerCase().contains(tam)) {
                    modelo.addRow(new Object[]{pizza.getNombre(), pizza.getDescripcion(), pizza.getPrecio()});
                }
            }
        }
    }

    private void llenarBebidas() {

        jTableBebidas.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        int cant = ProgramaPrincipal.datos.getBebidas().largo();

        if (cant > 0) {
            DefaultTableModel tablaBebidas = (DefaultTableModel) jTableBebidas.getModel();
            Object fila[] = new Object[5];
            Bebida bebida;
            for (int i = 0; i < cant; i++) {
                bebida = (Bebida) ProgramaPrincipal.datos.getBebidas().obtener(i);
                fila[0] = bebida.getNombre();
                fila[1] = bebida.getMarca();
                fila[2] = bebida.getTamano();
                fila[3] = bebida.getSabor();
                fila[4] = bebida.getPrecio();
                tablaBebidas.addRow(fila);

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePizzas = new javax.swing.JTable();
        jButtonVerToppings = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinFieldPizza = new com.toedter.components.JSpinField();
        jButtonAddPizza = new javax.swing.JButton();
        jButtonVerToppings1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBebidas = new javax.swing.JTable();
        jSpinFieldBebidas = new com.toedter.components.JSpinField();
        jLabel2 = new javax.swing.JLabel();
        jButtonAddBebida = new javax.swing.JButton();
        jButtonAddBebida1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableOtros = new javax.swing.JTable();
        jSpinFieldOtros = new com.toedter.components.JSpinField();
        jButtonAddOtros = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonAddOtros1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSpinFieldCombos = new com.toedter.components.JSpinField();
        jButtonAddOtros2 = new javax.swing.JButton();
        jButtonAddOtros3 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableCombos = new javax.swing.JTable();
        jButtonAddOtros5 = new javax.swing.JButton();

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

        jTablePizzas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTablePizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        jButtonVerToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonVerToppings.setText("Ver Toppings");
        jButtonVerToppings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerToppingsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cantidad");

        jSpinFieldPizza.setMaximumSize(new java.awt.Dimension(1, 2147483647));
        jSpinFieldPizza.setMinimum(1);
        jSpinFieldPizza.setValue(1);

        jButtonAddPizza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddPizza.setText("Agregar");
        jButtonAddPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPizzaActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonVerToppings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinFieldPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addComponent(jButtonVerToppings1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddPizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinFieldPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButtonAddPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtonVerToppings, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButtonVerToppings1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        JTabbedPane.addTab("Pizzas", jPanel2);

        jPanel3.setBackground(new java.awt.Color(149, 165, 166));

        jTableBebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Tamaño (mL)", "Sabor", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTableBebidas.getColumnModel().getColumn(1).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(2).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(3).setResizable(false);
            jTableBebidas.getColumnModel().getColumn(4).setResizable(false);
        }

        jSpinFieldBebidas.setFocusable(false);
        jSpinFieldBebidas.setMaximumSize(new java.awt.Dimension(1, 2147483647));
        jSpinFieldBebidas.setMinimum(1);
        jSpinFieldBebidas.setValue(1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Cantidad");

        jButtonAddBebida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddBebida.setText("Agregar");
        jButtonAddBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBebidaActionPerformed(evt);
            }
        });

        jButtonAddBebida1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddBebida1.setText("Salir");
        jButtonAddBebida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddBebida1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinFieldBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(jButtonAddBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddBebida1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddBebida1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinFieldBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        JTabbedPane.addTab("Bebidas", jPanel3);

        jPanel5.setBackground(new java.awt.Color(149, 165, 166));

        jTableOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableOtros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        jSpinFieldOtros.setMaximumSize(new java.awt.Dimension(1, 2147483647));
        jSpinFieldOtros.setMinimum(1);
        jSpinFieldOtros.setValue(1);

        jButtonAddOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddOtros.setText("Agregar");
        jButtonAddOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOtrosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Cantidad");

        jButtonAddOtros1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddOtros1.setText("Salir");
        jButtonAddOtros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOtros1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddOtros1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddOtros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jSpinFieldOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinFieldOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addComponent(jButtonAddOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonAddOtros1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("Otros", jPanel5);

        jPanel4.setBackground(new java.awt.Color(149, 165, 166));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Cantidad");

        jSpinFieldCombos.setMaximumSize(new java.awt.Dimension(1, 2147483647));
        jSpinFieldCombos.setMinimum(1);
        jSpinFieldCombos.setValue(1);

        jButtonAddOtros2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddOtros2.setText("Agregar");
        jButtonAddOtros2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOtros2ActionPerformed(evt);
            }
        });

        jButtonAddOtros3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddOtros3.setText("Salir");
        jButtonAddOtros3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOtros3ActionPerformed(evt);
            }
        });

        jTableCombos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCombos.setFocusable(false);
        jTableCombos.setRowHeight(40);
        jTableCombos.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTableCombos);
        if (jTableCombos.getColumnModel().getColumnCount() > 0) {
            jTableCombos.getColumnModel().getColumn(0).setResizable(false);
            jTableCombos.getColumnModel().getColumn(1).setResizable(false);
            jTableCombos.getColumnModel().getColumn(2).setResizable(false);
        }

        jButtonAddOtros5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAddOtros5.setText("Ver Productos");
        jButtonAddOtros5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOtros5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(jSpinFieldCombos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddOtros2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddOtros5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddOtros3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinFieldCombos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addComponent(jButtonAddOtros2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButtonAddOtros5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddOtros3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(60, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        JTabbedPane.addTab("Combos", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerToppingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerToppingsActionPerformed

        DefaultTableModel modelpizza = (DefaultTableModel) jTablePizzas.getModel();

        if (jTablePizzas.getRowCount() > 0) {
            String nombre = String.valueOf(modelpizza.getValueAt(jTablePizzas.getSelectedRow(), 0));
            FrVerToppingsPizza frTop = new FrVerToppingsPizza(nombre);
            frTop.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay pizzas para las cuales mostrar toppings!");
        }

    }//GEN-LAST:event_jButtonVerToppingsActionPerformed

    private void jButtonAddPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPizzaActionPerformed
        modelo = (DefaultTableModel) jTablePizzas.getModel();
        int row = jTablePizzas.getSelectedRow();
        int cantidad = jSpinFieldPizza.getValue();
        String nombre = String.valueOf(modelo.getValueAt(row, 0));
        int precio = Integer.parseInt(quitarColon(String.valueOf(modelo.getValueAt(row, 2))));
        DefaultTableModel model = (DefaultTableModel) orden.getjTableOrden().getModel();
        int filas = model.getRowCount();
        boolean encontrado = false;
        if (filas > 0) {
            for (int i = 0; i < orden.getjTableOrden().getRowCount(); i++) { //revisa si ya ese producto fue agregado     
                String nombreEnTablaOrden = String.valueOf(model.getValueAt(i, 0));
                if (nombreEnTablaOrden.equals(nombre)) {
                    int cantEnTabla = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)));
                    int precioEnTabla = Integer.parseInt(quitarColon(String.valueOf(model.getValueAt(i, 2))));
                    model.setValueAt(cantEnTabla + cantidad, i, 1);

                    int total = precioEnTabla + (cantidad * precio);
                    String tot = "₡" + String.format("%,d", total);
                    model.setValueAt(tot, i, 2);

                    encontrado = true;
                }

            }
            if (!encontrado) {
                precio *= cantidad;
                String cant = String.format("%,d", cantidad);
                String pre = "₡" + String.format("%,d", precio);

                orden.agregarProducto(nombre, cant, pre, Categoria.PIZZA);
            }
        } else {
            precio *= cantidad;
            String cant = String.format("%,d", cantidad);
            String pre = "₡" + String.format("%,d", precio);

            orden.agregarProducto(nombre, cant, pre, Categoria.PIZZA);
        }


    }//GEN-LAST:event_jButtonAddPizzaActionPerformed

    private void jButtonAddBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddBebidaActionPerformed
        modelo = (DefaultTableModel) jTableBebidas.getModel();
        int cantidad = jSpinFieldBebidas.getValue();
        int row = jTableBebidas.getSelectedRow();
        String nombre = String.valueOf(modelo.getValueAt(row, 0));
        int precio = Integer.parseInt(quitarColon(String.valueOf(modelo.getValueAt(row, 4))));
        DefaultTableModel model = (DefaultTableModel) orden.getjTableOrden().getModel();
        int filas = model.getRowCount();
        boolean encontrado = false;
        if (filas > 0) {
            for (int i = 0; i < orden.getjTableOrden().getRowCount(); i++) { //revisa si ya ese producto fue agregado     
                String nombreEnTablaOrden = String.valueOf(model.getValueAt(i, 0));
                if (nombreEnTablaOrden.equals(nombre)) {
                    int cantEnTabla = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)));
                    int precioEnTabla = Integer.parseInt(quitarColon(String.valueOf(model.getValueAt(i, 2))));
                    model.setValueAt(cantEnTabla + cantidad, i, 1);

                    int total = precioEnTabla + (cantidad * precio);
                    String tot = "₡" + String.format("%,d", total);
                    model.setValueAt(tot, i, 2);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                precio *= cantidad;
                String cant = String.format("%,d", cantidad);
                String pre = "₡" + String.format("%,d", precio);

                orden.agregarProducto(nombre, cant, pre, Categoria.BEBIDA);
            }
        } else {
            precio *= cantidad;
            String cant = String.format("%,d", cantidad);
            String pre = "₡" + String.format("%,d", precio);

            orden.agregarProducto(nombre, cant, pre, Categoria.BEBIDA);
        }
    }//GEN-LAST:event_jButtonAddBebidaActionPerformed

    private void jButtonAddOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOtrosActionPerformed
        modelo = (DefaultTableModel) jTableOtros.getModel();
        int cantidad = jSpinFieldOtros.getValue();
        int row = jTableOtros.getSelectedRow();
        String nombre = String.valueOf(modelo.getValueAt(row, 0));
        int precio = Integer.parseInt(quitarColon(String.valueOf(modelo.getValueAt(row, 2))));
        DefaultTableModel model = (DefaultTableModel) orden.getjTableOrden().getModel();
        int filas = model.getRowCount();
        boolean encontrado = false;
        if (filas > 0) {
            for (int i = 0; i < orden.getjTableOrden().getRowCount(); i++) { //revisa si ya ese producto fue agregado     
                String nombreEnTablaOrden = String.valueOf(model.getValueAt(i, 0));
                if (nombreEnTablaOrden.equals(nombre)) {
                    int cantEnTabla = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)));
                    int precioEnTabla = Integer.parseInt(quitarColon(String.valueOf(model.getValueAt(i, 2))));
                    model.setValueAt(cantEnTabla + cantidad, i, 1);

                    int total = precioEnTabla + (cantidad * precio);
                    String tot = "₡" + String.format("%,d", total);
                    model.setValueAt(tot, i, 2);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                precio *= cantidad;
                String cant = String.format("%,d", cantidad);
                String pre = "₡" + String.format("%,d", precio);

                orden.agregarProducto(nombre, cant, pre, Categoria.OTRO);
            }
        } else {
            precio *= cantidad;
            String cant = String.format("%,d", cantidad);
            String pre = "₡" + String.format("%,d", precio);

            orden.agregarProducto(nombre, cant, pre, Categoria.OTRO);
        }
    }//GEN-LAST:event_jButtonAddOtrosActionPerformed

    private void jButtonVerToppings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerToppings1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVerToppings1ActionPerformed

    private void jButtonAddOtros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOtros1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAddOtros1ActionPerformed

    private void jButtonAddBebida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddBebida1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAddBebida1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        modelo = (DefaultTableModel) jTablePizzas.getModel();
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
                    modelo.addRow(new Object[]{pizza.getNombre(), pizza.getDescripcion(), pizza.getPrecio()});
                }
            }
        }

        formatearPizzas();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonAddOtros2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOtros2ActionPerformed
        modelo = (DefaultTableModel) jTableCombos.getModel();
        int cantidad = jSpinFieldCombos.getValue();
        int row = jTableCombos.getSelectedRow();
        String nombre = String.valueOf(modelo.getValueAt(row, 0));
        int precio = Integer.parseInt(quitarColon(String.valueOf(modelo.getValueAt(row, 2))));
        DefaultTableModel model = (DefaultTableModel) orden.getjTableOrden().getModel();
        int filas = model.getRowCount();
        boolean encontrado = false;
        if (filas > 0) {
            for (int i = 0; i < orden.getjTableOrden().getRowCount(); i++) { //revisa si ya ese producto fue agregado     
                String nombreEnTablaOrden = String.valueOf(model.getValueAt(i, 0));
                if (nombreEnTablaOrden.equals(nombre)) {
                    int cantEnTabla = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)));
                    int precioEnTabla = Integer.parseInt(quitarColon(String.valueOf(model.getValueAt(i, 2))));
                    model.setValueAt(cantEnTabla + cantidad, i, 1);

                    int total = precioEnTabla + (cantidad * precio);
                    String tot = "₡" + String.format("%,d", total);
                    model.setValueAt(tot, i, 2);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                precio *= cantidad;
                String cant = String.format("%,d", cantidad);
                String pre = "₡" + String.format("%,d", precio);

                orden.agregarProducto(nombre, cant, pre, Categoria.COMBO);
            }
        } else {
            precio *= cantidad;
            String cant = String.format("%,d", cantidad);
            String pre = "₡" + String.format("%,d", precio);

            orden.agregarProducto(nombre, cant, pre, Categoria.COMBO);
        }
    }//GEN-LAST:event_jButtonAddOtros2ActionPerformed

    private void jButtonAddOtros3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOtros3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAddOtros3ActionPerformed

    private void jButtonAddOtros5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOtros5ActionPerformed
        String orden = String.valueOf(jTableCombos.getValueAt(jTableCombos.getSelectedRow(), 0));
        FrVerProductosCombo fr = new FrVerProductosCombo(orden);
        fr.setVisible(true);
    }//GEN-LAST:event_jButtonAddOtros5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JButton jButtonAddBebida;
    private javax.swing.JButton jButtonAddBebida1;
    private javax.swing.JButton jButtonAddOtros;
    private javax.swing.JButton jButtonAddOtros1;
    private javax.swing.JButton jButtonAddOtros2;
    private javax.swing.JButton jButtonAddOtros3;
    private javax.swing.JButton jButtonAddOtros5;
    private javax.swing.JButton jButtonAddPizza;
    private javax.swing.JButton jButtonVerToppings;
    private javax.swing.JButton jButtonVerToppings1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private com.toedter.components.JSpinField jSpinFieldBebidas;
    private com.toedter.components.JSpinField jSpinFieldCombos;
    private com.toedter.components.JSpinField jSpinFieldOtros;
    private com.toedter.components.JSpinField jSpinFieldPizza;
    private javax.swing.JTable jTableBebidas;
    private javax.swing.JTable jTableCombos;
    private javax.swing.JTable jTableOtros;
    private javax.swing.JTable jTablePizzas;
    // End of variables declaration//GEN-END:variables

}
