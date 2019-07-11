package rcas.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rcas.util.Variables;

import java.io.IOException;
import java.util.Optional;

public class AddMoreDetailsController {
    private Stage primaryStage;

    @FXML
    private JFXSlider sliderWheelbase;

    @FXML
    private JFXSlider sliderCogHeight;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXSlider sliderFTWidth;

    @FXML
    private JFXSlider sliderFRDist;

    @FXML
    private JFXSlider sliderRTWidth;

    @FXML
    public void OnClickedCancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("You pressed the \"Cancel\" button");
        alert.setContentText("Are you sure you want to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Variables.scene = setScene("/view/AddCar.fxml");
            System.out.println("Changed to \"Select\"-view");
        }
    }

    @FXML
    public void OnClickedSave(ActionEvent event) throws IOException {
        Variables.scene = setScene("/view/AddCar.fxml");
    }

    private Scene setScene(String s) throws IOException{
        Pane root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root, 1300, 600);
        this.primaryStage = Variables.primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }

    @FXML
    public void OnCogChanged() {
        Variables.NCogHeight = sliderCogHeight.getValue();
    }


    @FXML
    public void OnFRDChanged() {
        Variables.NFrontRollDist = sliderFRDist.getValue();
    }

    @FXML
    public void OnFTWChanged() {
        Variables.NFrontTrack = sliderFTWidth.getValue();
    }

    @FXML
    public void OnRTWChanged() {
        Variables.NRearTrack = sliderRTWidth.getValue();
    }

    @FXML
    public void OnWheelbaseChanged() {
        Variables.NWheelbase = sliderWheelbase.getValue();
    }
}
