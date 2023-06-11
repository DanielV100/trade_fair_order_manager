package code.model.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class ImageIconMaker {
    /**
     * Method for creating an image icon which can be used as icon for buttons, label etc.
     * @param path
     * @return ImageIcon
     */
    public ImageIcon createImageIcons(String path) {
        Logger logger = LogManager.getLogger(ImageIconMaker.class);
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream(path);
        try {
            logger.info("Getting image icon from resources and return it");
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(imageStream));
            return imageIcon;
        } catch (IOException e) {
            logger.error("Icon resource file not found");
        }
        return null;
    }
}
