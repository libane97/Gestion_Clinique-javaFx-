package controller;

import dao.IUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Secretaire;
import model.User;
import service.UserService;
import java.io.IOException;

public class MainController {
    @FXML
    private TextField emailtxt;
    @FXML
    private PasswordField passwordtxt;
    public static String userconnect;
    public static Secretaire secretaire;
    private IUser iUser = new UserService();
    public void getlogin(ActionEvent event) throws IOException {
        String email = emailtxt.getText();
        String password = passwordtxt.getText();
        //String variable = "Votre email est " + email + " et votre password "+ password;
         if (email.equals("") || password.equals("")){
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Erreur");
             alert.setContentText("Veuillez saisir un login ou un mot de passe");
             alert.showAndWait();
         }else{
             User user = iUser.getconnection(email,password);
              if (user != null){
                  if (user.getMedecin() != null){
                       userconnect = user.getMedecin().getNom()+ " " + user.getMedecin().getPrenom();
                  }
                   if (user.getSecretaire() != null)
                  {
                      secretaire = user.getSecretaire();
                      userconnect = user.getSecretaire().getNom() + " " + user.getSecretaire().getPrenom();
                  }
                  Stage stage = new Stage();
                  Parent root = FXMLLoader.load(getClass().getResource("/ui/acceuille.fxml"));
                  stage.setTitle("Acceuillez");
                  stage.setScene(new Scene(root));
                  stage.showAndWait();
              }else{
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Erreur");
                  alert.setContentText("Email ou mot de passe incorrect");
                  alert.showAndWait();
              }
         }
    }
}
