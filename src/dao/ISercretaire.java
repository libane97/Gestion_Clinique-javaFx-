package dao;

import model.Secretaire;

public interface ISercretaire {
    public int save(Secretaire secretaire);
    public Secretaire get(int id);
}
