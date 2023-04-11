package proiect.Persoana;

public class Persoana {
    protected long CNP;
    protected String nume;
    protected String prenume;
    protected int varsta;

    public  Persoana(){}

    public Persoana(long CNP, String nume, String prenume, int varsta) {
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public long getCNP() {
        return CNP;
    }

    public void setCNP(long CNP) {
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
