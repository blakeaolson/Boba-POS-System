import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import java.util.Scanner;
public class CashierModificationController {

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
    int sweetness = 0;
    int bobaLevel = 0;
    int drinkSize = 0;
    String extraRequestString = "";
    Scanner scan = new Scanner(System.in);

    public void initialize(String drink){
        currItemText.setText("Item: " + drink);
        sweetnessLevelText.setText("Sweetness Level: ");
        bobaLevelText.setText("Boba Level: ");
        drinkSizeText.setText("Drink Size: ");
        Image BobaItemPic = new Image("stockBoba.jpg");
        BobaItem.setImage(BobaItemPic);
    }
    
    public void NoSugarClicked(){
        sweetnessLevelText.setText("Sweetness Level: No Sugar");
        sweetness = 0;
    }

    public void QuarterSugarClicked(){
        sweetnessLevelText.setText("Sweetness Level: 25% Sugar");
        sweetness = 1;
    }
    
    public void HalfSugarClicked(){
        sweetnessLevelText.setText("Sweetness Level: 50% Sugar");
        sweetness = 2;
    }

    public void SeventyFiveSugarClicked(){
        sweetnessLevelText.setText("Sweetness Level: 75% Sugar");
        sweetness = 3;
    }

    public void NoBobaClicked(){
        bobaLevelText.setText("Boba Level: No Boba");
        bobaLevel = 0;
    }
    
    public void LessBobaClicked(){
        bobaLevelText.setText("Boba Level: Less Boba");
        bobaLevel = 1;
    }

    public void RegularBobaClicked(){
        bobaLevelText.setText("Boba Level: Regular Boba");
        bobaLevel = 2;
    }

    public void ExtraBobaClicked(){
        bobaLevelText.setText("Boba Level: Extra Boba");
        bobaLevel = 3;
    }

    public void smallClicked(){
        drinkSizeText.setText("Drink Size: Small");
        drinkSize = 0;
    }

    public void MediumClicked(){
        drinkSizeText.setText("Drink Size: Medium");
        drinkSize = 1;
    }

    public void LargeClicked(){
        drinkSizeText.setText("Drink Size: Large");
        drinkSize = 2;
    }

    public void ExtraRequestClicked(){
        System.out.println("Please enter the extra request: ");
        extraRequestString = scan.nextLine();
        ExtraRequest.setText(extraRequestString);
    }

    public void RemoveFromOrderClicked(){
        //TO-DO
        //take drink out from order
        //go back to the order page
    }

    public void CancelModClicked(){
        //TO-DO
        //go back to the order page
    }

    public void ModifyClicked(){
        //TO-DO
        //go back to order page with updated drink order
    }

}
