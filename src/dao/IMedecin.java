package dao;

import model.Medecin;
import model.RendezVous;

import java.util.List;

public interface IMedecin {
    public int save(Medecin medecin);
    public List<RendezVous> getRvByMedecin(int id);
    public Medecin getById(int id);
    public List<Medecin> getAll();
    public int update(Medecin medecin);
}
