package code.model.orderviewjtable;

import code.view.new_order.NewOrder_ContextMenu_OrderOverview;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JTable_OrderView_MouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e) || (System.getProperty("os.name").contains("Mac OS X") && e.isControlDown())) {
            new NewOrder_ContextMenu_OrderOverview(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
