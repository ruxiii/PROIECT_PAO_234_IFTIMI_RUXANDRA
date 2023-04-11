import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import proiect.Catalog.*;
import proiect.Clasa.Clasa;
import proiect.Profil.*;
import proiect.Persoana.*;

public class LiceuService {
    private String nume;
    private String locatie;
    private String oras;
    private double ultimaMedie;
    private ArrayList<Elev> elevi;
    private ArrayList<Profesor> profesori;

    static int contor;

    public LiceuService(){}

    public LiceuService(String nume, String locatie, String oras, double ultimaMedie, ArrayList<Elev> elevi, ArrayList<Profesor> profesori) {
        this.nume = nume;
        this.locatie = locatie;
        this.oras = oras;
        this.ultimaMedie = ultimaMedie;
        this.elevi = elevi;
        this.profesori = profesori;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public double getUltimaMedie() {
        return ultimaMedie;
    }

    public void setUltimaMedie(double ultimaMedie) {
        this.ultimaMedie = ultimaMedie;
    }

    public ArrayList<Elev> getElevi() {
        return elevi;
    }

    public void setElevi(ArrayList<Elev> elevi) {
        this.elevi = elevi;
    }

    public ArrayList<Profesor> getProfesori() {
        return profesori;
    }

    public void setProfesori(ArrayList<Profesor> profesori) {
        this.profesori = profesori;
    }

    public String toString(){
        return "Liceu{ " +
                "\nNume liceu: " + getNume() +
                "\nLocatie liceu: " + getLocatie() +
                "\nOras liceu: " + getOras() +
                "\nUltima medie: " + getUltimaMedie() + "}";
    }

    public void adaugaProfesor(Profesor p){
        profesori.add(p);
    }

    public void daAfaraProfesor(String n, String p){
        try {
            for (Profesor prf : profesori) {
                if (prf.getPrenume() == p & prf.getNume() == n) {
                    profesori.remove(prf);
                }
            }
        } catch (Exception e){
            System.out.println("Profesorul " + n +" " + p + " a fost dat afara!");
            return;
        }
        System.out.println("Profesorul " + n +" " + p + " nu preda in acest liceu!");
    }

    public void marireSalariu(){
        for(Profesor p : profesori) {
            if (p.getSalariu() < 4000) {
                p = new Profesor(p.getCNP(), p.getNume(), p.getPrenume(), p.getVarsta(), p.getMateriePredata(), p.getNumarOrePredate(), p.getSalariu() + 1000);
                System.out.println(p + "\n");
            }
        }
    }

    public void afiseazaProfesori(){
        System.out.println( "Profesori: { " );
        contor=1;
        for(Profesor p:profesori) {
            System.out.println(contor + ". Profesor{ " +
                    "CNP: " + p.getCNP() +
                    ", Nume: " + p.getNume() +
                    ", Prenume: " + p.getPrenume() +
                    ", Varsta: " + p.getVarsta() +
                    ", Materie predata: " + p.getMateriePredata() +
                    ", Numar ore predate: " + p.getNumarOrePredate() +
                    ", Salariu: " + p.getSalariu() + "}");
            contor++;
        }
        System.out.println("}");

    }

    public void adaugaElevi(Elev e){
        elevi.add(e);
    }

    public void daAfaraElev(String n, String p){
        try {
            for (Elev elv : elevi) {
                if (elv.getPrenume() == p & elv.getNume() == n) {
                    elevi.remove(elv);
                }
            }
        } catch (Exception e){
            System.out.println("Elevul " + n +" " + p + " a fost dat afara!");
            return;
        }
        System.out.println("Elevul " + n +" " + p + " nu invata in acest liceu!");
    }

    public void seteazaProfilul(Elev e){
        MateInfo mi = new MateInfo("mate-info", 20, 15);
        StiinteleNaturii sn = new StiinteleNaturii("stiintele-naturii", 15, 12);

        if(e.getClasaRepartizata()=="9A"){
            String den = sn.getDenumire();
            int nr = sn.getNumarOreBiologie() + sn.getNumarOreChimie();
            e = new Elev(e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), den, e.getMedieIntrare(), e.getClasaRepartizata(), nr);
            System.out.println("\n"+ e + "\n");
        }
        else{
            String den = mi.getDenumire();
            int nr = mi.getNumarOreMatematica() + mi.getNumarOreMatematica();
            e = new Elev(e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), den, e.getMedieIntrare(), e.getClasaRepartizata(), nr);
            System.out.println("\n"+ e + "\n");
        }
    }

    public void afiseazaElevi(){
        System.out.println( "Elevi: { " );
        contor=1;
        for(Elev p:elevi) {
            System.out.println(contor + ". Elev{ " +
                    "CNP: " + p.getCNP() +
                    ", Nume: " + p.getNume() +
                    ", Prenume: " + p.getPrenume() +
                    ", Varsta: " + p.getVarsta() +
                    ", Profil: " + p.getProfil() +
                    ", Medie intrare: " + p.getMedieIntrare() +
                    ", Clasa repartizata: " + p.getClasaRepartizata() + "}");
            contor++;
        }
        System.out.println("}");
    }

    public void faCataloage(LiceuService liceu){
        Clasa clase = new Clasa(new ArrayList<>());
        for (Elev e : liceu.getElevi()) {
            if (clase.getClase().contains(e.getClasaRepartizata()))
                continue;
            else
                clase.adaugaClasa(e.getClasaRepartizata());
        }
        List<String> arr = clase.getClase();
        arr = arr.stream().sorted().collect(Collectors.toList());

        Catalog cataloage = new Catalog(new HashMap<>());
        for (var elem : arr) {
            cataloage.adaugaCatalog(elem, new ArrayList<>());
            for (Elev e : liceu.getElevi())
                if (e.getClasaRepartizata() == elem) {
                    cataloage.getCatalog().get(elem).add(e.getNume() + " " + e.getPrenume());
                }
        }

        cataloage.getCatalog().forEach((key, value) ->
                System.out.println(key + ": " + value.stream().sorted().collect(Collectors.toList())));
    }

}
