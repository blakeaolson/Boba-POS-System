
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        try {
            FXMLLoader loader = Main.showOrderView();
            // Get the controller for the results page
            OrdersViewController resultsController = loader.getController();

            // Fetch data from the database using DatabaseHelper
            ObservableList<Order> data = DataBaseHelper.getOrders();

            // Pass the data to the results page controller
            resultsController.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


