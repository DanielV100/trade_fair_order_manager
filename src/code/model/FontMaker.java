package code.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.IOException;

public class FontMaker {
    Logger logger = LogManager.getLogger(Font.class);

    public Font createRobotoLight(float size) {
        try {
            logger.info("Getting font from resources and return it");
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("resources/fonts/roboto-light.ttf"));
            Font sizedFont = font.deriveFont(size);
            return sizedFont;
        } catch (FontFormatException e) {
            logger.error("Font format error");
        } catch (IOException e) {
            logger.error("Font file not found");
        }
        return null;
    }
}
