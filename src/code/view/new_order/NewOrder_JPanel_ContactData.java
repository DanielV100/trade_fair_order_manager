package code.view.new_order;

import code.controller.Controller;
import code.model.textfields.TextField_FocusListener;
import code.model.textfields.TextField_MouseListener;
import resources.Sizes;

import javax.swing.*;
import java.awt.*;

/**
 * Class for creating JPanel for getting the contact data of the customer.
 */
public class NewOrder_JPanel_ContactData extends JPanel {
    Sizes sizes = new Sizes();
    Controller controller = new Controller();

    public NewOrder_JPanel_ContactData(int width, int height) {
        this.setBounds(20,10, width, height);
        createJLabels();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel[] jLabels = createJLabels();
        JTextField[] jTextFields = createJTextFields();
        for (int i = 0; i < jLabels.length; i++) {
            this.add(jLabels[i]);
            if(i == jLabels.length-1) {
                JTextArea jTextArea = new JTextArea();
                jTextArea.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 1));
                jTextArea.setPreferredSize(new Dimension(300, 100));
                jTextArea.setOpaque(false);
                jTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
                this.add(jTextArea);
            } else {
                this.add(jTextFields[i]);
            }
        }
    }

    /**
     * Method for creating the JLabels with the different metadatas.
     * @return JLabel[]
     */
    private JLabel[] createJLabels() {
        String[] metadata = {"Name:", "Company:", "Street:", "Zip, city, country:", "USt-ID No.:", "Mail:", "Mobile:", "Notes:"};
        JLabel[] jLabels = new JLabel[8];
        for (int i = 0; i < jLabels.length; i++) {
            jLabels[i] = new JLabel();
            jLabels[i].setPreferredSize(new Dimension(140, 25));
            jLabels[i].setText(metadata[i]);
            jLabels[i].setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 2));
        }
        return jLabels;
    }

    /**
     * Method for creating the JTextFields for the user input.
     * @return JTextField[]
     */
    private JTextField[] createJTextFields() {
        String[] placeholder = {"e.g. Max Mustermann", "e.g. Lederwaren GmbH", "e.g. Leder-Manufaktur-Straße 12", "e.g. 74889 Sinsheim, DE", "e.g. DE814881212", "e.g. leder@waren.com", "e.g. +49 15112791554", ""};
        //length isn't eight like at the jlabels, because a textarea is needed as last component (not a jtextfield)
        JTextField[] jTextFields = new JTextField[7];
        for (int i = 0; i < jTextFields.length; i++) {
            jTextFields[i] = new JTextField(placeholder[i]);
            jTextFields[i].setOpaque(false);
            jTextFields[i].setForeground(Color.LIGHT_GRAY);
            jTextFields[i].setPreferredSize(new Dimension(300, 20));
            jTextFields[i].addFocusListener(new TextField_FocusListener());
            jTextFields[i].addMouseListener(new TextField_MouseListener());
            jTextFields[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            jTextFields[i].setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 0));
        }
        return jTextFields;
    }
}
