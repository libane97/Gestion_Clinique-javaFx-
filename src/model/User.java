package model;

public class User {
    private int id;
    private String email;
    private String password;
    private Medecin medecin;
    private Secretaire secretaire;

    public User() {
    }

    public User(int id, String email, String password, Medecin medecin, Secretaire secretaire) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.medecin = medecin;
        this.secretaire = secretaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
