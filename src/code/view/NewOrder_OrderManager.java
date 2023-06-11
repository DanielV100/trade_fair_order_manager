package code.view;

import code.controller.Controller;

import javax.swing.*;

public class NewOrder_OrderManager {
    Controller controller = new Controller();
    public NewOrder_OrderManager(int width, int height) {
        JFrame frameNewOrder = new JFrame(controller.getAppProperties("neworder_ordermanager_frameneworder_name"));
        frameNewOrder.setSize(width, height);
        frameNewOrder.setResizable(false);
        //centering the application on start
        frameNewOrder.setLocationRelativeTo(null);
        frameNewOrder.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // frameNewOrder.add(createStartView(width, height));
        frameNewOrder.setLayout(null);
        frameNewOrder.add(new NewOrder_JPanel_ContactData(500, 300));
        frameNewOrder.setVisible(true);
    }
}
