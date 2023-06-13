package code.model.orderviewjtable;

import code.view.new_order.NewOrder_TabPane_OrderList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class JMenuItem_Delete_OrderView_MouseListener implements MouseListener {
    private JTable clickedJTable;
    private MouseEvent mouseEventClickedJTable;
    public JMenuItem_Delete_OrderView_MouseListener(MouseEvent jTableClickedEvent) {
        this.clickedJTable = (JTable) jTableClickedEvent.getComponent();
        this.mouseEventClickedJTable = jTableClickedEvent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //getting clicked row and delete it from order overview
        int clickedRowIndex = clickedJTable.rowAtPoint(mouseEventClickedJTable.getPoint());
        Object[] rowData = null;
        //checks for valid row
        if (clickedRowIndex != -1) {
            int modelRowIndex = clickedJTable.convertRowIndexToModel(clickedRowIndex);
            DefaultTableModel model = (DefaultTableModel) clickedJTable.getModel();
            int columnCount = model.getColumnCount();
            //object with the deleted row data
            rowData = new Object[columnCount];
            for (int column = 0; column < columnCount; column++) {
                rowData[column] = model.getValueAt(modelRowIndex, column);
            }
            model.removeRow(modelRowIndex);
            clickedJTable.repaint();
        }
        //searching for the correct table and columns to clear
        List<JTable> orderListTables = NewOrder_TabPane_OrderList.orderListTables;
        JTable orderListTableToClear = null;
        List<Integer> quantityIndexes = null;
        for (JTable orderListTable : orderListTables) {
            //getting the correct table (to clear) from order list
            if (orderListTable.getName().equals(clickedJTable.getName())) {
                orderListTableToClear = orderListTable;
                quantityIndexes = new ArrayList<>();
                //getting all columns that start with "quantity" because they should be empty after
                for (int i = 0; i < orderListTable.getColumnCount(); i++) {
                    if(orderListTable.getColumnName(i).startsWith("quantity")) {
                        quantityIndexes.add(i);
                    }
                }
            }
        }
        //searching for the corrected row to clear
        DefaultTableModel modelTableOrderList = (DefaultTableModel) orderListTableToClear.getModel();
        Object[] rowDataFromOrderList;
        int rowCountTemp = modelTableOrderList.getRowCount();
        for (int rows = 0; rows < rowCountTemp; rows++) {
            rowDataFromOrderList = new Object[rowData.length]; ;
            for (int x = 0; x < orderListTableToClear.getColumnCount(); x++) {
                rowDataFromOrderList[x] = modelTableOrderList.getValueAt(rows, x);
            }
            boolean rowsAreSame = true;
            for (int cell = 0; cell < rowDataFromOrderList.length; cell++) {
                if(!(rowDataFromOrderList[cell].toString().equals(rowData[cell].toString()))) {
                    rowsAreSame = false;
                }
            }
            if(rowsAreSame) {
                for (int index : quantityIndexes) {
                    modelTableOrderList.setValueAt("", rows, index);
                }
                clickedJTable.repaint();
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
