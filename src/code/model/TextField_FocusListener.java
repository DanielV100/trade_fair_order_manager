package code.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField_FocusListener implements FocusListener {
    FontMaker fontMaker = new FontMaker();
    @Override
    public void focusGained(FocusEvent e) {
        JTextField jTextField = (JTextField) e.getComponent();
        jTextField.setForeground(Color.BLACK);
        jTextField.setText("");
        jTextField.setFont(fontMaker.createRobotoFont(16, 1));
        jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField jTextField = (JTextField) e.getComponent();
        jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
    }
}
