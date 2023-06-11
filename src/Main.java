import code.view.Start_TradeManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        logger.info("Starting application");
        Start_TradeManager start_tradeManager = new Start_TradeManager();
    }
}