package controller;

import dao.IMedecin;
import dao.IRendezVous;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Medecin;
import model.RendezVous;
import model.Secretaire;
import service.MedecinService;
import service.RendezVousService;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RendezVousController implements Initializable{
    @FXML
    private TextField libelle;
    @FXML
    private DatePicker dates;
    @FXML
    private ComboBox<Medecin> medecin;
    @FXML
    private TableView<RendezVous> tablerendez;
    @FXML
    private TableColumn<RendezVous,Integer> idrv;
    @FXML
    private TableColumn<RendezVous,String> libellerv;
    @FXML
    private TableColumn<RendezVous, String> daterv;
    @FXML
    private TableColumn<RendezVous,Medecin> medecinrv;
    @FXML
    private TableColumn<RendezVous,Secretaire> secretairerv;
    private IMedecin iMedecin = new MedecinService();
    private IRendezVous iRendezVous = new RendezVousService();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
        loadmedecin();
        idrv.setCellValueFactory(new PropertyValueFactory<>("id"));
        daterv.setCellValueFactory(new PropertyValueFactory<>("date"));
        libellerv.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        medecinrv.setCellValueFactory(new PropertyValueFactory<>("medecin"));
        secretairerv.setCellValueFactory(new PropertyValueFactory<>("secretaire"));
    }

    public void insert(ActionEvent event) {
        RendezVous rv = new RendezVous();
         if (MainController.secretaire == null){
            // System.exit(0);
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Erreur");
             alert.setContentText("Dr "+ MainController.userconnect  +" vous n'avez pas le droit");
             alert.showAndWait();
         }else {
             rv.setLibelle(libelle.getText());
             rv.setDate(dates.getValue());
             rv.setMedecin(medecin.getValue());
             rv.setSecretaire(MainController.secretaire);
             int ok = iRendezVous.save(rv);
             if (ok != 0) {
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Success");
                 alert.setContentText("Veuillez confirme votre enregistrement !!!");
                 alert.showAndWait();
             }else {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Erreur");
                 alert.setContentText("Veuillez verifier vos saisir "+ MainController.userconnect);
                 alert.showAndWait();
             }

         }

    }
    public void loadmedecin() {
        ObservableList<Medecin> medecins = FXCollections.observableArrayList();
        List<Medecin> medecinList = iMedecin.getAll();
        for (Medecin m : medecinList){
            medecins.add(m);
        }
        medecin.setItems(medecins);
    }
    public void load() {
        ObservableList<RendezVous> rendezVous = FXCollections.observableArrayList();
        List<RendezVous> rendezVousList = iRendezVous.getAll();
        for (RendezVous m : rendezVousList){
            rendezVous.add(m);
        }
        tablerendez.setItems(rendezVous);
    }
}
