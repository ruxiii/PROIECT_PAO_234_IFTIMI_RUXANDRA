package model.Sala;

public class Sali {
    private String denumire;
    private String eOcupata;
    private int capacitate;
    private String clasaRepartizata;

    public Sali(){}

    public Sali(String denumire, String eOcupata, int capacitate, String clasaRepartizata) {
        this.denumire = denumire;
        this.eOcupata = eOcupata;
        this.capacitate = capacitate;
        this.clasaRepartizata = clasaRepartizata;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String geteOcupata() {
        return eOcupata;
    }

    public void seteOcupata(String eOcupata) {
        this.eOcupata = eOcupata;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public String getClasaRepartizata() {
        return clasaRepartizata;
    }

    public void setClasaRepartizata(String clasaRepartizata) {
        this.clasaRepartizata = clasaRepartizata;
    }

    @Override
    public String toString(){
        return "Sala{ " +
                "Denumire: " + getDenumire() +
                "\nOcupata: " + geteOcupata() +
                "\nCapacitate: " + getCapacitate() +
                "\nClasa repartizata: " + getClasaRepartizata() +
                "}";
    }

    public String toCSV(){
        return "Denumire: " + getDenumire() +
                ", Ocupata: " + geteOcupata() +
                ", Capacitate: " + getCapacitate() +
                ", Clasa repartizata: " + getClasaRepartizata();
    }
}
