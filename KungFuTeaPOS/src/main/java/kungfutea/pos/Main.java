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
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/LandingPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
    }

    public static void showManagerDashboard() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/ManagerDashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manager Dashboard");
    }

    public static void showManagerLogin() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/ManagerLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Manager Login");
    }

    public static void showCashierView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/CashierView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cashier Home");
    }

    public static void showEmployeeView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/EmployeeView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Data");
    }

    public static void showOrderView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/OrderView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order Data");
    }

    public static void showInventoryView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/InventoryView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory Data");
    }

    public static void showRevenueView() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/yourpackage/fxml/RevenueView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Revenue Data");
    }

    
}
