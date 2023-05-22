package model.Persoana.Elev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ElevSingleton {
    private static ElevSingleton instance = null;
    private ArrayList<Elev> elevi = new ArrayList<Elev>();

    public static ElevSingleton getInstance()
    {
        if (instance == null)
            instance = new ElevSingleton();
        return instance;
    }

    public static void setInstance(ElevSingleton instance) {
        ElevSingleton.instance = instance;
    }


    public ArrayList<Elev> citesteCSV() {
        String path = "data/Elevi.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista elevi!");
            } else {
                while (line != null) {
                    String[] elv = line.split(",");
                    var elevNou = new Elev(
                            Integer.parseInt(elv[0]),
                            elv[1],
                            elv[2],
                            Integer.parseInt(elv[3]),
                            elv[4],
                            Double.parseDouble(elv[5]),
                            elv[6],
                            Integer.parseInt(elv[7])
                    );
                    elevi.add(elevNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return elevi;
    }

    public void scrieCSV(ArrayList<Elev> elevi){
        try{
            var writer = new FileWriter("data/afisareElevi.csv");
            for(var elv : elevi){
                writer.write(elv.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }


}
