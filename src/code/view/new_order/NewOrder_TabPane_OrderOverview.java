package code.view.new_order;

import code.controller.Controller;
import code.model.helpers.TabCreator;
import resources.Sizes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class NewOrder_TabPane_OrderOverview extends JTabbedPane {
    TabCreator configFileReader = new TabCreator();
    Sizes sizes = new Sizes();
    Controller controller = new Controller();
    public static List<JTable> jTables = new ArrayList<>();
    public NewOrder_TabPane_OrderOverview(int width, int height) {
        this.setBounds(20, 400, width, height);
        this.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 2));
        configFileReader.getAllFilesFromConfigFolder(this, false);
    }
}
