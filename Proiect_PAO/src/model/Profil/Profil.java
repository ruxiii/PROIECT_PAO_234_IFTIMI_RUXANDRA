package model.Profil;

public class Profil {
    protected String denumire;

    public Profil(){}

    public Profil(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}
