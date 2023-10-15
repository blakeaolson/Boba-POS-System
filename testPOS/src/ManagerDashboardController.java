import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerDashboardController {
    @FXML
    private TextField addInventoryID;
    @FXML
    private TextField addInventoryQuantity;
    @FXML
    private TextField addInventoryCategory;
    @FXML
    private TextField addInventoryMinimum;
    @FXML
    private TextArea itemsNeeded = new TextArea("");
    
    @FXML
    private TextField addMenuID;
    @FXML
    private TextField addMenuName;
    @FXML
    private TextField addMenuCost;

    @FXML
    private Button logoutButton = new Button();

    @FXML
    private Button addInventoryButton = new Button();
     @FXML
    private Button subInventoryButton = new Button();
    @FXML
    private Button subInventory = new Button();
    @FXML
    private TextField subInventoryID;
    @FXML
    private TextField editMenuID;
    @FXML
    private TextField editMenuName;
    @FXML
    private TextField editMenuCost;
    @FXML
    private TextField subMenuID;
     @FXML
    private Button editInventoryButton = new Button();
    @FXML
    private Button editInventory = new Button();
    @FXML
    private TextField editInventoryID;
    @FXML
    private TextField editInventoryQuantity;
    @FXML
    private TextField editInventoryCategory;
    @FXML
    private TextField editInventoryMinimum;

    @FXML
    private Button addInventory = new Button();

    @FXML
    private TableView<InventoryData> InventoryTable = new TableView<>();
    @FXML
    private TableView<EmployeeData> EmployeeTable = new TableView<>();
    @FXML
    private TableView<MenuData> MenuTable = new TableView<>();

    @FXML
    private TableColumn<MenuData, String> menuid = new TableColumn<>("Menu ID");
    @FXML
    private TableColumn<MenuData, String> menuName = new TableColumn<>("Menu Name");
    @FXML    
    private TableColumn<MenuData, String> itemcost = new TableColumn<>("Item Cost");

    @FXML
    private TableColumn<InventoryData, String> itemid = new TableColumn<>("Item ID");
    @FXML
    private TableColumn<InventoryData, String> quantity = new TableColumn<>("Quantity");
    @FXML    
    private TableColumn<InventoryData, String> itemcategory = new TableColumn<>("Item Category");
    @FXML    
    private TableColumn<InventoryData, String> minimum = new TableColumn<>("Minimum Allowed");

    @FXML
    private TableColumn<EmployeeData, String> id = new TableColumn<>("ID");
    @FXML
    private TableColumn<EmployeeData, String> employeename = new TableColumn<>("Employee Name");
    @FXML    
    private TableColumn<EmployeeData, String> salary = new TableColumn<>("Salary");
    @FXML    
    private TableColumn<EmployeeData, String> employeerole = new TableColumn<>("Employee Role");
    @FXML
    private Button menuButton = new Button(); 
    @FXML
    private Button addMenuButton = new Button(); 
    @FXML
    private Button subMenuButton = new Button(); 
    @FXML
    private Button editMenu = new Button(); 
    @FXML
    private TableView<Orders> OrderTable = new TableView<>();
    @FXML
    private TableColumn<Orders, String> orderid = new TableColumn<>("Order ID");
    @FXML
    private TableColumn<Orders, String> totalamount = new TableColumn<>("Total Amount");
    @FXML    
    private TableColumn<Orders, String> orderdate = new TableColumn<>("Order Date");
    @FXML    
    private TableColumn<Orders, String> time = new TableColumn<>("Order Time");
    @FXML    
    private TableColumn<Orders, String> cashiername = new TableColumn<>("Cashier Name");
    @FXML    
    private TableColumn<Orders, String> paymentmethod = new TableColumn<>("Payment Method");

    @FXML
    private TextField startTimeField;
    @FXML
    private TextField endTimeField;
    @FXML
    private TableView<PairData> pairTable = new TableView<>();
    @FXML
    private TableColumn<PairData, String> item1 = new TableColumn<>("Item 1");
    @FXML
    private TableColumn<PairData, String> item2 = new TableColumn<>("Item 2");
    @FXML
    private TableColumn<PairData, Integer> frequency = new TableColumn<>("Frequency");


    @FXML
    private void initialize() {
        // This method is invoked when the FXML components are initialized.
        loadInventoryData();
        loadEmployees();
        loadMenu();
        loadOrders();
    }

    @FXML
    private void reloadData() {
        // This method is invoked when the FXML components are initialized.
        loadInventoryData();
        loadEmployees();
        loadMenu();
        loadOrders();
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

    @FXML
    public void loadInventoryForm() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/AddInventory.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Add Inventory");
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
    
    @FXML
    public void loadInventoryForm2() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/SubInventory.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Subtract Inventory");
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
    public void loadInventoryForm3() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/EditInventory.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Edit Inventory");
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
    public void loadMenuForm() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/AddMenu.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Add to Menu");
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
    public void loadMenuForm2() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/subtractMenuItem.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("take out of Menu");
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
    public void loadMenuForm3() {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/editMenuItem.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Edit The Menu");
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
            newStage.setTitle("Manager Inventory");
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
    private void salesTogetherButtonClicked() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/WhatSalesTogether.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("What Sales Together");
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
            newStage.setTitle("Manager Revenue");
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
    private void menuButtonClicked() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerMenu.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager menu");
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
        int newMin = Integer.parseInt(addInventoryMinimum.getText());
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
            String sql = "INSERT INTO inventory (itemid, quantity, itemcategory, minimumamount) VALUES (?, ?, ?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newItem);
                pstmt.setInt(2, newQuantity);
                pstmt.setString(3, newCategory);
                pstmt.setInt(4, newMin);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerInventory.fxml"));
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
    private void subInventoryFinal() {
        String newItem = subInventoryID.getText();
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
            String sql = "DELETE FROM inventory WHERE itemid = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newItem);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerInventory.fxml"));
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
    private void editInventoryFinal() {
        String newItem = editInventoryID.getText();
        int newQuantity = Integer.parseInt(editInventoryQuantity.getText());
        String newCategory = editInventoryCategory.getText();
        int newMin = Integer.parseInt(editInventoryMinimum.getText());
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
            String sql = "UPDATE inventory SET quantity = ?, itemcategory = ?, minimumamount = ? WHERE itemid = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(4, newItem);
                pstmt.setInt(1, newQuantity);
                pstmt.setString(2, newCategory);
                pstmt.setInt(3, newMin);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerInventory.fxml"));
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
    private void addMenuFinal() {
        int newItem = Integer.parseInt(addMenuID.getText());
        String newName = addMenuName.getText();
        double newCost = Double.parseDouble(addMenuCost.getText());
        //System.out.println(newItem + " " + newName + " " + newCost);
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
            String sql = "INSERT INTO teaorders (id, tea_name, price) VALUES (?, ?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, newItem);
                pstmt.setString(2, newName);
                pstmt.setDouble(3, newCost);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerMenu.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Menu");
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
    private void subMenuFinal() {
        int newItem = Integer.parseInt(subMenuID.getText());
        //System.out.println(newItem);
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
            String sql = "DELETE FROM teaorders WHERE id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, newItem);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerMenu.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Menu");
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
    private void editMenuFinal() {
        int newItem = Integer.parseInt(editMenuID.getText());
        String newName = editMenuName.getText();
        double newCost = Double.parseDouble(editMenuCost.getText());
        //System.out.println(newItem + " " + newName + " " + newCost);
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
            String sql = "UPDATE teaorders SET tea_name = ?, price = ? WHERE id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(3, newItem);
                pstmt.setString(1, newName);
                pstmt.setDouble(2, newCost);
                pstmt.executeUpdate();
            }
            reloadData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerMenu.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Manager Menu");
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
                String min = resultSet.getString("minimumamount");
                //System.out.println(itemid + " " + quantity + " " + category + " " + min);
                data.add(new InventoryData(itemid,quantity,category,min));
                if(Integer.parseInt(quantity) < Integer.parseInt(min)){
                    itemsNeeded.setText(itemsNeeded.getText() + itemid + "\n");
                }
            }

            // Bind the data to the TableView
            itemid.setCellValueFactory(new PropertyValueFactory<>("Itemid"));
            quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            itemcategory.setCellValueFactory(new PropertyValueFactory<>("Itemcategory"));
            minimum.setCellValueFactory(new PropertyValueFactory<>("Minimum"));
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
    private void loadMenu() {
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
            String sql = "SELECT * FROM teaorders;";
            //System.out.println(sql);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Create an ObservableList to store the query results
            ObservableList<MenuData> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String itemid = resultSet.getString("id");
                String name = resultSet.getString("tea_name");
                String cost = resultSet.getString("price");
                //System.out.println(itemid + " " + name + " " + cost);
                data.add(new MenuData(itemid,name,cost));
            }

            // Bind the data to the TableView
            menuid.setCellValueFactory(new PropertyValueFactory<>("itemid"));
            menuName.setCellValueFactory(new PropertyValueFactory<>("name"));
            itemcost.setCellValueFactory(new PropertyValueFactory<>("itemcost"));
            MenuTable.setItems(data);

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
                String totalamount = resultSet.getString("TotalAmount");
                String orderdate = resultSet.getString("OrderDate");
                String cashiername = resultSet.getString("CashierName");
                String paymentmethod = resultSet.getString("PaymentMethod");
                String time = resultSet.getString("time");
                data.add(new Orders(id,totalamount,orderdate,cashiername,paymentmethod,time));
            }


            // Bind the data to the TableView
            orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
            totalamount.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
            orderdate.setCellValueFactory(new PropertyValueFactory<>("orderdate"));
            cashiername.setCellValueFactory(new PropertyValueFactory<>("cashiername"));
            paymentmethod.setCellValueFactory(new PropertyValueFactory<>("paymentmethod"));
            time.setCellValueFactory(new PropertyValueFactory<>("time"));


            OrderTable.setItems(data);


            // Close the database connection
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadPairs() {
        try {
            String jdbcUrl = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_08b_db";
            String username = "csce315_971_kevtom2003";
            String password = "password";

            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();

            String sqlQuery = "SELECT oi1.itemname AS item1, oi2.itemname AS item2, COUNT(*) AS frequency " +
                            "FROM orderitems oi1 " +
                            "JOIN orderitems oi2 ON oi1.orderid = oi2.orderid AND oi1.itemname < oi2.itemname " +
                            "JOIN orders o ON oi1.orderid = o.id " +
                            "WHERE o.time BETWEEN ? AND ? " +
                            "GROUP BY oi1.itemname, oi2.itemname " +
                            "ORDER BY frequency DESC;";

            // Execute the SQL Query and update the table
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, startTime);
            statement.setString(2, endTime);
            ResultSet resultSet = statement.executeQuery();

            ObservableList<PairData> pairData = FXCollections.observableArrayList();

            // System.out.println("Item 1\tItem 2\tFrequency");
            while (resultSet.next()) {
                String item1 = resultSet.getString("item1");
                String item2 = resultSet.getString("item2");
                Integer frequency = resultSet.getInt("frequency");
                // System.out.println(item1 + "\t" + item2 + "\t" + frequency);
                pairData.add(new PairData(item1, item2, frequency));
            }

            item1.setCellValueFactory(new PropertyValueFactory<>("item1"));
            item2.setCellValueFactory(new PropertyValueFactory<>("item2"));
            frequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));

            pairTable.setItems(pairData);

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerOrders.fxml"));
            pairTable.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
