import code.view.Start_TradeManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        FlatLightLaf.setup();
        logger.info("Starting application");
        Start_TradeManager start_tradeManager = new Start_TradeManager(400, 300);
    }
}