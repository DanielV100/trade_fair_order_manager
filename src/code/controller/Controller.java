package code.controller;

import code.model.AppPropertiesGetter;

import java.io.IOException;
import java.util.Properties;

public class Controller {
    AppPropertiesGetter appPropertiesGetter = new AppPropertiesGetter();

    public Controller() {
    }

    public String getAppProperties(String key) throws IOException {
        return appPropertiesGetter.getAppProperties(key);
    }
}
