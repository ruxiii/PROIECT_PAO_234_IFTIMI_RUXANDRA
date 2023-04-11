package proiect.Clasa;

import java.util.ArrayList;
import java.util.List;

public class Clasa {
    private List<String> clase;

    public Clasa(){}

    public Clasa(List<String> clase) {
        this.clase = clase;
    }

    public List<String> getClase() {
        return clase;
    }

    public void setClase(List<String> clase) {
        this.clase = clase;
    }

    public void adaugaClasa(String c){
        clase.add(c);
    }

    public void afiseazaClase(){
        for(String c: clase){
            System.out.println(c);
        }
    }
}