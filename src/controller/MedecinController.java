package controller;

import dao.IMedecin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Medecin;
import service.MedecinService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MedecinController implements Initializable{
    @FXML
    private TextField nomtxt;
    @FXML
    private TextField prenomtxt;
    @FXML
    private TextField teltxt;
    @FXML
    private Button validerbtn;
    @FXML
    private Button annulerbtn;
    @FXML
    private Button  modifierbtn;
    @FXML
    private Button  supprimetbn;
    @FXML
    private TableView<Medecin> tablemedecin;
    @FXML
    private TableColumn<Medecin,Integer> id;
    @FXML
    private TableColumn<Medecin,String> nom;
    @FXML
    private TableColumn<Medecin,String> prenom;
    @FXML
    private TableColumn<Medecin,String> tel;
    private IMedecin iMedecin = new MedecinService();
    private Medecin medecin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Medecin,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Medecin,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Medecin,String>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<Medecin,String>("tel"));
        load();
        modifierbtn.setDisable(true);
        supprimetbn.setDisable(true);
        validerbtn.setDisable(false);
    }
    
    public void valider(ActionEvent event) {
        medecin = new Medecin();
        medecin.setNom(nomtxt.getText());
        medecin.setPrenom(prenomtxt.getText());
        medecin.setTel(teltxt.getText());
        nomtxt.clear();
        prenomtxt.clear();
        teltxt.clear();
        int ok = iMedecin.save(medecin);
        if (medecin != null){
            if (ok != 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Success");
                alert.showAndWait();
                load();
                annuler(event);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Veuillez bien saisir le champs");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez bien saisir le champs");
            alert.showAndWait();
        }

    }
    
    public void modifier(ActionEvent event) {
        medecin = new Medecin();
        medecin.setId(medecin.getId());
        medecin.setNom(nomtxt.getText());
        medecin.setPrenom(prenomtxt.getText());
        medecin.setTel(teltxt.getText());
        int ok = iMedecin.update(medecin);
        if (medecin != null){
            if (ok != 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Success");
                alert.showAndWait();
                load();
                annuler(event);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText("Veuillez bien saisir le champs");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez bien saisir le champs");
            alert.showAndWait();
        }
        annulerbtn.setDisable(true);
    }

    public void supprime(ActionEvent event) {
        validerbtn.setDisable(false);
    }

    public void annuler(ActionEvent event) {
        validerbtn.setDisable(false);
        supprimetbn.setDisable(true);
        modifierbtn.setDisable(true);
        nomtxt.clear();
        prenomtxt.clear();
        teltxt.clear();
    }
    public void load() {
        ObservableList<Medecin> medecins = FXCollections.observableArrayList();
        List<Medecin> medecinList = iMedecin.getAll();
         for (Medecin m : medecinList){
              medecins.add(m);
         }
        tablemedecin.setItems(medecins);
    }

    public void tablemedecin(MouseEvent mouseEvent) {
        medecin = tablemedecin.getSelectionModel().getSelectedItem();

        nomtxt.setText(medecin.getNom());
        prenomtxt.setText(medecin.getPrenom());
        teltxt.setText(medecin.getTel());
        validerbtn.setDisable(true);
        modifierbtn.setDisable(false);
        supprimetbn.setDisable(false);
    }
}
