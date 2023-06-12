package code.model.jfilechooser;

import code.controller.Controller;
import code.model.helpers.TabCreator;
import resources.Sizes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class JFileChooser_ActionListener implements ActionListener {
    Controller controller = new Controller();
    TabCreator configFileReader = new TabCreator();
    Sizes sizes = new Sizes();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            JFileChooser jFileChooser = (JFileChooser) e.getSource();
            File selectedFile = jFileChooser.getSelectedFile();
            JTabbedPane jTabbedPane = (JTabbedPane) jFileChooser.getParent();
            jTabbedPane.addTab(selectedFile.getName(), createOrderList(selectedFile));
            System.out.println(selectedFile.getName());
        }
    }
    private JScrollPane createOrderList(File configFile) {
        saveConfigFile(configFile);
        JScrollPane jScrollPane = new JScrollPane(configFileReader.createTableWithProducts(configFile.getName()));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return jScrollPane;
    }

    private void saveConfigFile(File configFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            FileWriter fileWriter = new FileWriter(new File("src/resources/config", configFile.getName()));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String line;
            while ((line = reader.readLine()) != null) {
                printWriter.println(line);
            }
            reader.close();
            printWriter.close();
        } catch (Exception e) {

        }

    }
    private JTable createTableWithProducts(File configFile) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            FileWriter fileWriter = new FileWriter(new File("src/resources/config", configFile.getName()));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String headerLine = reader.readLine();
            String[] columnNames = headerLine.split(";");
            tableModel.setColumnIdentifiers(columnNames);
            String line;
            while ((line = reader.readLine()) != null) {
                printWriter.println(line);
                String[] rowData = line.split(";");
                tableModel.addRow(rowData);
            }
            reader.close();
            printWriter.close();
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
}
