package code.model.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class AppPropertiesGetter {
    Logger logger = LogManager.getLogger(AppPropertiesGetter.class);
    public String getAppProperties(String key) {
        Properties appProperties = new Properties();
        try {
            appProperties.load(getClass().getClassLoader().getResourceAsStream("resources/trade_fair_order_manager.properties"));
            logger.info("Got property from properties file");
        } catch (IOException ioException) {
            logger.error("Failed to get property from properties file");
        }
        return appProperties.getProperty(key);
    }
}
