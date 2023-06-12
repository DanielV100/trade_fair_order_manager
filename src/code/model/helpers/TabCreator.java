package code.model.helpers;

import code.controller.Controller;
import code.view.new_order.NewOrder_TabPane_OrderOverview;
import resources.Sizes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class TabCreator {
    Controller controller = new Controller();
    Sizes sizes = new Sizes();
    public JTable createTableWithProducts(String fileName, boolean isOrderList) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/config/" + fileName));
            String headerLine = reader.readLine();
            String[] columnNames = headerLine.split(";");
            tableModel.setColumnIdentifiers(columnNames);
            if(isOrderList) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowData = line.split(";");
                    tableModel.addRow(rowData);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JTable table = new JTable(tableModel);
        table.setName(fileName);
        table.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 1));
        table.getTableHeader().setFont(controller.createRobotoFont(sizes.getFontSizeHeading(), 2));
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(30);
        table.setShowGrid(true);
        if(!isOrderList) {
            NewOrder_TabPane_OrderOverview.jTables.add(table);
        }
        tableModel.addTableModelListener(e -> {
            if(table.getColumnName(e.getColumn()).startsWith("quantity")) {
                DefaultTableModel model = null;
                for (int i = 0; i < NewOrder_TabPane_OrderOverview.jTables.size(); i++) {
                    JTable jTable =  NewOrder_TabPane_OrderOverview.jTables.get(i);
                    //order list table "bags" should only write in order view table "bags" --> tables (config files) shouldn't have the same name!
                    if(jTable.getName().equals(fileName)) {
                        model = (DefaultTableModel) jTable.getModel();
                    }
                }
                int row = e.getFirstRow();
                Object[] rowData = new Object[table.getColumnCount()];
                //e.g. for clothes with different sizes (s, m, l) you have to fill in e.g. 0 1 1 --> all cells have to be filled
                boolean allCellsFilled = true;
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    if(value.toString().equals("")) {
                        allCellsFilled = false;
                    }
                    rowData[col] = value;
                }
                if(allCellsFilled) {
                    model.addRow(rowData);
                }
                //-1 --> cell is added to table
            } else if (e.getColumn() == -1) {
                System.out.println("Added row");
                int columnPurchasePriceIndex = 0;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if(table.getColumnName(i).equals("EK")) {
                        columnPurchasePriceIndex = i;
                    }
                }
                NewOrder_TabPane_OrderOverview.purchasePrice = 0;
                for (int count = 0; count < table.getRowCount(); count++){
                    NewOrder_TabPane_OrderOverview.purchasePrice += Double.parseDouble(table.getValueAt(count, columnPurchasePriceIndex).toString());
                }
                System.out.println("Purchase Price: " + NewOrder_TabPane_OrderOverview.purchasePrice);
            }
        });

        return table;
    }
    public void getAllFilesFromConfigFolder(JTabbedPane jTabbedPane, boolean isOrderList) {
        File configFile = new File("src/resources/config/");
        File[] filesInDirectory = configFile.listFiles();
        JScrollPane jScrollPane = null;
        for (File file : filesInDirectory) {
            jScrollPane = new JScrollPane(createTableWithProducts(file.getName(), isOrderList));
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jTabbedPane.addTab(file.getName(), jScrollPane);
        }
    }
}
