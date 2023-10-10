package main.java.kungfutea.pos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerDashboardController {
    @FXML
    private void getEmployeeData(ActionEvent event) throws Exception {
        Main.showEmployeeView();
    }

    @FXML
    private void getInventoryData(ActionEvent event) throws Exception {
        Main.showInventoryView();
    }

    @FXML
    private void getRevenueData(ActionEvent event) throws Exception {
        Main.showRevenueView();
    }

    @FXML
    private void getOrderData(ActionEvent event) throws Exception {
        Main.showOrderView();
    }
}
