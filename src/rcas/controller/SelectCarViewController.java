package rcas.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rcas.util.Variables;

import java.io.IOException;
import java.util.Optional;

public class SelectCarViewController {

    private Stage primaryStage;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnNewCar;

    @FXML
    private JFXButton btnAudiR8;

    @FXML
    private JFXButton btnLambo;

    @FXML
    private ImageView imageView;

    @FXML
    public void OnClickedAudiR8(ActionEvent event) throws IOException {
        Variables.selectedCar = "AudiR8";

        Variables.ACarName = "AudiR8";
        Variables.AFrontTrack = 1.6;
        Variables.ARearTrack = 1.6;
        Variables.AWheelbase = 2.6;
        Variables.ACogHeight = 0.5;
        Variables.AFrontRollDist = 0.55;
        Variables.ACornerWeightFR = 420;
        Variables.ACornerWeightFL = 420;
        Variables.ACornerWeightRL = 370;
        Variables.ACornerWeightRR = 370;

        Variables.scene = setScene("/view/Car.fxml");
        System.out.println("Changed to \"Car\"-view");

        Variables.selectedTab = "Car";
    }

    @FXML
    public void initialize(){
        if(Variables.NCarName != ("NewCar")){
            Image image = new Image("images/bugatti.png");
            imageView.setImage(image);
        }
    }

    @FXML
    public void OnClickedLambo(ActionEvent event) throws IOException {
        Variables.selectedCar = "Lambo";

        Variables.LCarName = "Lambo";
        Variables.LFrontTrack = 1.6;
        Variables.LRearTrack = 1.6;
        Variables.LWheelbase = 4.5;
        Variables.LCogHeight = 0.5;
        Variables.LFrontRollDist = 0.8;
        Variables.LCornerWeightFR = 500;
        Variables.LCornerWeightFL = 500;
        Variables.LCornerWeightRL = 500;
        Variables.LCornerWeightRR = 500;

        Variables.scene = setScene("/view/Car.fxml");
        System.out.println("Changed to \"Car\"-view");

        Variables.selectedTab = "Car";
    }

    @FXML
    public void onClickedNewCar(ActionEvent event) throws IOException {
        Variables.selectedCar = "New";

        Variables.NCarName = "NewCar";

        Variables.scene = setScene("/view/AddCar.fxml");
        System.out.println("Changed to \"AddCar\"-View");

        Variables.selectedTab = "Car";
    }

    @FXML
    public void OnClickedLogout(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You pressed the \"Logout\" button");
        alert.setContentText("Are you sure you want to log out?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Variables.scene = setScene("/view/index.fxml");
            System.out.println("Changed to \"index\"-view");
        }
    }

    private Scene setScene(String strPath) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource(strPath));
        Scene scene = new Scene(root, 1300, 600);
        this.primaryStage = Variables.primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }

}

