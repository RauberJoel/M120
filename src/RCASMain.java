import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rcas.util.Variables;

import java.util.ResourceBundle;

public class RCASMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(RCASMain.class.getResource("view/index.fxml"));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("RCASResources");
        fxmlLoader.setResources(resourceBundle);


        Scene mainScene = new Scene(fxmlLoader.load(), 1300, 600);
        primaryStage.centerOnScreen();
        primaryStage.setTitle(resourceBundle.getString("applicationTitle"));
        primaryStage.setScene(mainScene);
        primaryStage.show();


        Variables.primaryStage = primaryStage;
        Variables.scene = mainScene;
    }

    public static void main(String[] args) {
        Application.launch(RCASMain.class, args);
    }
}
