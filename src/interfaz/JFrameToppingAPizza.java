/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import main.ProgramaPrincipal;
import datos.Pizza;
import datos.Topping;
import java.awt.Font;
import negocio.Lista;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Nertrox
 */
public class JFrameToppingAPizza extends javax.swing.JFrame {

    /**
     * Creates new form JFrameToppings
     */
    String pizza;

    public JFrameToppingAPizza(String nombre) {
        initComponents();
        this.pizza = nombre;
        jLabelPizza.setText(pizza);
        llenarTablaToppings();
        llenarTablaEnPizza();
        formatearNumeros();
        setLocationRelativeTo(null);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableToppings = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEnPizza = new javax.swing.JTable();
        jButtonAnadir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabelPizza = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 107, 70), 10, true));

        jTableToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableToppings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad Necesaria (gramos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableToppings.getTableHeader().setResizingAllowed(false);
        jTableToppings.getTableHeader().setReorderingAllowed(false);
        jTableToppings.setRowHeight(40);
        jTableToppings.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableToppings);
        if (jTableToppings.getColumnModel().getColumnCount() > 0) {
            jTableToppings.getColumnModel().getColumn(0).setResizable(false);
            jTableToppings.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableEnPizza.setBackground(new java.awt.Color(240, 240, 240));
        jTableEnPizza.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTableEnPizza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad Necesaria (gramos)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEnPizza.getTableHeader().setResizingAllowed(false);
        jTableEnPizza.getTableHeader().setReorderingAllowed(false);
        jTableEnPizza.setInheritsPopupMenu(true);
        jTableEnPizza.setRowHeight(40);
        jTableEnPizza.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableEnPizza);
        if (jTableEnPizza.getColumnModel().getColumnCount() > 0) {
            jTableEnPizza.getColumnModel().getColumn(0).setResizable(false);
            jTableEnPizza.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonAnadir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAnadir.setText("Agregar");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabelPizza.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelPizza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPizza.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregados a la Pizza");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("En Inventario");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelPizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String desformatear(String value){

        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i<formateado.length;i++) 
            desformateado+=formateado[i];
        
        return desformateado;
    }

    private void formatearNumeros() {

        String value = "";
	String numero;
        for (int i = 0; i < jTableEnPizza.getRowCount(); i++) {
            numero = String.valueOf(jTableEnPizza.getValueAt(i, 1));
            value = String.format("%,d", Integer.valueOf(numero));
            jTableEnPizza.setValueAt(value, i, 1);
        }
        
    }

    
    private void llenarTablaEnPizza() {
        jTableEnPizza.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        DefaultTableModel model = (DefaultTableModel) jTableEnPizza.getModel();
        Lista toppings = ProgramaPrincipal.datos.obtenerPizza(pizza).getToppings();
        if (toppings.largo() > 0) {
            for (int i = 0; i < toppings.largo(); i++) {
                model.addRow(new Object[]{((Topping) toppings.obtener(i)).getNombre(), ((Topping) toppings.obtener(i)).getCantidadNecesaria()});
            }
        }
    }

    
    private void llenarTablaToppings() {
        jTableToppings.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
        DefaultTableModel model = (DefaultTableModel) jTableToppings.getModel();
        Lista toppings = ProgramaPrincipal.datos.getToppings();
        if (toppings.largo() > 0) {
            for (int i = 0; i < toppings.largo(); i++) {
                model.addRow(new Object[]{((Topping) toppings.obtener(i)).getNombre()});
            }
        }
        
        for (int i = 0; i < jTableToppings.getColumnCount(); i++) {
            TableColumn col = jTableToppings.getColumnModel().getColumn(i);
            col.setCellEditor(new MyTableCellEditor());
            col.setCellRenderer(new MyTableCellRenderer());
        }
    }
    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed

        String nombre = String.valueOf(jTableToppings.getValueAt(jTableToppings.getSelectedRow(), 0));
        String cantidad = desformatear(String.valueOf(jTableToppings.getValueAt(jTableToppings.getSelectedRow(), 1)));

        try {
            int cant = Integer.parseInt(cantidad);
            cantidad = String.format("%,d", Integer.valueOf(cant));
            DefaultTableModel model = (DefaultTableModel) jTableEnPizza.getModel();

            //Revisa si ya se ingreso el topping
            int c = model.getRowCount();
            boolean existe = false;
            for (int i = 0; i < c; i++) {
                if (nombre.equals(String.valueOf(model.getValueAt(i, 0)))) {
                    existe = true;
                }
            }
            if (!existe) {
                model.addRow(new String[]{nombre, cantidad});
            } else {
                JOptionPane.showMessageDialog(this, "Ya se ha seleccionado ese topping! Si desea modificar la cantidad eliminelo y agrege de nuevo!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad!");
        }

    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableEnPizza.getModel();
        model.removeRow(jTableEnPizza.getSelectedRow());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filas = jTableEnPizza.getRowCount();
        String top;
        int cantidad;
        DefaultTableModel model = (DefaultTableModel) jTableEnPizza.getModel();
        Pizza producto = ProgramaPrincipal.datos.obtenerPizza(pizza);
        Topping topping;

        if (filas > 0) {
            try {

                for (int i = 0; i < filas; i++) {
                    top = String.valueOf(jTableEnPizza.getValueAt(i, 0));
                    cantidad = Integer.parseInt(desformatear(String.valueOf(jTableEnPizza.getValueAt(i, 1))));
                    topping = ProgramaPrincipal.datos.obtenerTopping(top);
                    //topping = (Topping) Main.datos.getToppings().consultar(new Topping(top));
                    producto.agregarTopping(topping, cantidad);
                    //(Pizza) Main.datos.getPizzas().consultar(new Pizza(pizza))).agregarTopping(topping, cantidad);

                }

                ProgramaPrincipal.datos.guardarPizzas(ProgramaPrincipal.pathP); //Guarda la pizza en el archivo
                JOptionPane.showMessageDialog(this, "Toppings agregados correctamente!");
                this.dispose();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ha ingresado una cantidad incorrecta!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe agregar toppings a la pizza");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPizza;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEnPizza;
    private javax.swing.JTable jTableToppings;
    // End of variables declaration//GEN-END:variables
}