package service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import model.Catalog.*;
import model.Clasa.Clasa;
import model.Extrascolar.Extrascolar;
import model.Extrascolar.ExtrascolarSingleton;
import model.Persoana.Elev.Elev;
import model.Persoana.Elev.ElevSingleton;
import model.Persoana.Profesor.Profesor;
import model.Persoana.Profesor.ProfesorSingleton;
import model.Profil.Real.MateInfo.MateInfo;
import model.Profil.Real.StiinteleNaturii;
import model.Profil.Uman.Filologie;
import model.Profil.Uman.StiinteSociale;
import model.Sala.Sali;
import model.Sala.SaliSingleton;

public class LiceuService {
    private String nume;
    private String locatie;
    private String oras;
    private double ultimaMedie;
    private ArrayList<Elev> elevi = new ArrayList<>();
    private ArrayList<Profesor> profesori = new ArrayList<>();
    private ArrayList<Sali> sali = new ArrayList<>();
    private ArrayList<Extrascolar> extrascolar = new ArrayList<>();

    static int contor;

    public LiceuService(){}

    public LiceuService(String nume, String locatie, String oras, double ultimaMedie) {
        this.nume = nume;
        this.locatie = locatie;
        this.oras = oras;
        this.ultimaMedie = ultimaMedie;
    }

    public ArrayList<Extrascolar> getExtrascolar() {
        return extrascolar;
    }

    public void setExtrascolar(ArrayList<Extrascolar> extrascolar) {
        this.extrascolar = extrascolar;
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

    public ArrayList<Sali> getSali() {
        return sali;
    }

    public void setSali(ArrayList<Sali> sali) {
        this.sali = sali;
    }

    public String toString(){
        return "Liceu{ " +
                "\nNume liceu: " + getNume() +
                "\nLocatie liceu: " + getLocatie() +
                "\nOras liceu: " + getOras() +
                "\nUltima medie: " + getUltimaMedie() + "}";
    }

    public void adaugaProfesor(){
        profesori = ProfesorSingleton.getInstance().citesteCSV();
        ProfesorSingleton.getInstance().scrieCSV(profesori);
    }

    public void daAfaraProfesor(String n, String p) {
        for (Profesor prf : profesori) {

            String aux = prf.getPrenume();
            String pr = "";
            int i = 1;
            while (i < aux.length() - 1) {
                pr += aux.charAt(i);
                i++;
            }
            i = 0;
            int ok1 = 1;
            if (p.length() != pr.length())
                ok1 = 0;
            else {
                while (i < p.length()) {
                    if (pr.charAt(i) != p.charAt(i))
                        ok1 = 0;
                    i++;
                }
            }

            aux = prf.getNume();
            String nu = "";
            i = 1;
            while (i < aux.length() - 1) {
                nu += aux.charAt(i);
                i++;
            }
            i = 0;
            int ok2 = 1;
            if (nu.length() != n.length())
                ok2 = 0;
            else {
                while (i < n.length()) {
                    if (nu.charAt(i) != n.charAt(i))
                        ok2 = 0;
                    i++;
                }
            }

            if (ok1 == 1 & ok2 == 1) {
                profesori.remove(prf);
                System.out.println("Profesorul " + n + " " + p + " a fost dat afara!");
                return;
            }
        }
        System.out.println("Profesorul " + n + " " + p + " nu preda in acest liceu!");
        ProfesorSingleton.getInstance().scrieCSV(profesori);
    }

    public void marireSalariu(){
        ArrayList<Profesor> aux=new ArrayList<>();
        for(Profesor p : profesori) {
            if (p.getSalariu() < 4000) {
                Profesor pr = new Profesor(p.getCNP(), p.getNume(), p.getPrenume(), p.getVarsta(), p.getMateriePredata(), p.getNumarOrePredate(), p.getSalariu() + 1000);
                aux.add(pr);
            }
            else{
                aux.add(p);
            }
        }
        profesori = aux;
        ProfesorSingleton.getInstance().scrieCSV(profesori);
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

    public void adaugaElevi() throws ParseException {
        elevi = ElevSingleton.getInstance().citesteCSV();
        ElevSingleton.getInstance().scrieCSV(elevi);
    }

    public int numarElevi(){
        return elevi.size();
    }

    public void daAfaraElev(String n, String p){
        for (Elev elv : elevi) {

            String aux = elv.getPrenume();
            String pr = "";
            int i = 1;
            while (i < aux.length() - 1) {
                pr += aux.charAt(i);
                i++;
            }
            i = 0;
            int ok1 = 1;
            if (p.length() != pr.length())
                ok1 = 0;
            else {
                while (i < p.length()) {
                    if (pr.charAt(i) != p.charAt(i))
                        ok1 = 0;
                    i++;
                }
            }

            aux = elv.getNume();
            String nu = "";
            i = 1;
            while (i < aux.length() - 1) {
                nu += aux.charAt(i);
                i++;
            }
            i = 0;
            int ok2 = 1;
            if (nu.length() != n.length())
                ok2 = 0;
            else {
                while (i < n.length()) {
                    if (nu.charAt(i) != n.charAt(i))
                        ok2 = 0;
                    i++;
                }
            }

            if (ok1 == 1 & ok2 == 1) {
                elevi.remove(elv);
                System.out.println("Elevul " + n +" " + p + " a fost dat afara!");
                return;
            }
        }
        System.out.println("Elevul " + n +" " + p + " nu invata in acest liceu!");
        ElevSingleton.getInstance().scrieCSV(elevi);
    }

    public String pleacaElev(){
        Elev elev1;
        Random rnd = new Random();

        elev1 = getElevi().get(rnd.nextInt(numarElevi()));
        String nume = "";
        for(int i=1; i<elev1.getNume().length()-1; i++){
            nume += elev1.getNume().charAt(i);
        }
        String prenume = "";
        for(int i=1; i<elev1.getPrenume().length()-1; i++){
            prenume += elev1.getPrenume().charAt(i);
        }
        return ("Elevul " + nume + ' ' + prenume + " a parasit liceul ");
    }

    public void seteazaProfilul(){
        MateInfo mi = new MateInfo("mate-info", 20, 15);
        StiinteleNaturii sn = new StiinteleNaturii("stiintele-naturii", 15, 12);
        StiinteSociale ss = new StiinteSociale("stiinte sociale", 3, 0);
        Filologie fi = new Filologie("filologie", 10, 4);
        ArrayList<Elev> aux=new ArrayList<>();

        for(Elev e : elevi) {
            if (e.getClasaRepartizata().charAt(2)=='A') {
                String den = sn.getDenumire();
                int nr = sn.getNumarOreBiologie() + sn.getNumarOreChimie();
                Elev el = new Elev((int) e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), den, e.getMedieIntrare(), e.getClasaRepartizata(), nr);
                aux.add(el);
            } else if (e.getClasaRepartizata().charAt(2)=='B'){
                String den = mi.getDenumire();
                int nr = mi.getNumarOreMatematica() + mi.getNumarOreMatematica();
                Elev el = new Elev((int)e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), den, e.getMedieIntrare(), e.getClasaRepartizata(), nr);
                aux.add(el);
            } else if (e.getClasaRepartizata().charAt(2)=='C'){
                String den = fi.getDenumire();
                int nr = fi.getNumarOreRomana() + fi.getNumarOreLatina();
                Elev el = new Elev((int)e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), den, e.getMedieIntrare(), e.getClasaRepartizata(), nr);
                aux.add(el);
            } else{
                String den = ss.getDenumire();
                int nr = ss.getNumarOreEconomie() + ss.getNumarOreLogica();
                Elev el = new Elev((int)e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), den, e.getMedieIntrare(), e.getClasaRepartizata(), nr);
                aux.add(el);
            }
        }
        elevi=aux;
        ElevSingleton.getInstance().scrieCSV(elevi);
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
            for (Elev e : liceu.getElevi()){
                if (e.getClasaRepartizata().charAt(2) == elem.charAt(2))
                    cataloage.getCatalog().get(elem).add(e.getNume() + " " + e.getPrenume());
            }
        }

        cataloage.getCatalog().forEach((key, value) ->
                System.out.println(key + ": " + value.stream().sorted().collect(Collectors.toList())));
    }

    public void adaugaSali(){
        sali = SaliSingleton.getInstance().citesteCSV();
        SaliSingleton.getInstance().scrieCSV(sali);
    }

    public void seteazaSala(){
        ArrayList<Sali> aux = new ArrayList<>();
        Clasa clase = new Clasa(new ArrayList<>());
        for (Elev e : getElevi()) {
            if (clase.getClase().contains(e.getClasaRepartizata()))
                continue;
            else
                clase.adaugaClasa(e.getClasaRepartizata());
        }
        List<String> cls = clase.getClase();
        int i=0;

        for(Sali s: sali){
            if(s.geteOcupata().charAt(1)=='t'){
                Sali sl = new Sali(s.getDenumire(), s.geteOcupata(), s.getCapacitate(), "Sala este deja ocupata!");
                aux.add(sl);
            }
            else{
                if(i<cls.size()) {
                    Sali sl = new Sali(s.getDenumire(), s.geteOcupata(), s.getCapacitate(), cls.get(i));
                    aux.add(sl);
                    i += 1;
                }
                else{
                    Sali sl = new Sali(s.getDenumire(), s.geteOcupata(), s.getCapacitate(), "Sala este disponibila!");
                    aux.add(sl);
                }
            }
        }
        sali=aux;
        SaliSingleton.getInstance().scrieCSV(sali);
    }

    public void adaugaExtrascolar(){
        extrascolar = ExtrascolarSingleton.getInstance().citesteCSV();
        ExtrascolarSingleton.getInstance().scrieCSV(extrascolar);
    }

    public void inscriereExtrascolar(){
        int mate=0;
        int sn=0;
        int filo=0;
        int ss=0;
        ArrayList<Extrascolar> aux = new ArrayList<>();

        for (Elev e : getElevi()){
            if (e.getProfil()=="mate-info")
                mate++;
            else if (e.getProfil()=="filologie")
                filo++;
            else if (e.getProfil() == "stiintele-naturii")
                sn++;
            else
                ss++;
        }
        for(Extrascolar ex: extrascolar){
            if(ex.getDenumire().contains("matematica")){
                Extrascolar extr = new Extrascolar(ex.getDenumire(), ex.getZi(), ex.getOra(), mate);
                aux.add(extr);
            }
            else if(ex.getDenumire().contains("biologie")){
                Extrascolar extr = new Extrascolar(ex.getDenumire(), ex.getZi(), ex.getOra(), sn);
                aux.add(extr);
            }
            else if(ex.getDenumire().contains("literatura")){
                Extrascolar extr = new Extrascolar(ex.getDenumire(), ex.getZi(), ex.getOra(), filo);
                aux.add(extr);
            }
            else{
                Extrascolar extr = new Extrascolar(ex.getDenumire(), ex.getZi(), ex.getOra(), ss);
                aux.add(extr);
            }
        }
        extrascolar = aux;
        ExtrascolarSingleton.getInstance().scrieCSV(extrascolar);
    }


}
