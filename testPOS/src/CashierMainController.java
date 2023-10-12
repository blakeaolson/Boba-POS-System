import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import SharedData.OrderData;
import SharedData.SharedItemList;

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
    @FXML
    private AnchorPane orderPane;

    public void updateScene() {
      ArrayList<OrderData> itemList = SharedItemList.getItemList();
      VBox buttonContainer = new VBox();

      for (OrderData item : itemList) {
          Button newButton = new Button(item.getDrinkName());
          buttonContainer.getChildren().add(newButton);
      }
      orderPane.getChildren().add(buttonContainer);
    }
    
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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Green Tea");

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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Rosehip Milk Tea");

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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Coffee Milk Tea");

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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Taro Milk Tea");

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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Honey Milk Tea");

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
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Thai Milk Tea");

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Coconut Milk Tea");

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
            Parent root = loader.load();
            CashierItemSelectionController controller = loader.getController();

            controller.setItem("Almond Milk Tea");

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