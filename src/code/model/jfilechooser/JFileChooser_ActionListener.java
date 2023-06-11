package code.model.jfilechooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JFileChooser_ActionListener implements ActionListener {
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
        return table;
    }
}
