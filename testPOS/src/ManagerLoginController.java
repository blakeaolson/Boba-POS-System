import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class ManagerLoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text messageText;

    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("manager")) {
            // Successful login, load the dashboard
            // messageText.setText("");
            loadDashboard();
        } else if (username.equals("cashier")) {
            loadCashier();
        } else {
            messageText.setText("Invalid username or password");
        }
    }

    private void loadDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerDashboard.fxml"));
            usernameField.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCashier() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
