import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LandingPage extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Landing Page");

        // Load the landing page (initial GUI)
        loadLandingPage();
    }

    // Method to load the landing page
    private void loadLandingPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
            Parent root = loader.load();
            LandingPage controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to load the Manager Login page
    public void loadManagerLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerLogin.fxml"));
            Parent root = loader.load();
            ManagerLogin controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 400, 300);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to load the Cashier View page
    public void loadCashierView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CashierView.fxml"));
            Parent root = loader.load();
            CashierView controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root, 400, 300);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
