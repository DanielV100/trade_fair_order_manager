package code.model.jfilechooser;

import code.controller.Controller;
import resources.Sizes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JFileChooser_ActionListener implements ActionListener {
    Controller controller = new Controller();
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
        JScrollPane jScrollPane = new JScrollPane(createTableWithProducts(configFile));
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return jScrollPane;
    }
    private JTable createTableWithProducts(File configFile) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFile));
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
}
