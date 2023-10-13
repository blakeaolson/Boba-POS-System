import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagerDashboardController {
    @FXML
    private TextField addInventoryID;
    @FXML
    private TextField addInventoryQuantity;
    @FXML
    private TextField addInventoryCategory;

    @FXML
    private Button logoutButton;

    @FXML
    private Button addInventoryButton;

    @FXML
    private Button addInventory;

    @FXML
    private TableView<InventoryData> InventoryTable;
    @FXML
    private TableView<EmployeeData> EmployeeTable;
    @FXML
    private TableView<Orders> OrderTable;

    @FXML
    private TableColumn<InventoryData, String> itemid;
    @FXML
    private TableColumn<InventoryData, String> quantity;
    @FXML    
    private TableColumn<InventoryData, String> itemcategory;

    @FXML
    private TableColumn<EmployeeData, String> id;
    @FXML
    private TableColumn<EmployeeData, String> employeename;
    @FXML    
    private TableColumn<EmployeeData, String> salary;
    @FXML    
    private TableColumn<EmployeeData, String> employeerole;

    @FXML
    private TableColumn<Orders, String> orderid;
    @FXML
    private TableColumn<Orders, String> totalamount;
    @FXML    
    private TableColumn<Orders, String> orderdate;
    @FXML    
    private TableColumn<Orders, String> orderhour;
    @FXML    
    private TableColumn<Orders, String> cashiername;
    @FXML    
    private TableColumn<Orders, String> paymentmethod;


    @FXML
    private void initialize() {
        // This method is invoked when the FXML components are initialized.
        loadInventoryData();
        loadEmployees();
        loadOrders();
    }

    @FXML
    private void reloadData() {
        // This method is invoked when the FXML components are initialized.
        loadInventoryData();
        loadEmployees();
    }

    @FXML
    public void logout() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerLogin.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 460, 354));

            // Close the current dashboard stage
            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadInventoryForm() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/AddInventory.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Add Inventory");
            stage.setScene(new Scene(root, 460, 354));

            // Close the current dashboard stage
            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();

            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void ordersButtonClicked() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerOrders.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Orders");
            newStage.setScene(new Scene(root, 460, 354));
            newStage.setMaximized(true);
            newStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void employeesButtonClicked() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerEmployees.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Employees");
            newStage.setScene(new Scene(root, 460, 354));
            newStage.setMaximized(true);
            newStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void inventoryButtonClicked() {
        try {
            //executeQuery("inventory");
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerInventory.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Employees");
            newStage.setScene(new Scene(root, 460, 354));
            newStage.setMaximized(true);
            newStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void revenueButtonClicked() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerRevenue.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Employees");
            newStage.setScene(new Scene(root, 460, 354));
            newStage.setMaximized(true);
            newStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void addInventoryButtonClicked() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/AddInventory.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Add Inventory");
            newStage.setScene(new Scene(root, 460, 354));
            newStage.setMaximized(true);
            newStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addInventoryFinal() {
        String newItem = addInventoryID.getText();
        int newQuantity = Integer.parseInt(addInventoryQuantity.getText());
        String newCategory = addInventoryCategory.getText();
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
            String sql = "INSERT INTO inventory (itemid, quantity, itemcategory) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newItem);
                pstmt.setInt(2, newQuantity);
                pstmt.setString(3, newCategory);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerDashboard.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Dashboard");
            newStage.setScene(new Scene(root, 460, 354));
            newStage.setMaximized(true);
            newStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadInventoryData() {
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
            String sql = "SELECT * FROM inventory;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Create an ObservableList to store the query results
            ObservableList<InventoryData> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String itemid = resultSet.getString("itemid");
                String quantity = resultSet.getString("quantity");
                String category = resultSet.getString("itemcategory");
                data.add(new InventoryData(itemid,quantity,category));
            }

            // Bind the data to the TableView
            itemid.setCellValueFactory(new PropertyValueFactory<>("Itemid"));
            quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            itemcategory.setCellValueFactory(new PropertyValueFactory<>("Itemcategory"));
            InventoryTable.setItems(data);

            // Close the database connection
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadEmployees() {
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
            String sql = "SELECT * FROM employees;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Create an ObservableList to store the query results
            ObservableList<EmployeeData> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String employeename = resultSet.getString("employeename");
                String salary = resultSet.getString("salary");
                String employeerole = resultSet.getString("employeerole");

                data.add(new EmployeeData(id,employeename,salary,employeerole));
            }

            // Bind the data to the TableView
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            employeename.setCellValueFactory(new PropertyValueFactory<>("employeename"));
            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
            employeerole.setCellValueFactory(new PropertyValueFactory<>("employeerole"));

            EmployeeTable.setItems(data);

            // Close the database connection
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadOrders() {
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
            String sql = "SELECT * FROM orders;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Create an ObservableList to store the query results
            ObservableList<Orders> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String totalamount = resultSet.getString("totalamount");
                String orderdate = resultSet.getString("orderdate");
                String cashiername = resultSet.getString("cashiername");
                String paymentmethod = resultSet.getString("paymentmethod");
                String orderhour = resultSet.getString("orderhour");


                data.add(new Orders(id,totalamount,orderdate,cashiername,paymentmethod,orderhour));
            }

            // Bind the data to the TableView
            orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
            totalamount.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
            orderdate.setCellValueFactory(new PropertyValueFactory<>("orderdate"));
            cashiername.setCellValueFactory(new PropertyValueFactory<>("cashiername"));
            paymentmethod.setCellValueFactory(new PropertyValueFactory<>("paymentmethod"));
            orderhour.setCellValueFactory(new PropertyValueFactory<>("orderhour"));

            OrderTable.setItems(data);

            // Close the database connection
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
