package rcas.controller;

import com.jfoenix.controls.JFXButton;
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
    public void OnClickedAudiR8(ActionEvent event) {
        System.out.println("Audi");
    }

    @FXML
    public void OnClickedLambo(ActionEvent event) {
        System.out.println("Lambo");
    }

    @FXML
    public void onClickedNewCar(ActionEvent event) {
        System.out.println("New Car");
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
            System.out.println("Changed to index view");
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

