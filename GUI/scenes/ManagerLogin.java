import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ManagerLogin {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    // Add event handler for the loginButton to perform authentication
    // You'll implement this method to authenticate the user against your database

    public void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Add your authentication logic here
        // If authentication is successful, navigate to the ManagerDashboard
    }
}





