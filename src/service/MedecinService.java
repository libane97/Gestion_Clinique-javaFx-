package service;

import dao.DB;
import dao.IMedecin;
import model.Medecin;
import model.RendezVous;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedecinService implements IMedecin {
    private DB db = new DB();
    @Override
    public int save(Medecin medecin) {
        String sql = "INSERT INTO medecin VALUES(NULL,?,?,?)";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1,medecin.getNom());
            db.getPstm().setString(2,medecin.getPrenom());
            db.getPstm().setString(3,medecin.getTel());
            ok = db.executeMaj();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<RendezVous> getRvByMedecin(int id) {
        return null;
    }

    @Override
    public Medecin getById(int id) {
        String sql = "SELECT * FROM medecin WHERE id = ?";
        Medecin medecin = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1,id);
            ResultSet resultSet = db.executeSelect();
            if (resultSet.next()){
                 medecin = new Medecin();
                 medecin.setId(resultSet.getInt(1));
                 medecin.setNom(resultSet.getString(2));
                 medecin.setPrenom(resultSet.getString(3));
                 medecin.setTel(resultSet.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medecin;
    }

    @Override
    public List<Medecin> getAll() {
        String sql = "SELECT * FROM medecin";
       List<Medecin> medecinList = new ArrayList<Medecin>();
        try {
            db.initPrepar(sql);
            ResultSet resultSet = db.executeSelect();
            while(resultSet.next()){
              Medecin  medecin = new Medecin();
                medecin.setId(resultSet.getInt(1));
                medecin.setNom(resultSet.getString(2));
                medecin.setPrenom(resultSet.getString(3));
                medecin.setTel(resultSet.getString(4));
                medecinList.add(medecin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medecinList;
    }

    @Override
    public int update(Medecin medecin) {
        String sql = "UPDATE medecin SET nom=?, prenom=?, tel=? WHERE id=?";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1,medecin.getId());
            db.getPstm().setString(2,medecin.getNom());
            db.getPstm().setString(3,medecin.getPrenom());
            db.getPstm().setString(4,medecin.getTel());
            ok = db.executeMaj();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
}
