package model.Persoana.Profesor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProfesorSingleton {
    private static ProfesorSingleton instance = null;
    private ArrayList<Profesor> profesori = new ArrayList<Profesor>();

    public static ProfesorSingleton getInstance()
    {
        if (instance == null)
            instance = new ProfesorSingleton();
        return instance;
    }

    public static void setInstance(ProfesorSingleton instance) {
        ProfesorSingleton.instance = instance;
    }


    public ArrayList<Profesor> citesteCSV() {
        String path = "data/Profesori.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista profesori!");
            } else {
                while (line != null) {
                    String[] prof = line.split(",");
                    var profesorNou = new Profesor(
                            Integer.parseInt(prof[0]),
                            prof[1],
                            prof[2],
                            Integer.parseInt(prof[3]),
                            prof[4],
                            Integer.parseInt(prof[5]),
                            Integer.parseInt(prof[6])
                    );
                    profesori.add(profesorNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return profesori;
    }

    public void scrieCSV(ArrayList<Profesor> profesori){
        try{
            var writer = new FileWriter("data/afisareProfesori.csv");
            for(var prof : profesori){
                writer.write(prof.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }


}
