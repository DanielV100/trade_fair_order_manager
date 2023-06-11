package code.controller;

import code.model.helpers.AppPropertiesGetter;
import code.model.helpers.FontMaker;
import code.model.helpers.ImageIconMaker;

import javax.swing.*;
import java.awt.*;

public class Controller {
    AppPropertiesGetter appPropertiesGetter = new AppPropertiesGetter();
    FontMaker fontMaker = new FontMaker();
    ImageIconMaker imageIconMaker = new ImageIconMaker();

    public Controller() {
    }

    public Font createRobotoFont(float size, int mode) {
        return fontMaker.createRobotoFont(size, mode);
    }

    public ImageIcon createImageIcons(String path) {
        return imageIconMaker.createImageIcons(path);
    }

    public String getAppProperties(String key) {
        return appPropertiesGetter.getAppProperties(key);
    }
}
