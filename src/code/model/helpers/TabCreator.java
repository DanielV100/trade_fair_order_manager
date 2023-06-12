package code.model.helpers;

import code.controller.Controller;
import resources.Sizes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class TabCreator {
    Controller controller = new Controller();
    Sizes sizes = new Sizes();
    public JTable createTableWithProducts(String fileName) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/config/" + fileName));
            String headerLine = reader.readLine();
            String[] columnNames = headerLine.split(";");
            tableModel.setColumnIdentifiers(columnNames);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(";");
                tableModel.addRow(rowData);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JTable table = new JTable(tableModel);
        table.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 1));
        table.getTableHeader().setFont(controller.createRobotoFont(sizes.getFontSizeHeading(), 2));
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(30);
        table.setShowGrid(true);
        //ToDo: Save file in a directory from classpath -> save config files
        return table;
    }
    public void getAllFilesFromConfigFolder(JTabbedPane jTabbedPane) {
        File configFile = new File("src/resources/config/");
        File[] filesInDirectory = configFile.listFiles();
        for (File file : filesInDirectory) {
            JScrollPane jScrollPane = new JScrollPane(createTableWithProducts(file.getName()));
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jTabbedPane.addTab(file.getName(), jScrollPane);
        }
    }
}
