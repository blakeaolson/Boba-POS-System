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

    //allows user to login to cashier or manager side based on username input
    public void login() {
        String username = usernameField.getText();
        // String password = passwordField.getText();

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

    //loads the manager side's initial dashboard
    private void loadDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerDashboard.fxml"));
            usernameField.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //loads the cahsier side's initial dashboard
    private void loadCashier() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/MainCashierView.fxml"));
            Parent root = loader.load();
            CashierMainController controller = loader.getController();
            controller.fetchMenuItems();
            

            usernameField.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
