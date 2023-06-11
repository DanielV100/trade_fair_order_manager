package code.controller;

import code.model.AppPropertiesGetter;
import code.model.FontMaker;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class Controller {
    AppPropertiesGetter appPropertiesGetter = new AppPropertiesGetter();
    FontMaker fontMaker = new FontMaker();

    public Controller() {
    }

    public Font createRobotoLight(float size) {
        return fontMaker.createRobotoLight(size);
    }

    public String getAppProperties(String key) {
        return appPropertiesGetter.getAppProperties(key);
    }
}
