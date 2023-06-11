package code.model.buttons;

import code.view.new_order.NewOrder_OrderManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_NewOrder_Action implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        NewOrder_OrderManager newOrder_tradeManager = new NewOrder_OrderManager(1400, 800);
    }
}
