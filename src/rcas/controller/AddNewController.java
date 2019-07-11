package rcas.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
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

public class AddNewController {
    private Stage primaryStage;

    @FXML
    private JFXSlider sliderRLCWeight;

    @FXML
    private JFXSlider sliderFLCWeight;

    @FXML
    private JFXSlider sliderFRCWeight;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAddCar;

    @FXML
    private JFXTextField fldCarName;

    @FXML
    private JFXSlider sliderRRCWeight;

    @FXML
    private JFXButton btnMore;

    @FXML
    public void OnClickedAddCar(ActionEvent event) throws IOException {
        if(Variables.NCarName == "NewCar"){
            System.out.println("Name wurde nicht abgefüllt");
        }
        else{
            Variables.scene = setScene("/view/SelectCar.fxml");
            System.out.println("Changed to \"SelectCar\"-view");
        }
    }

    @FXML
    public void OnFLCWChanged() {
        Variables.NCornerWeightFL = sliderFLCWeight.getValue();
    }
    @FXML
    public void OnRLCWChanged() {
        Variables.NCornerWeightRL = sliderRLCWeight.getValue();
    }
    @FXML
    public void OnRRCWChanged() {
        Variables.NCornerWeightRR = sliderRRCWeight.getValue();
    }
    @FXML
    public void OnFRCWChanged() {
        Variables.NCornerWeightFR = sliderFRCWeight.getValue();
    }

    @FXML
    public void OnNameChanged(){
        Variables.NCarName = fldCarName.getText();
    }

    @FXML
    void OnClickedMore(ActionEvent event) throws IOException {
        Variables.scene = setScene("/view/AddMoreDetails.fxml");
        System.out.println("Changed to \"AddMoreDetails\"-view");
    }

    @FXML
    public void OnClickedCancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("You pressed the \"Cancel\" button");
        alert.setContentText("Are you sure you want to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Variables.scene = setScene("/view/SelectCar.fxml");
            System.out.println("Changed to \"Select\"-view");
        }
    }

    private Scene setScene(String s) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource(s));
        Scene scene = new Scene(root, 1300, 600);
        this.primaryStage = Variables.primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }
}
