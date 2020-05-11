package model;

import java.time.LocalDate;

public class RendezVous {
    private int id;
    private LocalDate date;
    private String libelle;
    private Medecin medecin = new Medecin();
    private Secretaire secretaire = new Secretaire();

    public RendezVous() {
    }

    public RendezVous(int id, LocalDate date, String libelle, Medecin medecin, Secretaire secretaire) {
        this.id = id;
        this.date = date;
        this.libelle = libelle;
        this.medecin = medecin;
        this.secretaire = secretaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Secretaire getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(Secretaire secretaire) {
        this.secretaire = secretaire;
    }
}
