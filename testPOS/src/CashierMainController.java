import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CashierMainController {

    @FXML
    private Button finish_order_button;
    @FXML  
    private Button order_but1;
    @FXML
    private Button order_but2;
    @FXML    
    private Button order_but3;
    @FXML    
    private Button order_but4;
    @FXML    
    private Button order_but5;
    @FXML    
    private Button order_but6;
    @FXML
    private Button order_but7;
    @FXML
    private Button order_but8;
    @FXML
    private Button logoutButton;

    public void checkout() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierCheckout.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Payment");
            stage.setScene(new Scene(root, 600, 400));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) finish_order_button.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerLogin.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 460, 354));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void order_but1Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but1.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void order_but2Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but2.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void order_but3Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but3.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void order_but4Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but4.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void order_but5Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but5.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void order_but6Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but6.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void order_but7Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but7.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void order_but8Clicked(){


         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/CashierItemSelection.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Item Selection");
            stage.setScene(new Scene(root, 898, 628));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) order_but8.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}