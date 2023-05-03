# PROIECT_PAO_234_IFTIMI_RUXANDRA

Aplicatia reprezinta gestiunea unui liceu, mai precis a claselor a 9-a. Avem clasa LICEU in care adaugam/exmatriculam/afisam elevii, adaugam/dam afara/afisam profesorii sau le modificam salariul, setam profilul elevilor (mate-info/stiintele naturii) si facem catoagele pentru fiecare clasa a 9-a przenta in acest liceu.


ACTIUNI/INTEROGARI:
  - adaugaProfesor(Profesor p) => adaugam un profesor
  - daAfaraProfesor(String n, String p) => dam afara un profesor din liceu
  - marireSalariu() => marim salariul profesorilor care au un salariu mai mikc de 4000 lei
  - afiseazaProfesori() => afisam toti profesorii care predau in liceu
  - adaugaElevi(Elev e) => adaugam un elev
  - daAfaraElev(String n, String p) => exmatriculam un elev
  - seteazaProfilul(Elev e) => setam profilul (mate-info/stiintedle naturii) unui elev in functie de clasa in care a fost repartizat
  - afiseazaElevi() => afisam toti elevii de clasa a 9-a din liceu
  - faCataloage(LiceuService liceu) => facem cataloagele pentru fiecare clasa de a 9-a, unde toti elevii sunt ordonati alfabetic
  - adaugaCatalog(String clasa, List<String> nume) => adaugam in catalog elevul x care este in clasa y


  
OBIECTE:
  - Catalog
  - Clasa
  - Persoana
  - Elev (mosteneste din Persoana)
  - Profesor (mosteneste din Persoana)
  - Profil
  - MateInfo (mosteneste din Profil)
  - StiinteleNaturii (mosteneste din Profil)
  - LiceuService
  - Main
