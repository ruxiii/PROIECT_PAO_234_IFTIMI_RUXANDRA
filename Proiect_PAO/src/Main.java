import config.DatabaseConfiguration;
import model.Extrascolar.Extrascolar;
import model.Extrascolar.ExtrascolarDatabase;
import model.Persoana.Elev.Elev;
import model.Persoana.Elev.ElevDatabase;
import model.Persoana.Profesor.Profesor;
import model.Persoana.Profesor.ProfesorDatabase;
import model.Sala.Sali;
import model.Sala.SaliDatabase;
import service.AuditService;
import service.LiceuService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConfiguration connection = new DatabaseConfiguration();
        var eleviDatabase =  new ElevDatabase(connection);
        var profesoriDatabase = new ProfesorDatabase(connection);
        var extrascolarDatabase = new ExtrascolarDatabase(connection);
        var saliDatabase = new SaliDatabase(connection);

        LiceuService liceu = new LiceuService("CNMV", "Pache Protopopescu", "Bucuresti", 9.47);
        AuditService auditService = new AuditService();

        System.out.println("--------------LICEU--------------");
        System.out.println(liceu);
        System.out.println("---------------------------------");
        System.out.println();

        //ELEVI
        try {
            liceu.adaugaElevi();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            for(Elev e : liceu.getElevi()) {
                eleviDatabase.createElev(new Elev(e.getCNP(), e.getNume(), e.getPrenume(), e.getVarsta(), e.getProfil(), e.getMedieIntrare(), e.getClasaRepartizata(), e.getNrOreStateLaLiceu()));
            } System.out.println("Elevi adaugati cu succes in baza de date!");
        } catch (Exception e) {
            System.out.println("A existat o eroare!");
        }

        System.out.println();
        liceu.seteazaProfilul();

        try {
            for (Elev e : liceu.getElevi()) {
                Elev elevToUpdate = new Elev();
                elevToUpdate.setCNP(e.getCNP());
                elevToUpdate.setNume(e.getNume());
                elevToUpdate.setPrenume(e.getPrenume());
                elevToUpdate.setVarsta(e.getVarsta());
                elevToUpdate.setProfil(e.getProfil());
                elevToUpdate.setMedieIntrare(e.getMedieIntrare());
                elevToUpdate.setClasaRepartizata(e.getClasaRepartizata());
                elevToUpdate.setNrOreStateLaLiceu(e.getNrOreStateLaLiceu());

                eleviDatabase.updateElev(elevToUpdate);
            }
                System.out.println("Update realizat cu succes in baza de date!");
        }catch (Exception e) {
            System.out.println("Update-ul nu a fost realizat in baza de date!");
        }

        System.out.println();
        System.out.println(eleviDatabase.readElevi());

        Elev elev = liceu.getElevi().get(0);
        try {
            eleviDatabase.deleteElev(new Elev(elev.getCNP(), elev.getNume(), elev.getPrenume(), elev.getVarsta(), elev.getProfil(), elev.getMedieIntrare(), elev.getClasaRepartizata(), elev.getNrOreStateLaLiceu()));
            System.out.println("Elev sters cu succes!");

        }catch (Exception e){
            System.out.println("A existat o eroare!");
        }



            //PROFESORI
        try {
            liceu.adaugaProfesor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            for(Profesor p : liceu.getProfesori()) {
                profesoriDatabase.createProfesor(new Profesor(p.getCNP(), p.getNume(), p.getPrenume(), p.getVarsta(), p.getMateriePredata(), p.getNumarOrePredate(), p.getSalariu()));
            } System.out.println("Profesori adaugati cu succes in baza de date!");
        } catch (Exception e) {
            System.out.println("A existat o eroare!");
        }

        System.out.println();
        liceu.marireSalariu();

        try {
            for (Profesor p : liceu.getProfesori()) {
                Profesor profesorToUpdate = new Profesor();
                profesorToUpdate.setCNP(p.getCNP());
                profesorToUpdate.setNume(p.getNume());
                profesorToUpdate.setPrenume(p.getPrenume());
                profesorToUpdate.setVarsta(p.getVarsta());
                profesorToUpdate.setMateriePredata(p.getMateriePredata());
                profesorToUpdate.setNumarOrePredate(p.getNumarOrePredate());
                profesorToUpdate.setSalariu(p.getSalariu());

                profesoriDatabase.updateProfesor(profesorToUpdate);
            }
                System.out.println("Update realizat cu succes in baza de date!");
        }catch (Exception e) {
            System.out.println("Update-ul nu a fost realizat in baza de date!");
        }

        System.out.println();
        System.out.println(profesoriDatabase.readProfesori());

        System.out.println();
        Profesor p = liceu.getProfesori().get(0);
        try {
            profesoriDatabase.deleteProfesor(new Profesor(p.getCNP(), p.getNume(), p.getPrenume(), p.getVarsta(), p.getMateriePredata(), p.getNumarOrePredate(), p.getSalariu()));
            System.out.println("Profesor sters cu succes!");

        }catch (Exception e){
            System.out.println("A existat o eroare!");
        }



        //SALI
        try {
            liceu.adaugaSali();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            for(Sali s : liceu.getSali()) {
                saliDatabase.createSali(new Sali(s.getDenumire(), s.geteOcupata(), s.getCapacitate(), s.getClasaRepartizata()));
            } System.out.println("Sali adaugate cu succes in baza de date!");
        } catch (Exception e) {
            System.out.println("A existat o eroare!");
        }

        System.out.println();
        liceu.seteazaSala();


        try {
            for (Sali s : liceu.getSali()) {
                Sali salaToUpdate = new Sali();
                salaToUpdate.setDenumire(s.getDenumire());
                salaToUpdate.seteOcupata(s.geteOcupata());
                salaToUpdate.setCapacitate(s.getCapacitate());
                salaToUpdate.setClasaRepartizata(s.getClasaRepartizata());

                saliDatabase.updateSala(salaToUpdate);
            }
                System.out.println("Update realizat cu succes in baza de date!");
        }catch (Exception e) {
            System.out.println("Update-ul nu a fost realizat in baza de date!");
        }

        System.out.println();
        System.out.println(saliDatabase.readSali());

        System.out.println();
        Sali s = liceu.getSali().get(0);
        try {
            saliDatabase.deleteSali(new Sali(s.getDenumire(), s.geteOcupata(), s.getCapacitate(), s.getClasaRepartizata()));
            System.out.println("Sala stersa cu succes!");

        }catch (Exception e){
            System.out.println("A existat o eroare!");
        }


        //EXTRASCOLAR
        try {
            liceu.adaugaExtrascolar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            for(Extrascolar extrascolar : liceu.getExtrascolar()) {
                extrascolarDatabase.createExtrascolar(new Extrascolar(extrascolar.getDenumire(), extrascolar.getZi(), extrascolar.getOra(), extrascolar.getNrElevi()));
            } System.out.println("Extrascolare adaugate cu succes in baza de date!");
        } catch (Exception e) {
            System.out.println("A existat o eroare!");
        }

        System.out.println();
        liceu.inscriereExtrascolar();


        try {
            for (Extrascolar ex : liceu.getExtrascolar()) {
                Extrascolar extraToUpdate = new Extrascolar();
                extraToUpdate.setDenumire(ex.getDenumire());
                extraToUpdate.setZi(ex.getZi());
                extraToUpdate.setOra(ex.getOra());
                extraToUpdate.setNrElevi(ex.getNrElevi());

                extrascolarDatabase.updateExtrascolar(extraToUpdate);
            }
            System.out.println("Update realizat cu succes in baza de date!");
        }catch (Exception e) {
            System.out.println("Update-ul nu a fost realizat in baza de date!");
        }

        System.out.println();
        System.out.println(extrascolarDatabase.readExtrascolar());

        System.out.println();
        Extrascolar extra = liceu.getExtrascolar().get(0);
        try {
            extrascolarDatabase.deleteExtrascolar(new Extrascolar(extra.getDenumire(), extra.getZi(), extra.getOra(),extra.getNrElevi()));
            System.out.println("Extrascolar sters cu succes!");

        }catch (Exception e){
            System.out.println("A existat o eroare!");
        }




//        adaugare sali
//        try {
//            saliDatabase.createSali(new Sali("Spiru Haret","true",30,""));
//            saliDatabase.createSali(new Sali("Pompeiu","false",35,""));
//            saliDatabase.createSali(new Sali("Titeica","false",20,""));
//            saliDatabase.createSali(new Sali("Google","true",40,""));
//            saliDatabase.createSali(new Sali("Eminescu","false",25,""));
//            saliDatabase.createSali(new Sali("Creanga","true",30,""));
//            saliDatabase.createSali(new Sali("Bacovia","false",35,""));
//            saliDatabase.createSali(new Sali("Arghezi","false",40,""));
//            saliDatabase.createSali(new Sali("Blaga","true",20,""));
//            System.out.println("Sali adaugate cu succes!");
//        } catch (Exception e){
//            System.out.println("A existat o eroare!");
//        }

//        citim sali
//        System.out.println(saliDatabase.readSali());

//        update
//        try {
//            Sali salaToUpdate = new Sali();
//            salaToUpdate.setDenumire("Pompeiu");
//            salaToUpdate.seteOcupata("true");
//            salaToUpdate.setCapacitate(30);
//            salaToUpdate.getClasaRepartizata();
//
//            saliDatabase.updateSala(salaToUpdate);
//            System.out.println("Update realizat cu succes in baza de date!");
//        }catch (Exception e){
//            System.out.println("Update-ul nu a fost realizat in baza de date!");
//        }

//        delete
//        try {
//            saliDatabase.deleteSali(new Sali("Spiru Haret","true",30,""));
//            saliDatabase.deleteSali(new Sali("Pompeiu","false",35,""));
//            saliDatabase.deleteSali(new Sali("Google","true",40,""));
//            saliDatabase.deleteSali(new Sali("Eminescu","false",25,""));
//            saliDatabase.deleteSali(new Sali("Creanga","true",30,""));
//            saliDatabase.deleteSali(new Sali("Bacovia","false",35,""));
//            saliDatabase.deleteSali(new Sali("Arghezi","false",40,""));
//            saliDatabase.deleteSali(new Sali("Blaga","true",20,""));
//
//            System.out.println("Stergerea realizata cu succes in baza de date!");
//        }catch (Exception e){
//            System.out.println("Stergerea a fost realizata in baza de date!");
//        }


//        adaugare extrascolar
//        try {
//            extrascolarDatabase.createExtrascolar(new Extrascolar("Cercul de matematica","Luni",16,0));
//            extrascolarDatabase.createExtrascolar(new Extrascolar("Cercul de biologie","Sambata",12,0));
//            extrascolarDatabase.createExtrascolar(new Extrascolar("Cercul de literatura","Vineri",14,0));
//            extrascolarDatabase.createExtrascolar(new Extrascolar("Cercul de logica","Miercuri",17,0));
//            System.out.println("Extrascolare adaugata cu succes!");
//        } catch (Exception e){
//            System.out.println("A existat o eroare!");
//        }

//        citim extrascolarele
//        System.out.println(extrascolarDatabase.readExtrascolar());

//        update
//        try {
//            Extrascolar extrascolarToUpdate = new Extrascolar();
//            extrascolarToUpdate.setDenumire("Cercul de matematica");
//            extrascolarToUpdate.setZi("Joi");
//            extrascolarToUpdate.setOra(16);
//            extrascolarToUpdate.setNrElevi(0);
//
//            extrascolarDatabase.updateExtrascolar(extrascolarToUpdate);
//            System.out.println("Update realizat cu succes in baza de date!");
//        }catch (Exception e){
//            System.out.println("Update-ul nu a fost realizat in baza de date!");
//        }

//        delete
//        try {
//            extrascolarDatabase.deleteExtrascolar(new Extrascolar("Cercul de biologie","Sambata",12,0));
//            extrascolarDatabase.deleteExtrascolar(new Extrascolar("Cercul de matematica","Luni",16,0));
//            extrascolarDatabase.deleteExtrascolar(new Extrascolar("Cercul de literatura","Vineri",14,0));
//            extrascolarDatabase.deleteExtrascolar(new Extrascolar("Cercul de logica","Miercuri",17,0));
//            System.out.println("Stergerea realizata cu succes in baza de date!");
//        }catch (Exception e){
//            System.out.println("Stergerea a fost realizata in baza de date!");
//        }


//        adaugare profesori
//        try{
//            profesoriDatabase.createProfesor(new Profesor(12345,"Matei","Teo",30,"MATEMATICA",30,3700));
//            profesoriDatabase.createProfesor(new Profesor(34567,"Popescu","Mihai",40,"INFORMATICA",50,6000));
//            profesoriDatabase.createProfesor(new Profesor(52411,"Tudor","Daniela",54,"CHIMIE",45,5300));
//            profesoriDatabase.createProfesor(new Profesor(98352,"Spirea","Gina",43,"BIOLOGIE",34,3930));
//            profesoriDatabase.createProfesor(new Profesor(95422,"Badescu","Nicoleta",40,"ROMANA",25,3200));
////            System.out.println("Profesori adaugati cu succes!");
//        }catch (Exception e){
//            System.out.println("A existat o eroare!");
//        }

//        citim profesorii
//        System.out.println(profesoriDatabase.readProfesori());

////        update
//        try {
//            Profesor profesorToUpdate = new Profesor();
//            profesorToUpdate.setCNP(95422);
//            profesorToUpdate.setNume("Badescu");
//            profesorToUpdate.setPrenume("Nicoleta");
//            profesorToUpdate.setVarsta(40);
//            profesorToUpdate.setMateriePredata("LATINA");
//            profesorToUpdate.setNumarOrePredate(25);
//            profesorToUpdate.setSalariu(3200);
//
//            profesoriDatabase.updateProfesor(profesorToUpdate);
//            System.out.println("Update realizat cu succes in baza de date!");
//        }catch (Exception e){
//            System.out.println("Update-ul nu a fost realizat in baza de date!");
//        }

//        delete
//        try {
//            profesoriDatabase.deleteProfesor(new Profesor(12345, "Matei","Teo",30,"MATEMATICA",30,3700));
//            profesoriDatabase.deleteProfesor(new Profesor(34567,"Popescu","Mihai",40,"INFORMATICA",50,6000));
//            profesoriDatabase.deleteProfesor(new Profesor(52411,"Tudor","Daniela",54,"CHIMIE",45,5300));
//            profesoriDatabase.deleteProfesor(new Profesor(98352,"Spirea","Gina",43,"BIOLOGIE",34,3930));
//            profesoriDatabase.deleteProfesor(new Profesor(95422,"Badescu","Nicoleta",40,"ROMANA",25,3200));
//            System.out.println("Stergerea realizata cu succes in baza de date!");
//        }catch (Exception e){
//            System.out.println("Stergerea a fost realizata in baza de date!");
//        }
        
//ETAPA 2

//
//        try {
//            liceu.adaugaElevi();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }


//        System.out.println("--------EXMATRICULAM ELEVI--------");
//        liceu.daAfaraElev("Ionescu", "Ana");
//        liceu.daAfaraElev("Popa", "Miriam");
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("----------PROFIL SETAT-----------");
//        liceu.seteazaProfilul();
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("-------------SALI---------------");
//        liceu.adaugaSali();
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        liceu.seteazaSala();
//
//        System.out.println("-----------CATALOAGE-------------");
//        liceu.faCataloage(liceu);
//        System.out.println("---------------------------------");
//
//        liceu.adaugaExtrascolar();
//
//        liceu.inscriereExtrascolar();
//
//        System.out.println("---------PREMIERE ELEVI----------");
//        try {
//            auditService.logAction(liceu.pleacaElev());
//        }catch(Exception e){
//            System.out.println(liceu.numarElevi());
//            System.out.println(e.toString());
//        }
//        System.out.println("---------------------------------");


//        ETAPA 1
//        Profesor profesor1 = new Profesor(12345, "Matei", "Teo", 30, "MATEMATICA", 30, 3700);
//        Profesor profesor2 = new Profesor(34567, "Popescu", "Mihai", 40, "INFORMATICA", 50, 6000);
//        Profesor profesor3 = new Profesor(52411, "Tudor", "Daniela", 54, "CHIMIE", 45, 5300);
//        Profesor profesor4 = new Profesor(98352, "Spirea", "Gina", 43, "BIOLOGIE", 34, 3930);
//        Profesor profesor5 = new Profesor(95422, "Badescu", "Nicoleta", 40, "ROMANA", 25, 3200);
//
//        liceu.adaugaProfesor(profesor1);
//        liceu.adaugaProfesor(profesor2);
//        liceu.adaugaProfesor(profesor3);
//        liceu.adaugaProfesor(profesor4);
//        liceu.adaugaProfesor(profesor5);
//
//        System.out.println("-----------PROFESORI-------------");
//        liceu.afiseazaProfesori();
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("-------CONCEDIEM PROFESORI-------");
//        liceu.daAfaraProfesor("Badescu", "Nicoleta");
//        liceu.daAfaraProfesor("Popescu", "Marian");
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("------PROFESORI ACTUALIZATI------");
//        liceu.afiseazaProfesori();
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("---------MARIRE SALARIU---------");
//        liceu.marireSalariu();
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        Elev elev1 = new Elev(54131, "Iftimi", "Ruxandra", 14, "", 9.98, "9B", 0);
//        Elev elev3 = new Elev(61336, "Stefanoiu", "Rares", 15, "", 9.9, "9A", 0);
//        Elev elev2 = new Elev(98012, "Barbu", "Robert", 14, "", 9.75, "9D", 0);
//        Elev elev5 = new Elev(73415, "Pop", "Andreea", 15, "", 9.89, "9C", 0);
//        Elev elev4 = new Elev(91374, "Marin", "Oana", 15, "", 9.93, "9D", 0);
//        Elev elev7 = new Elev(54131, "Berbecaru", "Andrei", 15, "", 9.94, "9C", 0);
//        Elev elev6 = new Elev(42438, "Ionescu", "Radu", 14, "", 10, "9B", 0);
//        Elev elev9 = new Elev(97012, "Vasile", "Mihai", 15, "", 9.65, "9A", 0);
//        Elev elev8 = new Elev(64121, "Cristea", "Tudor", 14, "", 9.59, "9A", 0);
//        Elev elev10 = new Elev(82349, "Anghel", "Darius", 15, "", 9.81, "9B", 0);
//        Elev elev11 = new Elev(32083, "Moise", "Marian", 15, "", 9.76, "9D", 0);
//        Elev elev12 = new Elev(98236, "Bobo", "Maria", 14, "", 9.49, "9C", 0);
//        Elev elev13 = new Elev (89131, "Ionescu", "Ana", 14, "", 9.65, "9A",  0);
//
//        liceu.adaugaElevi(elev1);
//        liceu.adaugaElevi(elev2);
//        liceu.adaugaElevi(elev3);
//        liceu.adaugaElevi(elev4);
//        liceu.adaugaElevi(elev5);
//        liceu.adaugaElevi(elev6);
//        liceu.adaugaElevi(elev7);
//        liceu.adaugaElevi(elev8);
//        liceu.adaugaElevi(elev9);
//        liceu.adaugaElevi(elev10);
//        liceu.adaugaElevi(elev11);
//        liceu.adaugaElevi(elev12);
//        liceu.adaugaElevi(elev13);
//
//
//        System.out.println("-------------ELEVI---------------");
//        liceu.afiseazaElevi();
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("--------EXMATRICULAM ELEVI--------");
//        liceu.daAfaraElev("Ionescu", "Ana");
//        liceu.daAfaraElev("Popa", "Miriam");
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("--------ELEVI ACTUALIZATI----------");
//        for(Elev e: liceu.getElevi())
//            liceu.seteazaProfilul(e);
//        System.out.println("---------------------------------");
//        System.out.println();
//
//        System.out.println("-----------CATALOAGE-------------");
//        liceu.faCataloage(liceu);
//        System.out.println("---------------------------------");
//        System.out.println();

    }
}