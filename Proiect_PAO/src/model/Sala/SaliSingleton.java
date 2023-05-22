package model.Sala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaliSingleton {
    private static SaliSingleton instance = null;
    private ArrayList<Sali> sali = new ArrayList<Sali>();

    public static SaliSingleton getInstance()
    {
        if (instance == null)
            instance = new SaliSingleton();
        return instance;
    }

    public static void setInstance(SaliSingleton instance) {
        SaliSingleton.instance = instance;
    }


    public ArrayList<Sali> citesteCSV() {
        String path = "data/Sali.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista sali disponibile!");
            } else {
                while (line != null) {
                    String[] sal = line.split(",");
                    var salaNoua = new Sali(
                            sal[0],
                            sal[1],
                            Integer.parseInt(sal[2]),
                            sal[3]
                    );
                    sali.add(salaNoua);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return sali;
    }

    public void scrieCSV(ArrayList<Sali> sali){
        try{
            var writer = new FileWriter("data/afisareSali.csv");
            for(var sal : sali){
                writer.write(sal.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

}
