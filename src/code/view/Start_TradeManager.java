package code.view;

import code.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * View at start of the application.
 */
public class Start_TradeManager {
    Controller controller = new Controller();

    public Start_TradeManager(int width, int height) {
        JFrame frameStart = new JFrame(controller.getAppProperties("start_trademanager_framestart_name"));
        frameStart.setSize(width, height);
        frameStart.setResizable(false);
        //centering the application on start
        frameStart.setLocationRelativeTo(null);
        frameStart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameStart.add(createStartView(width, height));
        frameStart.setVisible(true);
    }
    private JPanel createStartView(int width, int height) {
        JPanel jPanelStart = new JPanel();
        jPanelStart.setLayout(new GridLayout(1, 2));
        jPanelStart.setSize(width, height);
        jPanelStart.add(createButton("start_trademanager_buttonneworder", Color.WHITE));
        jPanelStart.add(createButton("start_trademanager_buttonarchive", Color.LIGHT_GRAY));

        return jPanelStart;
    }

    private JButton createButton(String key, Color color) {
        JButton jButton = new JButton(controller.getAppProperties(key));
        jButton.setFont(controller.createRobotoFont(18f, 0));
        jButton.setBackground(color);
        return jButton;
    }
}
