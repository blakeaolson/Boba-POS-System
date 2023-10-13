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
public class CashierModificationController {

    @FXML
    private ImageView BobaItemMod = new ImageView();

    @FXML
    private TextField currItemTextMod;

    @FXML
    private TextField sweetnessLevelTextMod;

    @FXML
    private TextField bobaLevelTextMod;

    @FXML
    private TextField drinkSizeTextMod;

    @FXML
    private Button NoSugarMod = new Button();

    @FXML
    private Button QuarterSugarMod = new Button();

    @FXML
    private Button HalfSugarMod = new Button();

    @FXML
    private Button SeventyFiveSugarMod = new Button();

    @FXML
    private Button NoBobaMod = new Button();

    @FXML
    private Button LessBobaMod = new Button();

    @FXML
    private Button RegularBobaMod = new Button();

    @FXML
    private Button ExtraBobaMod = new Button();

    @FXML
    private Button SmallSizeMod = new Button();

    @FXML
    private Button MediumSizeMod = new Button();

    @FXML
    private Button LargeSizeMod = new Button();

    @FXML
    private TextArea ExtraRequestMod;

    @FXML
    private Button RemoveFromOrder = new Button();

    @FXML
    private Button CancelMod = new Button();

    @FXML
    private Button Modify = new Button();

    //sweetness and boba level will be on scale of 0-3
    //0 = no sugar/no boba
    //1 = 25% sugar/less boba
    //2 = 50% sugar/regular boba
    //3 = 75% sugar/extra boba
    //drink size will be on a scale of 0-2
    //0 = small
    //1 = medium
    //2 = large
    int sweetnessMod = 0;
    int bobaLevelMod = 0;
    int drinkSizeMod = 0;
    String extraRequestStringMod = "";
    Scanner scan = new Scanner(System.in);

    public void initialize(){
        currItemTextMod.setText("Item: ");
        sweetnessLevelTextMod.setText("Sweetness Level: ");
        bobaLevelTextMod.setText("Boba Level: ");
        drinkSizeTextMod.setText("Drink Size: ");
    }

    public void NoSugarClickedMod(){
        sweetnessLevelTextMod.setText("Sweetness Level: No Sugar");
        sweetnessMod = 0;
    }

    public void QuarterSugarClickedMod(){
        sweetnessLevelTextMod.setText("Sweetness Level: 25% Sugar");
        sweetnessMod = 1;
    }

    public void HalfSugarClickedMod(){
        sweetnessLevelTextMod.setText("Sweetness Level: 50% Sugar");
        sweetnessMod = 2;
    }

    public void SeventyFiveSugarClickedMod(){
        sweetnessLevelTextMod.setText("Sweetness Level: 75% Sugar");
        sweetnessMod = 3;
    }

    public void NoBobaClickedMod(){
        bobaLevelTextMod.setText("Boba Level: No Boba");
        bobaLevelMod = 0;
    }

    public void LessBobaClickedMod(){
        bobaLevelTextMod.setText("Boba Level: Less Boba");
        bobaLevelMod = 1;
    }

    public void RegularBobaClickedMod(){
        bobaLevelTextMod.setText("Boba Level: Regular Boba");
        bobaLevelMod = 2;
    }

    public void ExtraBobaClickedMod(){
        bobaLevelTextMod.setText("Boba Level: Extra Boba");
        bobaLevelMod = 3;
    }

    public void SmallClickedMod(){
        drinkSizeTextMod.setText("Drink Size: Small");
        drinkSizeMod = 0;
    }

    public void MediumClickedMod(){
        drinkSizeTextMod.setText("Drink Size: Medium");
        drinkSizeMod = 1;
    }

    public void LargeClickedMod(){
        drinkSizeTextMod.setText("Drink Size: Large");
        drinkSizeMod = 2;
    }

    public void ExtraRequestClickedMod(){
        System.out.println("Please enter the extra request: ");
        extraRequestStringMod += scan.nextLine();
        scan.close();
        ExtraRequestMod.setText(extraRequestStringMod);
    }

    public void RemoveFromOrderClicked(){
        //TO-DO
        //take drink out from order
        //go back to the order page
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) RemoveFromOrder.getScene().getWindow();
            currentStage.close();
            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CancelModClicked(){
        //TO-DO
        //go back to the order page
         try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) CancelMod.getScene().getWindow();
            currentStage.close();
            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ModifyClicked(){
        //TO-DO
        //go back to order page with updated drink order
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainCashierView.fxml"));

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Main Cashier View");
            stage.setScene(new Scene(root, 1244.0, 641.0));
            stage.setMaximized(true);

            // Close the current dashboard stage
            Stage currentStage = (Stage) Modify.getScene().getWindow();
            currentStage.close();
            // Show the login stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}