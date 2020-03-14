/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import datos.Combo;
import main.ProgramaPrincipal;
import datos.Producto;
import java.awt.Font;
import negocio.Lista;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nertrox
 */
public class FrEditarCombo extends javax.swing.JFrame {
    
    boolean copiar = false;
    /**
     * Creates new form FrEditarPizza
     */
    private Combo combo;

    public FrEditarCombo(String combo) {
        initComponents();
        setLocationRelativeTo(null);
        this.combo = ProgramaPrincipal.datos.obtenerCombo(combo);
        llenarTablaProductos(combo);
        jTextFieldNombre.setText(this.combo.getNombre());
        jTextFieldDesc.setText(this.combo.getDescripcion());
        
        String precio = "₡" + String.format("%,d", this.combo.getPrecio());
        jTextFielPrecio.setText(precio);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDesc = new javax.swing.JTextField();
        jTextFielPrecio = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 107, 70), 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Precio");

        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescActionPerformed(evt);
            }
        });

        jTextFielPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFielPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFielPrecioActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEliminar.setText("Eliminar Producto");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Productos");

        Guardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Guardar.setText("Guardar Cambios");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        JTableProductos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableProductos.setRowHeight(40);
        JTableProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTableProductos);
        if (JTableProductos.getColumnModel().getColumnCount() > 0) {
            JTableProductos.getColumnModel().getColumn(0).setResizable(false);
            JTableProductos.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFielPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFielPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formatearNumeros() {
        
        String value = "";
        String numero;
        for (int i = 0; i < JTableProductos.getRowCount(); i++) {
            numero = String.valueOf(JTableProductos.getValueAt(i, 1));
            value += String.format("%,d", Integer.valueOf(numero));
            JTableProductos.setValueAt(value, i, 1);
            value = "";
        }
    }

    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) JTableProductos.getModel();
        int cantidad = JTableProductos.getRowCount();
        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                modelo.removeRow(0);
            }
        }
    }
    
    private void llenarTablaProductos(String combo) {
        JTableProductos.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        DefaultTableModel model = (DefaultTableModel) JTableProductos.getModel();
        model.setRowCount(0);
        Lista productos = ProgramaPrincipal.datos.obtenerCombo(combo).getProductos();
        if (productos.largo() != 0) {
            Producto p;
            for (int i = 0; i < productos.largo(); i++) {
                p = (Producto) productos.obtener(i);
                model.addRow(new Object[]{p.getNombre(), p.getCantidadEnCombo()});
            }
            
            formatearNumeros();
        }
    }
    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescActionPerformed

    private void jTextFielPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFielPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFielPrecioActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) JTableProductos.getModel();
        
        int filas = combo.getProductos().cantidad();
        
        if (filas > 1) {
            int opcion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este producto?", "Eliminar Producto", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                String producto = String.valueOf(model.getValueAt(JTableProductos.getSelectedRow(), 0));
                combo.removerProducto(producto);
                llenarTablaProductos(combo.getNombre());
                JTableProductos.repaint();
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puede dejar el combo sin productos!");
        }

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        FrModificarProductos fr = new FrModificarProductos();
        fr.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        
        String nombre = jTextFieldNombre.getText();
        String descripcion = jTextFieldDesc.getText();
        boolean bandera = false;
        if (descripcion.equals("") || nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Ha dejado algun campo en blanco!");
        } else {
            try {
                guardarCambiosTabla();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ha ingresado una cantidad incorrecta!");
                bandera = true;
                
            }
            if (!bandera) {
                try {
                    String p = jTextFielPrecio.getText();
                    p = quitarColon(p);
                    int precio = Integer.parseInt(p);
                    combo.setDescripcion(descripcion);
                    combo.setPrecio(precio);
                    JOptionPane.showMessageDialog(this, "Guardado de forma correcta!");
                    ProgramaPrincipal.datos.guardarCombos(ProgramaPrincipal.pathCombos);
                    FrModificarProductos fr = new FrModificarProductos();
                    fr.setVisible(true);
                    this.dispose();
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Ha ingresado un precio incorecto!");
                }
            }
        }

    }//GEN-LAST:event_GuardarActionPerformed
    
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
    
    private String desformatear(String value) {
        
        String formateado[] = value.split(",");
        String desformateado = "";
        for (int i = 0; i < formateado.length; i++) {
            desformateado += formateado[i];
        }
        
        return desformateado;
    }
    
    private void guardarCambiosTabla() throws NumberFormatException {
        int filas = JTableProductos.getRowCount();
        String nombre;
        int cantidad;
        
        for (int i = 0; i < filas; i++) {
            nombre = String.valueOf(JTableProductos.getValueAt(i, 0));
            String c = String.valueOf(JTableProductos.getValueAt(i, 1));
            c = desformatear(c);
            cantidad = Integer.parseInt(c);
            combo.modificarProducto(nombre, cantidad);
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JTable JTableProductos;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFielPrecio;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}