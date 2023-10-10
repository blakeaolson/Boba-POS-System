import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Parent;
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

        if (username.equals("bob") && password.equals("password")) {
            // Successful login, load the dashboard
            // messageText.setText("");
            loadDashboard();
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
}
