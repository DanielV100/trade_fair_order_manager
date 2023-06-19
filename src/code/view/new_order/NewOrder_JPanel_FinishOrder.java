package code.view.new_order;

import code.controller.Controller;
import resources.Sizes;

import javax.swing.*;
import java.awt.*;

public class NewOrder_JPanel_FinishOrder extends JPanel {
    Sizes sizes = new Sizes();
    Controller controller = new Controller();
    public static JLabel purchasePrice = new JLabel("Purchase price: 0,00€");

    public NewOrder_JPanel_FinishOrder(int width, int height) {
        this.setBounds(20, 700, width, height);
        this.setLayout(new GridLayout(1, 2));
        purchasePrice.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 2));
        this.add(purchasePrice);
        this.add(createExportToPDFButton());
        this.setVisible(true);
    }
    private JButton createExportToPDFButton() {
        JButton jButtonExport = new JButton("Export to PDF");
        return jButtonExport;
    }

}
