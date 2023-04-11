package proiect.Profil;

public class MateInfo extends Profil {
    private int numarOreMatematica;
    private int numarOreInformatica;

    public MateInfo() {}

    public MateInfo(String denumire, int numarOreMatematica, int numarOreInformatica) {
        super(denumire);
        this.numarOreMatematica = numarOreMatematica;
        this.numarOreInformatica = numarOreInformatica;
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
