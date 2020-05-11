package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AcceuilController implements Initializable {
    @FXML
    private Label message;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message.setText(MainController.userconnect);
    }
    public void loadconsultation(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/rendezvous.fxml"));
        stage.setTitle("Gestion des Rendez vous");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void loadmedecin(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ui/medecin.fxml"));
        stage.setTitle("Gestion des medecins");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }
}
