package code.model;

import java.io.IOException;
import java.util.Properties;

public class AppPropertiesGetter {
    public String getAppProperties(String key) throws IOException {
        Properties appProperties = new Properties();
        appProperties.load(getClass().getClassLoader().getResourceAsStream("resources/trade_fair_order_manager.properties"));
        return appProperties.getProperty(key);
    }
}
