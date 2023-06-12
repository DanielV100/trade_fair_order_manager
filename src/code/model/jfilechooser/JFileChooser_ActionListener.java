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
        JScrollPane jScrollPane = new JScrollPane(configFileReader.createTableWithProducts(configFile.getName(), true));
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
}
