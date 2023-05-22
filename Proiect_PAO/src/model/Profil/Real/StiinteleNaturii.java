package model.Profil.Real;

import model.Profil.Profil;

public class StiinteleNaturii extends Profil {
    private int numarOreBiologie;
    private int numarOreChimie;

    public StiinteleNaturii(){}

    public StiinteleNaturii(String denumire, int numarOreBiologie, int numarOreChimie) {
        super(denumire);
        this.numarOreBiologie = numarOreBiologie;
        this.numarOreChimie = numarOreChimie;
    }

    public int getNumarOreBiologie() {
        return numarOreBiologie;
    }

    public void setNumarOreBiologie(int numarOreBiologie) {
        this.numarOreBiologie = numarOreBiologie;
    }

    public int getNumarOreChimie() {
        return numarOreChimie;
    }

    public void setNumarOreChimie(int numarOreChimie) {
        this.numarOreChimie = numarOreChimie;
    }
}
