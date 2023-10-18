import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    
    /** 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ManagerLogin.fxml"));
        primaryStage.setTitle("Manager Login");
        primaryStage.setScene(new Scene(root, 460, 354));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
