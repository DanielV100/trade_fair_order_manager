package code.view;

import code.controller.Controller;

import javax.swing.*;
import java.io.IOException;

/**
 * View at start of the application.
 */
public class Start_TradeManager {
    Controller controller = new Controller();

    public Start_TradeManager() throws IOException {
        JFrame frameStart = new JFrame(controller.getAppProperties("start_trademanager_framestart_name"));
        frameStart.setVisible(true);
    }
}
