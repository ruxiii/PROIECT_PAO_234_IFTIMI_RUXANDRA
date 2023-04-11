import proiect.Persoana.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LiceuService liceu = new LiceuService("CNMV", "Pache Protopopescu", "Bucuresti", 9.47, new ArrayList<>(), new ArrayList<>());

        System.out.println("--------------LICEU--------------");
        System.out.println(liceu);
        System.out.println("---------------------------------");
        System.out.println();

        Profesor profesor1 = new Profesor(12345, "Matei", "Teo", 30, "MATEMATICA", 30, 3700);
        Profesor profesor2 = new Profesor(34567, "Popescu", "Mihai", 40, "INFORMATICA", 50, 6000);
        Profesor profesor3 = new Profesor(52411, "Tudor", "Daniela", 54, "CHIMIE", 45, 5300);
        Profesor profesor4 = new Profesor(98352, "Spirea", "Gina", 43, "BIOLOGIE", 34, 3930);
        Profesor profesor5 = new Profesor(95422, "Badescu", "Nicoleta", 40, "ROMANA", 25, 3200);

        liceu.adaugaProfesor(profesor1);
        liceu.adaugaProfesor(profesor2);
        liceu.adaugaProfesor(profesor3);
        liceu.adaugaProfesor(profesor4);
        liceu.adaugaProfesor(profesor5);

        System.out.println("-----------PROFESORI-------------");
        liceu.afiseazaProfesori();
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("-------CONCEDIEM PROFESORI-------");
        liceu.daAfaraProfesor("Badescu", "Nicoleta");
        liceu.daAfaraProfesor("Popescu", "Marian");
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("------PROFESORI ACTUALIZATI------");
        liceu.afiseazaProfesori();
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("---------MARIRE SALARIU---------");
        liceu.marireSalariu();
        System.out.println("---------------------------------");
        System.out.println();

        Elev elev1 = new Elev(54131, "Iftimi", "Ruxandra", 14, "", 9.98, "9B", 0);
        Elev elev3 = new Elev(61336, "Stefanoiu", "Rares", 15, "", 9.9, "9A", 0);
        Elev elev2 = new Elev(98012, "Barbu", "Robert", 14, "", 9.75, "9D", 0);
        Elev elev5 = new Elev(73415, "Pop", "Andreea", 15, "", 9.89, "9C", 0);
        Elev elev4 = new Elev(91374, "Marin", "Oana", 15, "", 9.93, "9D", 0);
        Elev elev7 = new Elev(54131, "Berbecaru", "Andrei", 15, "", 9.94, "9C", 0);
        Elev elev6 = new Elev(42438, "Ionescu", "Radu", 14, "", 10, "9B", 0);
        Elev elev9 = new Elev(97012, "Vasile", "Mihai", 15, "", 9.65, "9A", 0);
        Elev elev8 = new Elev(64121, "Cristea", "Tudor", 14, "", 9.59, "9A", 0);
        Elev elev10 = new Elev(82349, "Anghel", "Darius", 15, "", 9.81, "9B", 0);
        Elev elev11 = new Elev(32083, "Moise", "Marian", 15, "", 9.76, "9D", 0);
        Elev elev12 = new Elev(98236, "Bobo", "Maria", 14, "", 9.49, "9C", 0);
        Elev elev13 = new Elev (89131, "Ionescu", "Ana", 14, "", 9.65, "9A",  0);

        liceu.adaugaElevi(elev1);
        liceu.adaugaElevi(elev2);
        liceu.adaugaElevi(elev3);
        liceu.adaugaElevi(elev4);
        liceu.adaugaElevi(elev5);
        liceu.adaugaElevi(elev6);
        liceu.adaugaElevi(elev7);
        liceu.adaugaElevi(elev8);
        liceu.adaugaElevi(elev9);
        liceu.adaugaElevi(elev10);
        liceu.adaugaElevi(elev11);
        liceu.adaugaElevi(elev12);
        liceu.adaugaElevi(elev13);


        System.out.println("-------------ELEVI---------------");
        liceu.afiseazaElevi();
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("--------EXMATRICULAM ELEVI--------");
        liceu.daAfaraElev("Ionescu", "Ana");
        liceu.daAfaraElev("Popa", "Miriam");
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("--------ELEVI ACTUALIZATI----------");
        for(Elev e: liceu.getElevi())
            liceu.seteazaProfilul(e);
        System.out.println("---------------------------------");
        System.out.println();

        System.out.println("-----------CATALOAGE-------------");
        liceu.faCataloage(liceu);
        System.out.println("---------------------------------");
        System.out.println();

    }
}