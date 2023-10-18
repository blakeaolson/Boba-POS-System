import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import java.util.Scanner;
import SharedData.SharedItemList;

public class CashierItemSelectionController {

    @FXML
    private ImageView BobaItem = new ImageView();

    @FXML
    private TextField currItemText;

    @FXML
    private TextField sweetnessLevelText;

    @FXML
    private TextField bobaLevelText;

    @FXML
    private TextField drinkSizeText;

    @FXML
    private Button NoSugar = new Button();

    @FXML
    private Button QuarterSugar = new Button();

    @FXML
    private Button HalfSugar = new Button();

    @FXML
    private Button SeventyFiveSugar = new Button();

    @FXML
    private Button NoBoba = new Button();

    @FXML
    private Button LessBoba = new Button();

    @FXML
    private Button RegularBoba = new Button();

    @FXML
    private Button ExtraBoba = new Button();

    @FXML
    private Button SmallSize = new Button();

    @FXML
    private Button MediumSize = new Button();

    @FXML
    private Button LargeSize = new Button();

    @FXML
    private TextArea ExtraRequest;

    @FXML
    private Button Cancel = new Button();

    @FXML
    private Button AddToOrder = new Button();

    private String item;
    private String cost = "";
    private int sweetness = 0;
    private int bobaLevel = 0;
    private int drinkSize = 0;

    // Sweetness and boba level will be on a scale of 0-3.
    // 0 = no sugar/no boba
    // 1 = 25% sugar/less boba
    // 2 = 50% sugar/regular boba
    // 3 = 75% sugar/extra boba
    // Drink size will be on a scale of 0-2.
    // 0 = small
    // 1 = medium
    // 2 = large
    String extraRequestString = "";
    Scanner scan = new Scanner(System.in);

    /**
     * Initialize the controller, setting initial text in the UI fields.
     */
    public void initialize() {
        currItemText.setText("Item: ");
        sweetnessLevelText.setText("Sweetness Level: ");
        bobaLevelText.setText("Boba Level: ");
        drinkSizeText.setText("Drink Size: ");
    }

    // Methods to set sweetness level based on button clicks.
    public void NoSugarClicked() {
        sweetnessLevelText.setText("Sweetness Level: No Sugar");
        sweetness = 0;
    }

    public void QuarterSugarClicked() {
        sweetnessLevelText.setText("Sweetness Level: 25% Sugar");
        sweetness = 1;
    }

    public void HalfSugarClicked() {
        sweetnessLevelText.setText("Sweetness Level: 50% Sugar");
        sweetness = 2;
    }

    public void SeventyFiveSugarClicked() {
        sweetnessLevelText.setText("Sweetness Level: 75% Sugar");
        sweetness = 3;
    }

    // Methods to set boba level based on button clicks.
    public void NoBobaClicked() {
        bobaLevelText.setText("Boba Level: No Boba");
        bobaLevel = 0;
    }

    public void LessBobaClicked() {
        bobaLevelText.setText("Boba Level: Less Boba");
        bobaLevel = 1;
    }

    public void RegularBobaClicked() {
        bobaLevelText.setText("Boba Level: Regular Boba");
        bobaLevel = 2;
    }

    public void ExtraBobaClicked() {
        bobaLevelText.setText("Boba Level: Extra Boba");
        bobaLevel = 3;
    }

    // Methods to set drink size based on button clicks.
    public void SmallClicked() {
        drinkSizeText.setText("Drink Size: Small");
        drinkSize = 0;
    }

    public void MediumClicked() {
        drinkSizeText.setText("Drink Size: Medium");
        drinkSize = 1;
    }

    public void LargeClicked() {
        drinkSizeText.setText("Drink Size: Large");
        drinkSize = 2;
    }

    /**
     * Handle the user's extra request and update the UI accordingly.
     */
    public void ExtraRequestClicked() {
        System.out.println("Please enter the extra request: ");
        extraRequestString += scan.nextLine();
        scan.close();
        ExtraRequest.setText(extraRequestString);
    }

    /**
     * Set the item name for the current order.
     * @param s - the name of the item to set.
     */
    public void setItemName(String s) {
        currItemText.setText(s);
    }

    /**
     * Set the selected item for the order.
     * @param s - the selected item.
     */
    public void setItem(String s) {
        item = s;
    }

    /**
     * Set the cost of the selected item.
     * @param cost - the cost to set.
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * Handle the "Cancel" button click, navigate back to the main cashier view.
     */
    public void CancelClicked() {
        try {
            // Load the MainCashierView.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/MainCashierView.fxml"));
            Parent root = loader.load();

            CashierMainController controller = loader.getController();
            controller.updateScene();
            controller.showMenuItems();

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current stage
            Stage currentStage = (Stage) Cancel.getScene().getWindow();
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle the "Add to Order" button click, add the drink with specifications to the current order.
     */
    public void AddToOrderClicked() {
        try {
            // Load the .fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/MainCashierView.fxml"));
            Parent root = loader.load();

            SharedItemList.addItem(item, sweetness, bobaLevel, drinkSize, cost);

            CashierMainController controller = loader.getController();
            controller.updateScene();
            controller.showMenuItems();

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current stage
            Stage currentStage = (Stage) AddToOrder.getScene().getWindow();
            currentStage.close();

            // Show the stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}