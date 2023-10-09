package main.java.kungfutea.pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        showLoginPage(); // Start with the login page
        primaryStage.show();
    }

    public static void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
    }

    public static void showManagerDashboard() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/manager_dashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manager Dashboard");
    }

    // Add similar methods for other screens
}
