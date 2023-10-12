import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import SharedData.SharedItemList;

public class CashierCheckoutController {

    @FXML
    AnchorPane Checkout;

    public void checkoutClicked(){  
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));
            SharedItemList.clearList();

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) Checkout.getScene().getWindow();
            currentStage.close();
            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TO-DO
        //update the inventory at this point
    }


}