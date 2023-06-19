package code.model.helpers;

import code.view.new_order.NewOrder_JPanel_FinishOrder;
import code.view.new_order.NewOrder_TabPane_OrderOverview;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PurchasePriceCalculator {
    /**
     * Method for getting purchase price. Iterating through the order overview tables and make tthe sum of all columns with "EK".
     * @return purchase price as double
     */
    public static double calcPurchasePrice() {
        NewOrder_TabPane_OrderOverview.purchasePrice = 0;
        for (JTable table : NewOrder_TabPane_OrderOverview.oderOverviewTables) {
            int columnPurchasePriceIndex = 0;
            List<Integer> quantityIndexList = new ArrayList<>();
            for (int i = 0; i < table.getColumnCount(); i++) {
                if(table.getColumnName(i).equals("EK")) {
                    columnPurchasePriceIndex = i;
                } else if(table.getColumnName(i).startsWith("quantity")) {
                    quantityIndexList.add(i);
                }
            }
            for (int x = 0; x < table.getRowCount(); x++) {
                int quantity = 0;
                for (int quantityIndex : quantityIndexList) {
                    quantity += (Integer.parseInt(table.getValueAt(x, quantityIndex).toString()));
                }
                    if (quantity != 0) {
                        NewOrder_TabPane_OrderOverview.purchasePrice += quantity * (Double.parseDouble(table.getValueAt(x, columnPurchasePriceIndex).toString()));
                    } else {
                        NewOrder_TabPane_OrderOverview.purchasePrice += (Double.parseDouble(table.getValueAt(x, columnPurchasePriceIndex).toString()));
                }
            }
        }
        return NewOrder_TabPane_OrderOverview.purchasePrice;
    }
}
