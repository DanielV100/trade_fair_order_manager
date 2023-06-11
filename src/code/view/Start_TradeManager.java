package code.view;

import code.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * View at start of the application.
 */
public class Start_TradeManager {
    Logger logger = LogManager.getLogger(Start_TradeManager.class);
    Controller controller = new Controller();

    /**
     * Method for creating the start JFRame which contains the start JPanel.
     * @param width
     * @param height
     */
    public Start_TradeManager(int width, int height) {
        logger.info("Creating the JFrame for the start screen");
        JFrame frameStart = new JFrame(controller.getAppProperties("start_trademanager_framestart_name"));
        frameStart.setSize(width, height);
        frameStart.setResizable(false);
        //centering the application on start
        frameStart.setLocationRelativeTo(null);
        frameStart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameStart.add(createStartView(width, height));
        frameStart.setVisible(true);
    }

    /**
     * Method for creating start JPanel
     * @param width
     * @param height
     * @return JPanel
     */
    private JPanel createStartView(int width, int height) {
        logger.info("Creating the JPanel for the start screen with the buttons on it");
        JPanel jPanelStart = new JPanel();
        jPanelStart.setLayout(new GridLayout(1, 2));
        jPanelStart.setSize(width, height);
        jPanelStart.add(createButton("start_trademanager_buttonneworder", Color.WHITE, "resources/icons/add_order_icon.png"));
        jPanelStart.add(createButton("start_trademanager_buttonarchive", Color.LIGHT_GRAY, "resources/icons/archive_icon.png"));

        return jPanelStart;
    }

    /**
     * Method for creating buttons for the start screen
     * @param key
     * @param color
     * @param pathToIcon
     * @return
     */
    private JButton createButton(String key, Color color, String pathToIcon) {
        logger.info("Creating buttons");
        JButton jButton = new JButton(controller.getAppProperties(key));
        jButton.setFont(controller.createRobotoFont(18f, 0));
        jButton.setIcon(controller.createImageIcons(pathToIcon));
        jButton.setBackground(color);

        return jButton;
    }
}
