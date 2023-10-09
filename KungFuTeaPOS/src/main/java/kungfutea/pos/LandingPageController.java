package main.java.kungfutea.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LandingPageController {
    @FXML
    private void handleManagerLogin(ActionEvent event) throws Exception {
        Main.showManagerLogin();
    }

    @FXML
    private void handleCashierView(ActionEvent event) throws Exception {
        Main.showCashierView();
    }
}
