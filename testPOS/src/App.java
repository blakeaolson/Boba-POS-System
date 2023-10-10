import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/ManagerLogin.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 460, 354));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
