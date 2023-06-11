package code.model.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.IOException;

public class FontMaker {
    Logger logger = LogManager.getLogger(Font.class);

    /**
     * Method for creating roboto font.
     * @param size as float
     * @param mode (0 -> thin, 1 -> regular, 2 -> bold)
     * @return Font
     */
    public Font createRobotoFont(float size, int mode) {

        try {
            logger.info("Getting font from resources and return it");
            Font font = null;
            if(mode == 0) {
                font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("resources/fonts/roboto-light.ttf"));
            } else if (mode == 1) {
                font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("resources/fonts/roboto-regular.ttf"));
            } else if (mode == 2){
                font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("resources/fonts/roboto-bold.ttf"));
            }
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
