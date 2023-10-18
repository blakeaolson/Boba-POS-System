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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import SharedData.MenuItemList;
import SharedData.OrderData;
import SharedData.SharedItemList;

public class CashierCheckoutController {

    @FXML
    AnchorPane Checkout;

    /**
     * Handle the click event of the "Checkout" button.
     * Establish a database connection, create an order, and update inventory.
     * Also, handle UI navigation.
     */
    public void checkoutClicked() {
        // Database connection parameters.
        String jdbcUrl = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_08b_db";
        String username = "csce315_971_kevtom2003";
        String password = "password";

        Connection conn = null;

        try {
            // Attempt to establish a database connection.
            conn = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        // Get the current date and time.
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(dateFormatter);

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(timeFormatter);

        try {
            // Retrieve the list of ordered items and update inventory.
            ArrayList<OrderData> itemList = SharedItemList.getItemList();
            updateInventory(itemList);

            double total = 0;
            HashMap<String, String> priceListString = MenuItemList.getCostMap();
            HashMap<String, Double> priceListDouble = new HashMap<String, Double>();

            // Convert price list values from strings to doubles.
            for (String key : priceListString.keySet()) {
                String stringValue = priceListString.get(key);
                try {
                    double doubleValue = Double.parseDouble(stringValue);
                    priceListDouble.put(key, doubleValue);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing value for key: " + key);
                }
            }

            // Calculate the total cost of the order.
            for (OrderData item : itemList) {
                total += priceListDouble.get(item.getDrinkName());
            }

            // Insert the order and its items into the database.
            String sql = "INSERT INTO orders (TotalAmount, OrderDate, CashierName, PaymentMethod, time) VALUES (?, ?, ?, ?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, total);
                pstmt.setString(2, formattedDate);
                pstmt.setString(3, "Bobby");
                pstmt.setString(4, "Card");
                pstmt.setString(5, formattedTime);
                pstmt.executeUpdate();
            }

            for (OrderData item : itemList) {
                String sql2 = "INSERT INTO orderitems (OrderID, ItemName, Quantity) VALUES (?, ?, ?);";
                try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {
                    pstmt.setInt(1, 1000);
                    pstmt.setString(2, item.getDrinkName());
                    pstmt.setInt(3, 1);
                    pstmt.executeUpdate();
                }
            }

            // Load the MainCashierView.fxml file and navigate to it.
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));
            SharedItemList.clearList();

            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            Stage currentStage = (Stage) Checkout.getScene().getWindow();
            currentStage.close();

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TO-DO: Update the inventory at this point.
    }

    /**
     * Update the inventory based on the ordered items.
     * @param itemList - the list of ordered items.
     */
    private void updateInventory(ArrayList<OrderData> itemList) {
        Connection conn = null;

        // Mapping of drinks to ingredients and supplies they use.
        ArrayList<String> menuItems = MenuItemList.getTotalArray();
        HashMap<String, HashMap<String, Integer>> drinkIngredients = new HashMap<>();
        // Initialize the ingredient requirements for each drink item.
        for (String menuItem : menuItems) {
            drinkIngredients.put(menuItem, new HashMap<>() {{
                put("Ice Cubes", 15);
                put("Lid", 1);
                put("Napkins", 4);
                put("drink holder", 1);
                put("Boba straw", 1);
          }});
        }

        drinkIngredients.put("Green Tea", new HashMap<>() {{
            put("Green Tea Leaves", 1);
            put("Lid", 1);
            put("Napkins",4);
            put("drink holder", 1);
        }});

        drinkIngredients.put("Rosehip Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves", 1); 
            put("Milk", 1);
            put("Rose syrup", 1);
            put("Boba straw", 1);
            put("Lid", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
        }});

        drinkIngredients.put("Coffee Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves", 1); 
            put("Milk", 1);
            put("Boba straw", 1);
            put("Coffee",1);
            put("Lid", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
        }});

        drinkIngredients.put("Taro Milk Tea", new HashMap<>() {{
            put("Green Tea Leaves", 1); 
            put("Milk", 1);
            put("Taro",1);
            put("Boba straw", 1);
            put("Lid", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
        }});


        drinkIngredients.put("Honey Milk Tea", new HashMap<>() {{
            put("Green Tea Leaves", 1); 
            put("Milk", 1);
            put("Honey",1);
            put("Boba straw", 1);
            put("Lid", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
        }});

        drinkIngredients.put("Thai Milk Tea", new HashMap<>() {{
            put("Thai Tea Leaves", 1); 
            put("Coconut Milk", 1);
            put("Boba straw", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
        }});

        drinkIngredients.put("Coconut Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves", 1); 
            put("Coconut Milk", 1);
            put("Boba straw", 1);
            put("Lid", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
        }});

        drinkIngredients.put("Almond Milk Tea", new HashMap<>() {{
            put("Black Tea Leaves", 1); 
            put("Almond Milk", 1);
            put("Boba straw", 1);
            put("Lid", 1);
            put("Ice Cubes", 15);
            put("Napkins",4);
            put("drink holder", 1);
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
                    ingredients.put("Sugar", order.getSweetnessLevel());
                    ingredients.put("Boba",order.getBobaLevel());
                    if(order.getDrinkSize() == 0)
                        ingredients.put("small cup", 1);
                    else if(order.getDrinkSize() == 1)
                        ingredients.put("medium cup", 1);
                    else if(order.getDrinkSize() == 2)
                        ingredients.put("large cup", 1);
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