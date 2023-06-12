package code.view.new_order;


import code.controller.Controller;
import code.model.helpers.TabCreator;
import code.model.jfilechooser.JFileChooser_ActionListener;
import resources.Sizes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewOrder_TabPane_OrderList extends JTabbedPane {
    TabCreator configFileReader = new TabCreator();
    Sizes sizes = new Sizes();
    Controller controller = new Controller();
    public NewOrder_TabPane_OrderList(int width, int height) {
        this.setBounds(550, 10, width, height);
        this.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 2));
        this.addTab("Add products", configFileChooser());
        configFileReader.getAllFilesFromConfigFolder(this, true);
    }

    private JFileChooser configFileChooser() {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV Files", "csv");
        jFileChooser.setFileFilter(csvFilter);
        jFileChooser.addActionListener(new JFileChooser_ActionListener());

        return jFileChooser;
    }
}
