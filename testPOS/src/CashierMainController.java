import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import SharedData.OrderData;
import SharedData.SharedItemList;
import SharedData.MenuItemList;
import javafx.scene.layout.GridPane;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
    @FXML
    private AnchorPane menuItemPane;

    public void showMenuItems(){
      menuItemPane.getChildren().clear();
      ArrayList<String> menuItemList = MenuItemList.getDisplayList();
      GridPane buttonContainer = new GridPane();

      for (int i = 0; i < menuItemList.size(); i++) {
          Button newButton = new Button(menuItemList.get(i));

          int row = i / 5;
          int col = i % 5;

          newButton.setPrefWidth(150); 
          newButton.setPrefHeight(150); 

          buttonContainer.add(newButton, col, row);

          int index = i;
          newButton.setOnAction(event -> {
            // Load the ManagerLogin.fxml file
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierItemSelection.fxml"));
                Parent root = loader.load();
                CashierItemSelectionController controller = loader.getController();
                
                HashMap<String, String> costMap = MenuItemList.getCostMap();

                controller.setItem(menuItemList.get(index));
                controller.setItemName(menuItemList.get(index));
                controller.setCost(costMap.get(menuItemList.get(index)));

                // Create a new Stage
                Stage stage = new Stage();
                stage.setTitle("Cashier Item Selection");
                stage.setScene(new Scene(root, 460, 354));
                stage.setMaximized(true);
                
                // Close the current stage
                Stage currentStage = (Stage) newButton.getScene().getWindow();
                currentStage.close();
                
                // Show the stage
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
          });
      }
      menuItemPane.getChildren().add(buttonContainer);
    }

    public void fetchMenuItems(){
      // Get menu items
      try {
        // Replace with your PostgreSQL database credentials and connection URL
        String jdbcUrl = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_08b_db";
        String username = "csce315_971_kevtom2003";
        String password = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl,username,password);
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
        // Execute a sample query (replace with your query)
        String sql = "SELECT * FROM teaorders;";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Create an ObservableList to store the query results

        while (resultSet.next()) {
            String tea_name = resultSet.getString("tea_name");
            String cost = resultSet.getString("price");
            MenuItemList.addTotalList(tea_name);
            MenuItemList.addCostMap(tea_name, cost);
        }

        // Close the database connection
        resultSet.close();
        statement.close();
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
      MenuItemList.parseItems();
      this.showMenuItems();
    }

    public void updateScene() {
      ArrayList<OrderData> itemList = SharedItemList.getItemList();
      VBox buttonContainer = new VBox();

      for (int i = 0; i < itemList.size(); i++) {
          OrderData item = itemList.get(i);
          Button newButton = new Button(item.getDrinkName());

          int index = i;
          newButton.setOnAction(event -> {
            // Load the ManagerLogin.fxml file
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CashierModification.fxml"));
                Parent root = loader.load();
                CashierModificationController controller = loader.getController();
                
                controller.setbuttonId(index);
                controller.setItemName(item.getDrinkName());
                
                // Create a new Stage
                Stage stage = new Stage();
                stage.setTitle("Cashier Modification");
                stage.setScene(new Scene(root, 460, 354));
                stage.setMaximized(true);
                
                // Close the current stage
                Stage currentStage = (Stage) newButton.getScene().getWindow();
                currentStage.close();
                
                // Show the stage
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
          });
          buttonContainer.getChildren().add(newButton);
      }
      String totalCost = "Total Cost: " + SharedItemList.getTotalCost();
      Text newText = new Text(totalCost);
      buttonContainer.getChildren().add(newText);
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

            MenuItemList.clearLists();

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

    public void displayClassic(){
      MenuItemList.changeDisplay("classic");
      this.showMenuItems();
    }
    public void displayMilkTea(){
      MenuItemList.changeDisplay("milktea");
      this.showMenuItems();
    }
    public void displaySeasonal(){
      MenuItemList.changeDisplay("seasonal");
      this.showMenuItems();
    }
    public void displaySlush(){
      MenuItemList.changeDisplay("slush");
      this.showMenuItems();
    }
}