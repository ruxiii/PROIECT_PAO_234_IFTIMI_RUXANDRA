package proiect.Persoana;

public class Profesor extends Persoana {
    private String materiePredata;
    private int numarOrePredate;
    private int salariu;

    public Profesor() {}

    public Profesor(long CNP, String nume, String prenume, int varsta, String materiePredata, int numarOrePredate, int salariu) {
        super(CNP, nume, prenume, varsta);
        this.materiePredata = materiePredata;
        this.numarOrePredate = numarOrePredate;
        this.salariu = salariu;
    }

    public String getMateriePredata() {
        return materiePredata;
    }

    public void setMateriePredata(String materiePredata) {
        this.materiePredata = materiePredata;
    }

    public int getNumarOrePredate() {
        return numarOrePredate;
    }

    public void setNumarOrePredate(int numarOrePredate) {
        this.numarOrePredate = numarOrePredate;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString(){
        return "Profesor{ " +
                "CNP: " + getCNP() +
                "\nNume: " + getNume() +
                "\nPrenume: " + getPrenume() +
                "\nVarsta: " + getVarsta() +
                "\nMaterie predata: " + getMateriePredata() +
                "\nNumar ore predate: " + getNumarOrePredate() +
                "\nSalariu: " + getSalariu() +
                "}";
    }
}
