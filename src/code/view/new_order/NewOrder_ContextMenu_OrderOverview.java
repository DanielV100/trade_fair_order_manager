package code.view.new_order;

import code.controller.Controller;
import code.model.orderviewjtable.JMenuItem_Delete_OrderView_MouseListener;
import resources.Sizes;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class NewOrder_ContextMenu_OrderOverview extends JPopupMenu {
    Controller controller = new Controller();
    Sizes sizes = new Sizes();
    public NewOrder_ContextMenu_OrderOverview(MouseEvent e) {
        JMenuItem delete = new JMenuItem("Delete row", controller.createImageIcons("resources/icons/delete.png"));
        delete.addMouseListener(new JMenuItem_Delete_OrderView_MouseListener(e));
        this.add(delete);
        this.setFont(controller.createRobotoFont(sizes.getFontSizeStandard(), 1));
        this.show(e.getComponent(), e.getX(), e.getY());
    }
}
