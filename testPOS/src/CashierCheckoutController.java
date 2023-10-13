import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import SharedData.OrderData;
import SharedData.SharedItemList;

public class CashierCheckoutController {

    @FXML
    AnchorPane Checkout;

    public void checkoutClicked(){  
        try {
            ArrayList<OrderData> itemList = SharedItemList.getItemList();
            updateInventory(itemList);
            double total=0;
            HashMap<String, Double> priceList = new HashMap<String,Double>();
            priceList.put("Green Tea",4.75);
            priceList.put("Rosehip Milk Tea",5.35);
            priceList.put("Coffee Milk Tea", 3.80);
            priceList.put("Taro Milk Tea",4.75);
            priceList.put("Honey Milk Tea",5.35);
            priceList.put("Thai Milk Tea", 3.80);
            priceList.put("Coconut Milk Tea",4.75);
            priceList.put("Almond Milk Tea",5.35);
                
            for(OrderData item : itemList){
                total+= priceList.get(item.getDrinkName());
            }
            try {
                // Replace with your PostgreSQL database credentials and connection URL
                String jdbcUrl = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_08b_db";
                String username = "csce315_971_kevtom2003";
                String password = "password";
                Connection conn = null;
                try {
                    //Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection(jdbcUrl,username,password);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName()+": "+e.getMessage());
                    System.exit(0);
                }
                // Execute a sample query (replace with your query)
                String sql = "INSERT INTO orders (id, totalamount, orderdate, cashiername, paymentmethod, orderhour) VALUES (?, ?, ?, ?, ?, ?);";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, 1000);
                    pstmt.setString(2, Double.toString(total));
                    pstmt.setString(3, "10/13/2023");
                    pstmt.setString(4, "Bobby");
                    pstmt.setString(5, "Card");
                    pstmt.setInt(6, 11);
                    pstmt.executeUpdate();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));
            SharedItemList.clearList();

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) Checkout.getScene().getWindow();
            currentStage.close();
            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TO-DO
        //update the inventory at this point
    }
    private void updateInventory(ArrayList<OrderData> itemList) {
        Connection conn = null;
        
        // Mapping of drinks to ingredients and supplies they use
        HashMap<String, HashMap<String, Integer>> drinkIngredients = new HashMap<>();

        drinkIngredients.put("Green Tea", new HashMap<>() {{
            put("Green Tea Leaves Boxes", 1);
            put("water cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});

        drinkIngredients.put("Rosehip Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});

        drinkIngredients.put("Coffee Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});

        drinkIngredients.put("Taro Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});


        drinkIngredients.put("Honey Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});

        drinkIngredients.put("Thai Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Coconut Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
        }});

        drinkIngredients.put("Coconut Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Coconut Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});

        drinkIngredients.put("Almond Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves Boxes", 1); 
            put("Almond Milk", 1);
            put("medium cup", 1);
            put("Boba straw", 1);
            put("lid", 1);
        }});

        try {
            // Establish database connection
            String jdbcUrl = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_08b_db";
            String username = "csce315_971_kevtom2003";
            String password = "password";
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Deduct the inventory based on orders
            for (OrderData order : itemList) {
                if (drinkIngredients.containsKey(order.getDrinkName())) {
                    HashMap<String, Integer> ingredients = drinkIngredients.get(order.getDrinkName());
                    
                    for (String ingredient : ingredients.keySet()) {
                        // Fetch current inventory
                        String query = "SELECT quantity FROM inventory WHERE itemid = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                            pstmt.setString(1, ingredient);
                            ResultSet rs = pstmt.executeQuery();
                            if (rs.next()) {
                                int currentQuantity = rs.getInt("quantity");
                                // Deduct the quantity based on the order
                                currentQuantity -= ingredients.get(ingredient);

                                // Update the inventory
                                String updateQuery = "UPDATE inventory SET quantity = ? WHERE itemid = ?";
                                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                                    updateStmt.setInt(1, currentQuantity);
                                    updateStmt.setString(2, ingredient);
                                    updateStmt.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}