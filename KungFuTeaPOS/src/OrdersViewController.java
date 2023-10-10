import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

public class OrdersViewController {

    @FXML
    private TableView<Order> tableView;

    @FXML
    private TableColumn<Order, Integer> orderId;   
    
    @FXML
    private TableColumn<Order, String> date;

    @FXML
    private TableColumn<Order, Float> totalAmount;

    @FXML
    private TableColumn<Order, String> cashierName;

    @FXML
    private TableColumn<Order, String> paymentMethod;

    @FXML
    private TableColumn<Order, Integer> hour;

    // Add more TableColumn fields as needed

    public void initialize() {
        // Initialize TableView columns
        orderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        totalAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        cashierName.setCellValueFactory(new PropertyValueFactory<>("cashierName"));
        paymentMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        hour.setCellValueFactory(new PropertyValueFactory<>("hour"));
    }

    public void setData(ObservableList<Order> data) {
        tableView.setItems(data);
    }
}
