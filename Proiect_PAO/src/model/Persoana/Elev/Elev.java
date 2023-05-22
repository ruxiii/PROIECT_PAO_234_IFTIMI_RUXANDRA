package model.Persoana.Elev;

import model.Persoana.Persoana;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Elev extends Persoana {
    private String profil;
    private double medieIntrare;
    private String clasaRepartizata;
    private int nrOreStateLaLiceu;

    public Elev(int i, ResultSet in) {}

    public Elev(int CNP, String nume, String prenume, int varsta, String profil, double medieIntrare, String clasaRepartizata, int nrOreStateLaLiceu) {
        super(CNP, nume, prenume, varsta);
        this.profil = profil;
        this.medieIntrare = medieIntrare;
        this.clasaRepartizata = clasaRepartizata;
        this.nrOreStateLaLiceu = nrOreStateLaLiceu;
    }

    public Elev() {}

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public double getMedieIntrare() {
        return medieIntrare;
    }

    public void setMedieIntrare(double medieIntrare) {
        this.medieIntrare = medieIntrare;
    }

    public String getClasaRepartizata() {
        return clasaRepartizata;
    }

    public void setClasaRepartizata(String clasaRepartizata) {
        this.clasaRepartizata = clasaRepartizata;
    }

    public int getNrOreStateLaLiceu() {
        return nrOreStateLaLiceu;
    }

    public void setNrOreStateLaLiceu(int nrOreStateLaLiceu) {
        this.nrOreStateLaLiceu = nrOreStateLaLiceu;
    }

    public static Elev creeazaElev(int CNP, String nume, String prenume, int varsta, String profil, double medieIntrare, String clasaRepartizata, int nrOreStateLaLiceu) throws SQLException {
        return new Elev(CNP, nume, prenume, varsta, profil, medieIntrare, clasaRepartizata, nrOreStateLaLiceu);
    }

    @Override
    public String toString(){
        return "Elev{ " +
                "CNP: " + getCNP() +
                "\nNume: " + getNume() +
                "\nPrenume: " + getPrenume() +
                "\nVarsta: " + getVarsta() +
                "\nProfil: " + getProfil() +
                "\nMedie intrare: " + getMedieIntrare() +
                "\nClasa repartizata: " + getClasaRepartizata() +
                "\nNumar ore state la liceu: " + getNrOreStateLaLiceu() +
                "}";
    }

    public String toCSV(){
        return "CNP: "+ getCNP() +
                ", " + "Nume: " + getNume() +
                ", " + "Prenume: " + getPrenume() +
                ", " + "Varsta: " + getVarsta() +
                ", " + "Profil: " +getProfil() +
                ", " + "Medie intrare: " + getMedieIntrare() +
                ", " + "Clasa repartizata: " + getClasaRepartizata() +
                ", " + "Numar ore state la liceu: " + getNrOreStateLaLiceu();
    }
}

