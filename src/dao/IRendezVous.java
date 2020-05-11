package dao;

import model.Medecin;
import model.RendezVous;

import java.util.List;

public interface IRendezVous {
    public int save(RendezVous rendezVous);
    public int update(RendezVous rendezVous);
    public int delete(int id);
    public List<RendezVous> getAll();

}
