package main.java.kungfutea.pos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerDashboardController {
    @FXML
    private void handleOtherScreen1(ActionEvent event) throws Exception {
        Main.showEmployeeView();
    }

    @FXML
    private void handleOtherScreen2(ActionEvent event) throws Exception {
        Main.showInventoryView();
    }

    @FXML
    private void handleOtherScreen3(ActionEvent event) throws Exception {
        Main.showRevenueView();
    }

    @FXML
    private void handleOtherScreen4(ActionEvent event) throws Exception {
        Main.showOrderView();
    }
}
