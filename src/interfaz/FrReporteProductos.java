/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import datos.ComparadorIngresos;
import datos.ComparadorVentas;
import datos.Producto;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import main.ProgramaPrincipal;

/**
 *
 * @author Nertrox
 */
public class FrReporteProductos extends javax.swing.JFrame {

    /**
     * Creates new form FrReporteProductos
     */
    private DefaultTableModel modelo;

    public FrReporteProductos() {
        initComponents();
        setLocationRelativeTo(null);
        jTable1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        modelo = (DefaultTableModel) jTable1.getModel();
        ArrayList pizzas = ProgramaPrincipal.datos.getPizzas().copiar();

        if (jRadioButtonVentas.isSelected()) {
            Collections.sort(pizzas, new ComparadorVentas());
        }

        if (jRadioButtonIngresos.isSelected()) {
            Collections.sort(pizzas, new ComparadorIngresos());
        }

        llenarTabla(pizzas);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToggleButtonBebidas = new javax.swing.JToggleButton();
        jToggleButtonPizzas = new javax.swing.JToggleButton();
        jToggleButtonOtros = new javax.swing.JToggleButton();
        jToggleButtonCombos = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonVentas = new javax.swing.JRadioButton();
        jRadioButtonIngresos = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 107, 70), 10, true));

        jPanel2.setBackground(new java.awt.Color(189, 195, 199));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(jToggleButtonBebidas);
        jToggleButtonBebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jToggleButtonBebidas.setText("Bebidas");
        jToggleButtonBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonBebidasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButtonPizzas);
        jToggleButtonPizzas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jToggleButtonPizzas.setText("Pizzas");
        jToggleButtonPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPizzasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButtonOtros);
        jToggleButtonOtros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jToggleButtonOtros.setText("Otros");
        jToggleButtonOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonOtrosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButtonCombos);
        jToggleButtonCombos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jToggleButtonCombos.setSelected(true);
        jToggleButtonCombos.setText("Combos");
        jToggleButtonCombos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCombosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButtonOtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jToggleButtonPizzas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonCombos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jToggleButtonPizzas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonCombos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButtonBebidas)
                .addGap(26, 26, 26)
                .addComponent(jToggleButtonOtros)
                .addGap(32, 32, 32))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad Ventas", "Total Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(189, 195, 199));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jRadioButtonVentas.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup2.add(jRadioButtonVentas);
        jRadioButtonVentas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButtonVentas.setSelected(true);
        jRadioButtonVentas.setText("Por Ventas");
        jRadioButtonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVentasActionPerformed(evt);
            }
        });

        jRadioButtonIngresos.setBackground(new java.awt.Color(189, 195, 199));
        buttonGroup2.add(jRadioButtonIngresos);
        jRadioButtonIngresos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButtonIngresos.setText("Por Ingresos");
        jRadioButtonIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIngresosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jRadioButtonVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jRadioButtonIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(533, 533, 533)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(15, 15, 15))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPizzasActionPerformed
        limpiarTabla();
        ArrayList pizzas = ProgramaPrincipal.datos.getPizzas().copiar();

        if (jRadioButtonVentas.isSelected()) {
            Collections.sort(pizzas, new ComparadorVentas());
        }

        if (jRadioButtonIngresos.isSelected()) {
            Collections.sort(pizzas, new ComparadorIngresos());
        }

        llenarTabla(pizzas);
    }//GEN-LAST:event_jToggleButtonPizzasActionPerformed

    private void jToggleButtonBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonBebidasActionPerformed
        limpiarTabla();
        ArrayList bebidas = ProgramaPrincipal.datos.getBebidas().copiar();

        if (jRadioButtonVentas.isSelected()) {
            Collections.sort(bebidas, new ComparadorVentas());
        }

        if (jRadioButtonIngresos.isSelected()) {
            Collections.sort(bebidas, new ComparadorIngresos());
        }

        llenarTabla(bebidas);
    }//GEN-LAST:event_jToggleButtonBebidasActionPerformed

    private void jToggleButtonOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonOtrosActionPerformed
        limpiarTabla();
        ArrayList otros = ProgramaPrincipal.datos.getOtros().copiar();

        if (jRadioButtonVentas.isSelected()) {
            Collections.sort(otros, new ComparadorVentas());
        }

        if (jRadioButtonIngresos.isSelected()) {
            Collections.sort(otros, new ComparadorIngresos());
        }

        llenarTabla(otros);
    }//GEN-LAST:event_jToggleButtonOtrosActionPerformed

    private void jRadioButtonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVentasActionPerformed
        limpiarTabla();

        if (jToggleButtonPizzas.isSelected()) {

            ArrayList pizzas = ProgramaPrincipal.datos.getPizzas().copiar();
            Collections.sort(pizzas, new ComparadorVentas());
            llenarTabla(pizzas);
        }
        if (jToggleButtonOtros.isSelected()) {

            ArrayList otros = ProgramaPrincipal.datos.getOtros().copiar();
            Collections.sort(otros, new ComparadorVentas());
            llenarTabla(otros);
        }

        if (jToggleButtonBebidas.isSelected()) {

            ArrayList bebidas = ProgramaPrincipal.datos.getBebidas().copiar();
            Collections.sort(bebidas, new ComparadorVentas());
            llenarTabla(bebidas);
        }
        
        if (jToggleButtonCombos.isSelected()) {

            ArrayList combos = ProgramaPrincipal.datos.getCombos().copiar();
            Collections.sort(combos, new ComparadorIngresos());
            llenarTabla(combos);
        }
    }//GEN-LAST:event_jRadioButtonVentasActionPerformed

    private void jRadioButtonIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIngresosActionPerformed
        limpiarTabla();

        if (jToggleButtonPizzas.isSelected()) {

            ArrayList pizzas = ProgramaPrincipal.datos.getPizzas().copiar();
            Collections.sort(pizzas, new ComparadorIngresos());
            llenarTabla(pizzas);
        }
        if (jToggleButtonOtros.isSelected()) {

            ArrayList otros = ProgramaPrincipal.datos.getOtros().copiar();
            Collections.sort(otros, new ComparadorIngresos());
            llenarTabla(otros);
        }

        if (jToggleButtonBebidas.isSelected()) {

            ArrayList bebidas = ProgramaPrincipal.datos.getBebidas().copiar();
            Collections.sort(bebidas, new ComparadorIngresos());
            llenarTabla(bebidas);
        }
        
        if (jToggleButtonCombos.isSelected()) {

            ArrayList combos = ProgramaPrincipal.datos.getCombos().copiar();
            Collections.sort(combos, new ComparadorIngresos());
            llenarTabla(combos);
        }
    }//GEN-LAST:event_jRadioButtonIngresosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButtonCombosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCombosActionPerformed
        limpiarTabla();
        ArrayList combos = ProgramaPrincipal.datos.getCombos().copiar();

        if (jRadioButtonVentas.isSelected()) {
            Collections.sort(combos, new ComparadorVentas());
        }

        if (jRadioButtonIngresos.isSelected()) {
            Collections.sort(combos, new ComparadorIngresos());
        }

        llenarTabla(combos);
    }//GEN-LAST:event_jToggleButtonCombosActionPerformed

    private void llenarTabla(ArrayList lista) {
        Producto p = new Producto();

        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                p = (Producto) lista.get(i);
                modelo.addRow(new Object[]{p.getNombre(), p.getCantOrdenadaTotal(), p.getIngresosGenerados()});
            }

        }
        
        formatearNumeros();
    }
    
    private void formatearNumeros() {

        String value = "₡";
	String numero;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            numero = String.valueOf(jTable1.getValueAt(i, 2));
            value += String.format("%,d", Integer.valueOf(numero));
            jTable1.setValueAt(value, i, 2);
            value = "₡";
        }
    }

    private void limpiarTabla() {
        int cantidad = jTable1.getRowCount();
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                modelo.removeRow(0);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonIngresos;
    private javax.swing.JRadioButton jRadioButtonVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButtonBebidas;
    private javax.swing.JToggleButton jToggleButtonCombos;
    private javax.swing.JToggleButton jToggleButtonOtros;
    private javax.swing.JToggleButton jToggleButtonPizzas;
    // End of variables declaration//GEN-END:variables
}
