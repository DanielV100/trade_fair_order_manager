package code.view.new_order;

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
        frameNewOrder.setLayout(null);
        frameNewOrder.add(new NewOrder_JPanel_ContactData(500, 350));
        //frameNewOrder.add(new NewOrder_JScrollPane_OrderList(700, 700));
        frameNewOrder.add(new NewOrder_TabPane_OrderList(820, 750));
        frameNewOrder.setVisible(true);
    }
}
