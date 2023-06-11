package code.view.new_order;


import code.controller.Controller;
import resources.Sizes;

import javax.swing.*;

public class NewOrder_TabPane_OrderList extends JTabbedPane {
    Sizes sizes = new Sizes();
    Controller controller = new Controller();
    public NewOrder_TabPane_OrderList(int width, int height) {
        this.setBounds(550, 10, width, height);
        this.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 2));
        this.addTab("Bags", test());
        this.addTab("Bandlets", new JButton("Test"));
        this.addTab("Jewellery", new JTextField("Test"));
    }
    private JScrollPane test() {
        JScrollPane jScrollPane = new JScrollPane();
        return jScrollPane;
    }
}
