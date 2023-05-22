package model.Profil.Uman;

import model.Profil.Profil;

public class StiinteSociale extends Profil {
    private int numarOreLogica;
    private int numarOreEconomie;

    public StiinteSociale() {}

    public StiinteSociale(String denumire, int numarOreLogica, int numarOreEconomie) {
        super(denumire);
        this.numarOreLogica = numarOreLogica;
        this.numarOreEconomie = numarOreEconomie;
    }

    public int getNumarOreLogica() {
        return numarOreLogica;
    }

    public void setNumarOreLogica(int numarOreLogica) {
        this.numarOreLogica = numarOreLogica;
    }

    public int getNumarOreEconomie() {
        return numarOreEconomie;
    }

    public void setNumarOreEconomie(int numarOreEconomie) {
        this.numarOreEconomie = numarOreEconomie;
    }
}
