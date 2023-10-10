import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBaseHelper {

    private static final String DB_URL = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_08b_db";
    private static final String DB_USER = "csce315_971_kevtom2003";
    private static final String DB_PASSWORD = "password"; // Replace with your actual password

    public static ObservableList<Order> getOrders() {
        ObservableList<Order> orders = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM orders";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                float total = resultSet.getFloat("totalamount");
                String date = resultSet.getString("orderdate");
                String cashierName = resultSet.getString("cashiername");
                String paymentMethod = resultSet.getString("paymentmethod");
                int hour = resultSet.getInt("orderhour");

                // Create an Order object and add it to the ObservableList
                Order order = new Order(orderId, total, date, cashierName, paymentMethod, hour);
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

}

    