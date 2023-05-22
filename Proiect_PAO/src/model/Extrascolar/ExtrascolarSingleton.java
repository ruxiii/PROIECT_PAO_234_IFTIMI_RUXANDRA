package model.Extrascolar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExtrascolarSingleton {
    private static ExtrascolarSingleton instance = null;
    private ArrayList<Extrascolar> extraScolar = new ArrayList<Extrascolar>();

    public static ExtrascolarSingleton getInstance()
    {
        if (instance == null)
            instance = new ExtrascolarSingleton();
        return instance;
    }

    public static void setInstance(ExtrascolarSingleton instance) { ExtrascolarSingleton.instance = instance;
    }


    public ArrayList<Extrascolar> citesteCSV() {
        String path = "data/Extrascolar.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista activitati extrascolare!");
            } else {
                while (line != null) {
                    String[] ext = line.split(",");
                    var extrascolarNou = new Extrascolar(
                            ext[0],
                            ext[1],
                            Integer.parseInt(ext[2]),
                            Integer.parseInt(ext[3])
                    );
                    extraScolar.add(extrascolarNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return extraScolar;
    }

    public void scrieCSV(ArrayList<Extrascolar> extraScolar){
        try{
            var writer = new FileWriter("data/afisareExtrascolar.csv");
            for(var ext : extraScolar){
                writer.write(ext.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
