package code.controller;

import code.model.AppPropertiesGetter;
import code.model.FontMaker;
import code.model.ImageIconMaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
