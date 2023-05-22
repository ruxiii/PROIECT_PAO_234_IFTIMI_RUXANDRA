package model.Profil.Uman;

import model.Profil.Profil;

public class Filologie extends Profil {
    private int numarOreRomana;
    private int numarOreLatina;

    public Filologie() {}

    public Filologie(String denumire, int numarOreRomana, int numarOreLatina) {
        super(denumire);
        this.numarOreRomana = numarOreRomana;
        this.numarOreLatina = numarOreLatina;
    }

    public int getNumarOreRomana() {
        return numarOreRomana;
    }

    public void setNumarOreRomana(int numarOreRomana) {
        this.numarOreRomana = numarOreRomana;
    }

    public int getNumarOreLatina() {
        return numarOreLatina;
    }

    public void setNumarOreLatina(int numarOreLatina) {
        this.numarOreLatina = numarOreLatina;
    }
}
