import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CashierMainViewController {

    @FXML
    private Button finish_order_button;

    @FXML
    public void checkout() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierCheckout.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("ItemSelection");
            stage.setScene(new Scene(root, 460, 354));
            
            // Close the current dashboard stage
            Stage currentStage = (Stage) finish_order_button.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
