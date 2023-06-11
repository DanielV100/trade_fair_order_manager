package code.view.new_order;


import code.controller.Controller;
import code.model.jfilechooser.JFileChooser_ActionListener;
import resources.Sizes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NewOrder_TabPane_OrderList extends JTabbedPane {
    Sizes sizes = new Sizes();
    Controller controller = new Controller();
    public NewOrder_TabPane_OrderList(int width, int height) {
        this.setBounds(550, 10, width, height);
        this.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 2));
        this.addTab("Add products", configFileChooser());
    }

    private JFileChooser configFileChooser() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.addActionListener(new JFileChooser_ActionListener());

        return jFileChooser;
    }
    private JScrollPane test() {
        JScrollPane jScrollPane = new JScrollPane();


        return jScrollPane;
    }
}
