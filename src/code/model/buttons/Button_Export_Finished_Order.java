package code.model.buttons;

import code.view.new_order.NewOrder_TabPane_OrderOverview;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Button_Export_Finished_Order implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        List<JTable> orderOverviewTables = NewOrder_TabPane_OrderOverview.oderOverviewTables;
        writeTablesToCSV(orderOverviewTables, "test.csv");
    }
    public static void writeTablesToCSV(List<JTable> orderOverviewTables, String csvFilePath) {
        StringBuilder csvData = new StringBuilder();

        for (JTable orderOverviewTable : orderOverviewTables) {
            csvData.append(orderOverviewTable.getName() + ":\n");
            int rowCount = orderOverviewTable.getRowCount();
            int columnCount = orderOverviewTable.getColumnCount();
            // Write column names
            for (int column = 0; column < columnCount; column++) {
                TableColumn tableColumn = orderOverviewTable.getColumnModel().getColumn(column);
                csvData.append(tableColumn.getHeaderValue());

                if (column < columnCount - 1) {
                    csvData.append(";");
                }
            }
            csvData.append("\n");

            // Write data rows
            for (int row = 0; row < rowCount; row++) {
                for (int column = 0; column < columnCount; column++) {
                    Object cellValue = orderOverviewTable.getValueAt(row, column);
                    csvData.append(cellValue != null ? cellValue.toString() : "");

                    if (column < columnCount - 1) {
                        csvData.append(";");
                    }
                }

                csvData.append("\n");
            }
            csvData.append("\n\n");
        }

        try (FileWriter writer = new FileWriter(csvFilePath)) {
            writer.write(csvData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
