package code.view;

import code.controller.Controller;
import code.model.TextField_FocusListener;

import javax.swing.*;
import java.awt.*;

/**
 * Class for creating JPanel for getting the contact data of the customer.
 */
public class NewOrder_JPanel_ContactData extends JPanel {
    Controller controller = new Controller();

    public NewOrder_JPanel_ContactData(int width, int height) {
        this.setBounds(20,10, width, height);
        createJLabels();
        this.setLayout(createGridLayout(8, 2));
        JLabel[] jLabels = createJLabels();
        JTextField[] jTextFields = createJTextFields();
        for (int i = 0; i < jLabels.length; i++) {
            this.add(jLabels[i]);
            if(i == jLabels.length-1) {
                JTextArea jTextArea = new JTextArea();
                jTextArea.setFont(controller.createRobotoFont(9, 0));
                jTextArea.setOpaque(false);
                jTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
                this.add(jTextArea);
            } else {
                this.add(jTextFields[i]);
            }
        }
    }

    private GridLayout createGridLayout(int rows, int cols) {
        GridLayout gridLayout = new GridLayout(rows, cols);
        gridLayout.setVgap(10);
        return gridLayout;

    }

    /**
     * Method for creating the JLabels with the different metadatas.
     * @return JLabel[]
     */
    private JLabel[] createJLabels() {
        String[] metadata = {"Name:", "Company:", "Street:", "Zip code, city, country:", "USt-ID No.:", "Mail:", "Mobile:", "Notes:"};
        JLabel[] jLabels = new JLabel[8];
        for (int i = 0; i < jLabels.length; i++) {
            jLabels[i] = new JLabel();
            jLabels[i].setText(metadata[i]);
            jLabels[i].setFont(controller.createRobotoFont(16, 2));
        }
        return jLabels;
    }

    /**
     * Method for creating the JTextFields for the user input.
     * @return JTextField[]
     */
    private JTextField[] createJTextFields() {
        JTextField[] jTextFields = new JTextField[7];
        for (int i = 0; i < jTextFields.length; i++) {
            jTextFields[i] = new JTextField();
            jTextFields[i].setOpaque(false);
            jTextFields[i].addFocusListener(new TextField_FocusListener());
            jTextFields[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            jTextFields[i].setFont(controller.createRobotoFont(16, 0));
        }
        return jTextFields;
    }
}
