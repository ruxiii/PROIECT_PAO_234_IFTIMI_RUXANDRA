package model.Extrascolar;

public class Extrascolar {
    private String denumire;
    private String zi;
    private int ora;
    private int nrElevi;

    public Extrascolar(){}

    public Extrascolar(String denumire, String zi, int ora, int nrElevi) {
        this.denumire = denumire;
        this.zi = zi;
        this.ora = ora;
        this.nrElevi = nrElevi;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getNrElevi() {
        return nrElevi;
    }

    public void setNrElevi(int nrElevi) {
        this.nrElevi = nrElevi;
    }

    @Override
    public String toString(){
        return "Extrascolar{ " +
                "Denumire: " + getDenumire() +
                "\nZi: " + getZi() +
                "\nOra: " + getOra() +
                "\nNumar elevi: " + getNrElevi() +
                "}";
    }

    public String toCSV(){
        return "Denumire: " + getDenumire() +
                ", Zi: " + getZi() +
                ", Ora: " + getOra() +
                ", Numar elevi: " + getNrElevi();
    }
}
