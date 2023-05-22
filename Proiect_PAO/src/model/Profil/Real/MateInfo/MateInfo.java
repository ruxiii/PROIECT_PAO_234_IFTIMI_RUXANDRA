package model.Profil.Real.MateInfo;

import model.Profil.Profil;

public class MateInfo extends Profil {
    private int numarOreMatematica;
    private int numarOreInformatica;
//    private int numarOreEngleza;

    public MateInfo() {}

    public MateInfo(String denumire, int numarOreMatematica, int numarOreInformatica) {
        super(denumire);
        this.numarOreMatematica = numarOreMatematica;
        this.numarOreInformatica = numarOreInformatica;
//        this.numarOreEngleza = numarOreEngleza;
    }

    public int getNumarOreMatematica() {
        return numarOreMatematica;
    }

    public void setNumarOreMatematica(int numarOreMatematica) {
        this.numarOreMatematica = numarOreMatematica;
    }

    public int getNumarOreInformatica() {
        return numarOreInformatica;
    }

    public void setNumarOreInformatica(int numarOreInformatica) {
        this.numarOreInformatica = numarOreInformatica;
    }
}
