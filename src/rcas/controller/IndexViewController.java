package rcas.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rcas.util.Variables;

import java.io.IOException;

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
        selectBox.setItems(FXCollections.observableArrayList("Student                                         ", "Ingenieur"));
    }

    @FXML
    public void onLoginClick(ActionEvent actionEvent) throws IOException {
        if (selectBox.getValue().equals("Ingenieur") || selectBox.getValue().equals("Student                                         ")) {
            Variables.scene = setScene("/view/TopView.fxml");
            System.out.println("Changed view");
        } else {
            System.out.println("Select a user");
        }
    }

    private Scene setScene(String strPath) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource(strPath));
        Scene scene = new Scene(root, 1100, 600);
        this.primaryStage = Variables.primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }
}


