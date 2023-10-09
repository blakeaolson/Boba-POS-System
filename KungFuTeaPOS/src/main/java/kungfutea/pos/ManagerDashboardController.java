package kungfutea.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerDashboardController {
    @FXML
    private void handleOtherScreen1(ActionEvent event) throws Exception {
        Main.showOtherScreen1();
    }

    @FXML
    private void handleOtherScreen2(ActionEvent event) throws Exception {
        Main.showOtherScreen2();
    }

    @FXML
    private void handleOtherScreen3(ActionEvent event) throws Exception {
        Main.showOtherScreen3();
    }

    @FXML
    private void handleOtherScreen4(ActionEvent event) throws Exception {
        Main.showOtherScreen4();
    }
}
