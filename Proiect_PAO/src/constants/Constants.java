package constants;

public class Constants {
    public static final String QUERY_TOTI_ELEVII = "SELECT * FROM liceu.elevi";

    public static final String QUERY_ACTUALIZEAZA_ELEV = "UPDATE liceu.elevi SET nume = ?, prenume = ?, varsta = ?, profil = ?, medieIntrare = ?, clasaRepartizata = ?, nrOreStateLaLiceu = ? WHERE CNP=?";

    public static final String QUERY_CREAZA_ELEV = "INSERT INTO liceu.elevi (CNP, nume, prenume, varsta, profil, medieIntrare, clasaRepartizata, nrOreStateLaLiceu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_STERGE_ELEV = "DELETE FROM liceu.elevi WHERE CNP = ?";

    public static final String QUERY_TOTI_PROFESORII = "SELECT * FROM liceu.profesori";

    public static final String QUERY_ACTUALIZEAZA_PROFESOR = "UPDATE liceu.profesori SET nume = ?, prenume = ?, varsta = ?, materiePredata = ?, numarOrePredate = ?, salariu = ? WHERE CNP=?";

    public static final String QUERY_CREAZA_PROFESOR = "INSERT INTO liceu.profesori (CNP, nume, prenume, varsta, materiePredata, numarOrePredate, salariu) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_STERGE_PROFESOR = "DELETE FROM liceu.profesori WHERE CNP = ?";

    public static final String QUERY_TOATE_EXTRASCOLARELE = "SELECT * FROM liceu.extrascolar";

    public static final String QUERY_ACTUALIZEAZA_EXTRASCOLAR = "UPDATE liceu.extrascolar SET zi = ?, ora = ?, nrElevi = ? WHERE denumire=?";

    public static final String QUERY_CREAZA_EXTRASCOLAR = "INSERT INTO liceu.extrascolar (denumire, zi, ora, nrElevi) VALUES (?, ?, ?, ?)";

    public static final String QUERY_STERGE_EXTRASCOLAR = "DELETE FROM liceu.extrascolar WHERE denumire = ?";

    /////////////////
    public static final String QUERY_TOATE_SALILE = "SELECT * FROM liceu.sali";

    public static final String QUERY_ACTUALIZEAZA_SALA = "UPDATE liceu.sali SET eOcupata = ?, capacitate = ?, clasaRepartizata = ? WHERE denumire=?";

    public static final String QUERY_CREAZA_SALA = "INSERT INTO liceu.sali (denumire, eOcupata, capacitate, clasaRepartizata) VALUES (?, ?, ?, ?)";

    public static final String QUERY_STERGE_SALA = "DELETE FROM liceu.sali WHERE denumire = ?";


}
