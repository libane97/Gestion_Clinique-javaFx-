package service;

import dao.DB;
import dao.IRendezVous;
import model.Medecin;
import model.RendezVous;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RendezVousService implements IRendezVous {
    private DB db = new DB();

    @Override
    public int save(RendezVous rendezVous) {
        String sql = "INSERT INTO rendezvous VALUES(NULL,?,?,?,?)";
        int ok = 0;
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1,rendezVous.getDate().toString());
            db.getPstm().setString(2,rendezVous.getLibelle());
            db.getPstm().setInt(3, rendezVous.getMedecin().getId());
            db.getPstm().setInt(4, rendezVous.getSecretaire().getId());
            ok = db.executeMaj();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(RendezVous rendezVous) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<RendezVous> getAll() {
        String sql = "SELECT * FROM rendezvous";
        List<RendezVous> rendezVousList = new ArrayList<RendezVous>();
        try {
            db.initPrepar(sql);
            ResultSet resultSet = db.executeSelect();
            while(resultSet.next()){
                RendezVous rendezVous = new RendezVous();
                rendezVous.setId(resultSet.getInt(1));
                rendezVous.setDate(LocalDate.parse(resultSet.getString(2)));
                rendezVous.setLibelle(resultSet.getString(3));
                rendezVous.setMedecin(new MedecinService().getById(resultSet.getInt(4)));
                rendezVous.setSecretaire(new SecretaireService().get(resultSet.getInt(5)));
          /*      medecin.setPrenom(resultSet.getString(3));
                medecin.setTel(resultSet.getString(4));*/
                rendezVousList.add(rendezVous);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rendezVousList;
    }

}
