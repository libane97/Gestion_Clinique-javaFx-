package service;

import dao.DB;
import dao.ISercretaire;
import model.Secretaire;

import java.sql.ResultSet;

public class SecretaireService implements ISercretaire {
    private DB db = new DB();
    @Override
    public int save(Secretaire secretaire) {
        return 0;
    }

    @Override
    public Secretaire get(int id) {
        String sql = "SELECT * FROM secretaire WHERE id = ?";
        Secretaire secretaire = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1,id);
            ResultSet resultSet = db.executeSelect();
            if (resultSet.next()){
                secretaire = new Secretaire();
                secretaire.setId(resultSet.getInt(1));
                secretaire.setNom(resultSet.getString(2));
                secretaire.setPrenom(resultSet.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return secretaire;
    }
}
