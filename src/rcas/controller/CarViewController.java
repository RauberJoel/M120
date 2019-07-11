package rcas.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rcas.model.MagicFormulaTireModel;
import rcas.model.RaceCar;
import rcas.model.TireModel;
import rcas.util.CorneringAnalyserUtil;
import rcas.util.Variables;

import java.io.IOException;

public class CarViewController {
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
    private Text fldFTW;

    @FXML
    private Text fldRTW;

    @FXML
    private Text fldWheelbase;

    @FXML
    private Text fldFRD;

    @FXML
    private Text fldCOG;

    @FXML
    private Text fldFLCW;

    @FXML
    private Text fldFRCW;

    @FXML
    private Text fldRLCW;

    @FXML
    private Text fldRRCW;

    @FXML
    private Text fldName;

    @FXML
    public void initialize(){
        setTextfields();
    }

    @FXML
    public void OnSelectionChanged() throws IOException {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();

        if (tabProperties == selectionModel.getSelectedItem()) {
            Variables.scene = setScene("/view/Propertie.fxml");
            System.out.println("Changed to \"Properties\"-View");

            selectionModel.select(tabProperties);
            Variables.selectedTab = "Properties";
        }

        else if (tabEdit.isSelected()){
            Variables.scene = setScene("/view/Edit.fxml");
            System.out.println("Changed to \"Edit\"-View");

            selectionModel.select(tabEdit);
            Variables.selectedTab = "Edit";
        }

        else{
            selectionModel.select(tabCar);
            Variables.selectedTab = "Car";
        }

        Variables.selectionModel = selectionModel;
    }

    private void setTextfields() {
        switch (Variables.selectedCar){
            case "Lambo":
                fldName.setText(Variables.LCarName);
                fldFTW.setText(fldFTW.getText() + " " + Variables.LFrontTrack + " m");
                fldRTW.setText(fldRTW.getText() + " " + Variables.LRearTrack + " m");
                fldWheelbase.setText(fldWheelbase.getText() + " " + Variables.LWheelbase + " m");
                fldFRD.setText(fldFRD.getText() + " " + Variables.LFrontRollDist + " m");
                fldCOG.setText(fldCOG.getText() + " " + Variables.LCogHeight + " m");
                fldFLCW.setText(fldFLCW.getText() + " " + Variables.LCornerWeightFL + " kg");
                fldFRCW.setText(fldFRCW.getText() + " " + Variables.LCornerWeightFR + " kg");
                fldRLCW.setText(fldRLCW.getText() + " " + Variables.LCornerWeightRL + " kg");
                fldRRCW.setText(fldRRCW.getText() + " " + Variables.LCornerWeightRR + " kg");

                TireModel myTireModel_2_Fr = new MagicFormulaTireModel(1.3, 15.2, -1.6, 1.6, 0.000075);
                TireModel myTireModel_2_Rr = new MagicFormulaTireModel(1.3, 15.2, -1.6, 1.8, 0.000075);

                RaceCar LRaceCar = new RaceCar(Variables.LCornerWeightFL, Variables.LCornerWeightFR, Variables.LCornerWeightRL, Variables.LCornerWeightRR);
                LRaceCar.setName(Variables.LCarName);
                LRaceCar.setFrontAxleTireModel(myTireModel_2_Fr);
                LRaceCar.setRearAxleTireModel(myTireModel_2_Rr);
                LRaceCar.setFrontTrack(Variables.LFrontTrack);
                LRaceCar.setRearTrack(Variables.LRearTrack);
                LRaceCar.setWheelbase(Variables.LWheelbase);
                LRaceCar.setFrontRollDist(Variables.LFrontRollDist);
                LRaceCar.setCogHeight(Variables.LCogHeight);
                Variables.LRaceCar = LRaceCar;
                break;

            case "AudiR8":
                fldName.setText(Variables.ACarName);
                fldFTW.setText(fldFTW.getText() + " " + Variables.AFrontTrack + " m");
                fldRTW.setText(fldRTW.getText() + " " + Variables.ARearTrack + " m");
                fldWheelbase.setText(fldWheelbase.getText() + " " + Variables.AWheelbase + " m");
                fldFRD.setText(fldFRD.getText() + " " + Variables.AFrontRollDist + " m");
                fldCOG.setText(fldCOG.getText() + " " + Variables.ACogHeight + " m");
                fldFLCW.setText(fldFLCW.getText() + " " + Variables.ACornerWeightFL + " kg");
                fldFRCW.setText(fldFRCW.getText() + " " + Variables.ACornerWeightFR + " kg");
                fldRLCW.setText(fldRLCW.getText() + " " + Variables.ACornerWeightRL + " kg");
                fldRRCW.setText(fldRRCW.getText() + " " + Variables.ACornerWeightRR + " kg");

                TireModel myTireModel_3_Fr = new MagicFormulaTireModel(1.3, 15.2, -1.6, 1.6, 0.000075);
                TireModel myTireModel_3_Rr = new MagicFormulaTireModel(1.3, 15.2, -1.6, 1.8, 0.000075);


                RaceCar ARaceCar = new RaceCar(Variables.ACornerWeightFL, Variables.ACornerWeightFR, Variables.ACornerWeightRL, Variables.ACornerWeightRR);
                ARaceCar.setName(Variables.ACarName);
                ARaceCar.setFrontAxleTireModel(myTireModel_3_Fr);
                ARaceCar.setRearAxleTireModel(myTireModel_3_Rr);
                ARaceCar.setFrontTrack(Variables.AFrontTrack);
                ARaceCar.setRearTrack(Variables.ARearTrack);
                ARaceCar.setWheelbase(Variables.AWheelbase);
                ARaceCar.setFrontRollDist(Variables.AFrontRollDist);
                ARaceCar.setCogHeight(Variables.ACogHeight);
                Variables.ARaceCar = ARaceCar;
                break;

            case "NewCar":
                fldName.setText(Variables.NCarName);
                fldFTW.setText(fldFTW.getText() + " " + Variables.NFrontTrack + " m");
                fldRTW.setText(fldRTW.getText() + " " + Variables.NRearTrack + " m");
                fldWheelbase.setText(fldWheelbase.getText() + " " + Variables.NWheelbase + " m");
                fldFRD.setText(fldFRD.getText() + " " + Variables.NFrontRollDist + " m");
                fldCOG.setText(fldCOG.getText() + " " + Variables.NCogHeight + " m");
                fldFLCW.setText(fldFLCW.getText() + " " + Variables.NCornerWeightFL + " kg");
                fldFRCW.setText(fldFRCW.getText() + " " + Variables.NCornerWeightFR + " kg");
                fldRLCW.setText(fldRLCW.getText() + " " + Variables.NCornerWeightRL + " kg");
                fldRRCW.setText(fldRRCW.getText() + " " + Variables.NCornerWeightRR + " kg");

                RaceCar NRaceCar = new RaceCar(Variables.NCornerWeightFL, Variables.NCornerWeightFR, Variables.NCornerWeightRL, Variables.NCornerWeightRR);
                NRaceCar.setName(Variables.NCarName);
                NRaceCar.setFrontTrack(Variables.NFrontTrack);
                NRaceCar.setRearTrack(Variables.NRearTrack);
                NRaceCar.setWheelbase(Variables.NWheelbase);
                NRaceCar.setFrontRollDist(Variables.NFrontRollDist);
                NRaceCar.setCogHeight(Variables.NCogHeight);
                Variables.NRaceCar = NRaceCar;
                break;
        }
    }

    @FXML
    public void onClickedBack(ActionEvent event) throws IOException {
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
}
