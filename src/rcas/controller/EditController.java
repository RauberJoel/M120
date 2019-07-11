package rcas.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rcas.util.Variables;

import java.io.IOException;

public class EditController {
    private Stage primaryStage;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabCar;

    @FXML
    private Tab tabProperties;

    @FXML
    private Tab tabEdit;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXSlider sliderFTWidth;

    @FXML
    private JFXSlider sliderRRCWeight;

    @FXML
    private JFXSlider sliderFRCWeight;

    @FXML
    private JFXSlider sliderWheelbase;

    @FXML
    private JFXSlider sliderCogHeight;

    @FXML
    private JFXSlider sliderRTWidth;

    @FXML
    private JFXSlider sliderRLCWeight;

    @FXML
    private JFXSlider sliderFLCWeight;

    @FXML
    private JFXSlider sliderFRDist;

    @FXML
    public void OnClickedBack(ActionEvent event) throws IOException {
        Variables.scene = setScene("/view/SelectCar.fxml");
        System.out.println("Changed to \"SelectCar\"-View");
    }

    private Scene setScene(String strPath) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource(strPath));
        Scene scene = new Scene(root, 1300, 600);
        this.primaryStage = Variables.primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }

    public void initialize() {
        tabPane.setSelectionModel(Variables.selectionModel);

        switch (Variables.selectedCar) {
            case "Lambo":
                sliderFTWidth.setValue(Variables.LFrontTrack);
                sliderRRCWeight.setValue(Variables.LCornerWeightRR);
                sliderFRCWeight.setValue(Variables.LCornerWeightFR);
                sliderWheelbase.setValue(Variables.LWheelbase);
                sliderCogHeight.setValue(Variables.LCogHeight);
                sliderRTWidth.setValue(Variables.LRearTrack);
                sliderRLCWeight.setValue(Variables.LCornerWeightRL);
                sliderFLCWeight.setValue(Variables.LCornerWeightFL);
                sliderFRDist.setValue(Variables.LFrontRollDist);
                break;

            case "AudiR8":
                sliderFTWidth.setValue(Variables.AFrontTrack);
                sliderRRCWeight.setValue(Variables.ACornerWeightRR);
                sliderFRCWeight.setValue(Variables.ACornerWeightFR);
                sliderWheelbase.setValue(Variables.AWheelbase);
                sliderCogHeight.setValue(Variables.ACogHeight);
                sliderRTWidth.setValue(Variables.ARearTrack);
                sliderRLCWeight.setValue(Variables.ACornerWeightRL);
                sliderFLCWeight.setValue(Variables.ACornerWeightFL);
                sliderFRDist.setValue(Variables.AFrontRollDist);
                break;

            case "New":
                sliderFTWidth.setValue(Variables.NFrontTrack);
                sliderRRCWeight.setValue(Variables.NCornerWeightRR);
                sliderFRCWeight.setValue(Variables.NCornerWeightFR);
                sliderWheelbase.setValue(Variables.NWheelbase);
                sliderCogHeight.setValue(Variables.NCogHeight);
                sliderRTWidth.setValue(Variables.NRearTrack);
                sliderRLCWeight.setValue(Variables.NCornerWeightRL);
                sliderFLCWeight.setValue(Variables.NCornerWeightFL);
                sliderFRDist.setValue(Variables.NFrontRollDist);
        }
    }

    @FXML
    public void OnCogChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LCogHeight = sliderCogHeight.getValue();
                break;
            case "AudiR8":
                Variables.ACogHeight = sliderCogHeight.getValue();
                break;
            case "New":
                Variables.NCogHeight = sliderCogHeight.getValue();
            }
    }

    @FXML
    public void OnFLCWChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LCornerWeightFL = sliderFLCWeight.getValue();
                break;
            case "AudiR8":
                Variables.ACornerWeightFL = sliderFLCWeight.getValue();
                break;
            case "New":
                Variables.NCornerWeightFL = sliderFLCWeight.getValue();
        }
    }

    @FXML
    public void OnFRCWChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LCornerWeightFR = sliderFRCWeight.getValue();
                break;
            case "AudiR8":
                Variables.ACornerWeightFR = sliderFRCWeight.getValue();
                break;
            case "New":
                Variables.NCornerWeightFR = sliderFRCWeight.getValue();
        }
    }

    @FXML
    public void OnFRDChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LFrontRollDist = sliderFRDist.getValue();
                break;
            case "AudiR8":
                Variables.AFrontRollDist = sliderFRDist.getValue();
                break;
            case "New":
                Variables.NFrontRollDist = sliderFRDist.getValue();
        }
    }

    @FXML
    public void OnFTWChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LFrontTrack = sliderFTWidth.getValue();
                break;
            case "AudiR8":
                Variables.AFrontTrack = sliderFTWidth.getValue();
                break;
            case "New":
                Variables.NFrontTrack = sliderFTWidth.getValue();
        }
    }

    @FXML
    public void OnRLCWChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LCornerWeightRL = sliderRLCWeight.getValue();
                break;
            case "AudiR8":
                Variables.ACornerWeightRL = sliderRLCWeight.getValue();
                break;
            case "New":
                Variables.NCornerWeightRL = sliderRLCWeight.getValue();
        }
    }

    @FXML
    public void OnRRCWChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LCornerWeightRR = sliderRRCWeight.getValue();
                break;
            case "AudiR8":
                Variables.ACornerWeightRR = sliderRRCWeight.getValue();
                break;
            case "New":
                Variables.NCornerWeightRR = sliderRRCWeight.getValue();
        }
    }

    @FXML
    public void OnRTWChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LRearTrack = sliderRTWidth.getValue();
                break;
            case "AudiR8":
                Variables.ARearTrack = sliderRTWidth.getValue();
                break;
            case "New":
                Variables.NRearTrack = sliderRTWidth.getValue();
        }
    }

    @FXML
    public void OnWheelbaseChanged() {
        switch (Variables.selectedCar) {
            case "Lambo":
                Variables.LWheelbase = sliderWheelbase.getValue();
                break;
            case "AudiR8":
                Variables.AWheelbase = sliderWheelbase.getValue();
                break;
            case "New":
                Variables.NWheelbase = sliderWheelbase.getValue();
        }
    }
}
