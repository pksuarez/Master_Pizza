/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import main.ProgramaPrincipal;
import datos.Bebida;
import datos.Caja;
import datos.Topping;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nertrox
 */
public class JFrameAumentarProd extends javax.swing.JFrame {

    /**
     * Creates new form AumentarToppings
     */
    public JFrameAumentarProd() {
        initComponents();
        llenarLista();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jTabToppings = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListToppings = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldToppings = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        JTabBebias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListBebias = new javax.swing.JList<>();
        jButtonAgregarBeb = new javax.swing.JButton();
        jButtonSalirBeb = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBebidas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCajas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCajas = new javax.swing.JTextField();
        jButtonAgregarCaja = new javax.swing.JButton();
        jButtonSalirBeb1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(149, 165, 166));

        jTabbedPane.setBackground(new java.awt.Color(149, 165, 166));
        jTabbedPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 107, 70), 10, true));
        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setToolTipText("");
        jTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTabToppings.setBackground(new java.awt.Color(149, 165, 166));

        jListToppings.setBackground(new java.awt.Color(189, 195, 199));
        jListToppings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jListToppings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListToppings.setToolTipText("");
        jScrollPane1.setViewportView(jListToppings);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cantidad a agregar");

        jTextFieldToppings.setBackground(new java.awt.Color(189, 195, 199));
        jTextFieldToppings.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldToppings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldToppingsActionPerformed(evt);
            }
        });

        jButtonAgregar.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAgregar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(153, 153, 255));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jTabToppingsLayout = new javax.swing.GroupLayout(jTabToppings);
        jTabToppings.setLayout(jTabToppingsLayout);
        jTabToppingsLayout.setHorizontalGroup(
            jTabToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabToppingsLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jTabToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jTabToppingsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldToppings, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jTabToppingsLayout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        jTabToppingsLayout.setVerticalGroup(
            jTabToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabToppingsLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jTabToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldToppings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jTabToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTabToppingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jTabbedPane.addTab("Toppings", jTabToppings);

        JTabBebias.setBackground(new java.awt.Color(149, 165, 166));

        jListBebias.setBackground(new java.awt.Color(189, 195, 199));
        jListBebias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListBebias.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jListBebias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListBebias.setToolTipText("");
        jScrollPane2.setViewportView(jListBebias);

        jButtonAgregarBeb.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAgregarBeb.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAgregarBeb.setText("Agregar");
        jButtonAgregarBeb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAgregarBeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarBebActionPerformed(evt);
            }
        });

        jButtonSalirBeb.setBackground(new java.awt.Color(153, 153, 255));
        jButtonSalirBeb.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSalirBeb.setText("Salir");
        jButtonSalirBeb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSalirBeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirBebActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Cantidad a agregar");

        jTextFieldBebidas.setBackground(new java.awt.Color(189, 195, 199));
        jTextFieldBebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBebidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JTabBebiasLayout = new javax.swing.GroupLayout(JTabBebias);
        JTabBebias.setLayout(JTabBebiasLayout);
        JTabBebiasLayout.setHorizontalGroup(
            JTabBebiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JTabBebiasLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(JTabBebiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JTabBebiasLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jTextFieldBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JTabBebiasLayout.createSequentialGroup()
                        .addComponent(jButtonSalirBeb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonAgregarBeb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        JTabBebiasLayout.setVerticalGroup(
            JTabBebiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JTabBebiasLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(JTabBebiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JTabBebiasLayout.createSequentialGroup()
                        .addGroup(JTabBebiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(94, 94, 94)
                        .addGroup(JTabBebiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalirBeb, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jButtonAgregarBeb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JTabBebiasLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );

        jTabbedPane.addTab("Bebidas", JTabBebias);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setFocusable(false);
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jListCajas.setBackground(new java.awt.Color(189, 195, 199));
        jListCajas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListCajas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jListCajas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListCajas.setToolTipText("");
        jScrollPane3.setViewportView(jListCajas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Cantidad a agregar");

        jTextFieldCajas.setBackground(new java.awt.Color(189, 195, 199));
        jTextFieldCajas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCajasActionPerformed(evt);
            }
        });

        jButtonAgregarCaja.setBackground(new java.awt.Color(153, 153, 255));
        jButtonAgregarCaja.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAgregarCaja.setText("Agregar");
        jButtonAgregarCaja.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAgregarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCajaActionPerformed(evt);
            }
        });

        jButtonSalirBeb1.setBackground(new java.awt.Color(153, 153, 255));
        jButtonSalirBeb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSalirBeb1.setText("Salir");
        jButtonSalirBeb1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSalirBeb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirBeb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jTextFieldCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalirBeb1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonAgregarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalirBeb1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAgregarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Cajas", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private String desformatear(String value){

        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i<formateado.length;i++) 
            desformateado+=formateado[i];
        
        return desformateado;
    }
    
    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String item = jListToppings.getSelectedValue();
        int cantidad;
        try {
            cantidad = Integer.parseInt(desformatear(jTextFieldToppings.getText()));
            Topping topping = ProgramaPrincipal.datos.obtenerTopping(item);
            topping.aumentarCantidadDisponibe(cantidad);
            JOptionPane.showMessageDialog(this, "Agregado con exito!");
            ProgramaPrincipal.datos.guardarToppings(ProgramaPrincipal.pathT);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar numeros en la cantidad!");
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTextFieldToppingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToppingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToppingsActionPerformed

    private void jButtonAgregarBebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarBebActionPerformed
        String item = jListBebias.getSelectedValue();
        int cantidad;
        try {
            cantidad = Integer.parseInt(desformatear(jTextFieldBebidas.getText()));
            Bebida bebida = ProgramaPrincipal.datos.obtenerBebida(item);
            bebida.aumentarCantidadDisponibe(cantidad);
            JOptionPane.showMessageDialog(this, "Agregado con exito!");
            ProgramaPrincipal.datos.guardarBebidas(ProgramaPrincipal.pathB);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar numeros en la cantidad!");
        }
    }//GEN-LAST:event_jButtonAgregarBebActionPerformed

    private void jButtonSalirBebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirBebActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirBebActionPerformed

    private void jTextFieldBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBebidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBebidasActionPerformed

    private void jTextFieldCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCajasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCajasActionPerformed

    private void jButtonAgregarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCajaActionPerformed
        String item = jListCajas.getSelectedValue();
        int cantidad;
        try {
            cantidad = Integer.parseInt(desformatear(jTextFieldCajas.getText()));
            Caja caja = ProgramaPrincipal.datos.obtenerCaja(item);
            caja.aumentarCantidadDisponibe(cantidad);
            JOptionPane.showMessageDialog(this, "Agregado con exito!");
            ProgramaPrincipal.datos.guardarCajas(ProgramaPrincipal.pathCajas);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar numeros en la cantidad!");
        }
    }//GEN-LAST:event_jButtonAgregarCajaActionPerformed

    private void jButtonSalirBeb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirBeb1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirBeb1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAumentarProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAumentarProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAumentarProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAumentarProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAumentarProd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JTabBebias;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonAgregarBeb;
    private javax.swing.JButton jButtonAgregarCaja;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSalirBeb;
    private javax.swing.JButton jButtonSalirBeb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListBebias;
    private javax.swing.JList<String> jListCajas;
    private javax.swing.JList<String> jListToppings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jTabToppings;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldBebidas;
    private javax.swing.JTextField jTextFieldCajas;
    private javax.swing.JTextField jTextFieldToppings;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private DefaultListModel<String> listModel2 = new DefaultListModel<String>();
    private DefaultListModel<String> listModel3 = new DefaultListModel<String>();

    private void llenarLista() {

        int cantidadToppings = ProgramaPrincipal.datos.getToppings().largo();
        int cantidadBebidas = ProgramaPrincipal.datos.getBebidas().largo();
        int cantidadCajas = ProgramaPrincipal.datos.getCajas().largo();

        if (cantidadToppings > 0) {
            for (int i = 0; i < cantidadToppings; i++) {
                listModel.addElement(((Topping) ProgramaPrincipal.datos.getToppings().obtener(i)).getNombre());
            }

            jListToppings.setModel(listModel);
        }

        if (cantidadBebidas > 0) {
            for (int i = 0; i < cantidadBebidas; i++) {
                listModel2.addElement(((Bebida) ProgramaPrincipal.datos.getBebidas().obtener(i)).getNombre());
            }

            jListBebias.setModel(listModel2);
        }
        
        if (cantidadCajas > 0) {
            for (int i = 0; i < cantidadCajas; i++) {
                listModel3.addElement(((Caja) ProgramaPrincipal.datos.getCajas().obtener(i)).getNombre());
            }

            jListCajas.setModel(listModel3);
        }
    }
}
