package service;

import dao.DB;
import dao.IUser;
import model.User;

import java.sql.ResultSet;

public class UserService implements IUser {
    private DB db = new DB();
    @Override
    public User getconnection(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email=? AND password=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1,email);
            db.getPstm().setString(2,password);
            ResultSet resultSet = db.executeSelect();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                Object medecin = resultSet.getObject(4);
                user.setMedecin(null);
                user.setSecretaire(null);
                if (medecin != null){
                    user.setMedecin(new MedecinService().getById((Integer)medecin));
                }
                Object secretaire = resultSet.getObject(5);
                if (secretaire !=null){
                    user.setSecretaire(new SecretaireService().get((Integer)secretaire));

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
