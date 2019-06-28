package rcas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IndexViewController {

    private Stage primaryStage;
    @FXML
    private ChoiceBox selectBox;
    @FXML
    private Button loginBtn;
    @FXML
    private GridPane mainPane;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    @FXML
    public void initialize() {


    }
}
