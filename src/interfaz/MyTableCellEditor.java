/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Component;
import java.awt.Font;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Nertrox
 */
public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {

    JComponent component = new JTextField();

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
        ((JTextField) component).setText((String) value);
        ((JTextField) component).setFont(new Font("Tahoma", Font.PLAIN, 24));
        return component;

    } 
    
    public Object getCellEditorValue() {
        return ((JTextField) component).getText();
    }
    
    
}
