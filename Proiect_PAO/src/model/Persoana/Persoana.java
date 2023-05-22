package model.Persoana;

public class Persoana {
    protected int CNP;
    protected String nume;
    protected String prenume;
    protected int varsta;

    public  Persoana(){}

    public Persoana(int CNP, String nume, String prenume, int varsta) {
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public int getCNP() {
        return CNP;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
