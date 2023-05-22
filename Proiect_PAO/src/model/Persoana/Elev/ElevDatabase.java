package model.Persoana.Elev;

import java.sql.*;
import java.util.ArrayList;
import config.DatabaseConfiguration;
import constants.Constants;

public class ElevDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public ElevDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public  ArrayList<Elev> readElevi() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Elev> elevi = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOTI_ELEVII);
            while(resultSet.next()) {
                Elev curent = new Elev(resultSet.getInt("CNP"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getInt("varsta"),
                        resultSet.getString("profil"),
                        resultSet.getDouble("medieIntrare"),
                        resultSet.getString("clasaRepartizata"),
                        resultSet.getInt("nrOreStateLaLiceu")
                );
                elevi.add(curent);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return elevi;
    }

    public void updateElev(Elev elev){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_ELEV;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, elev.getNume());
            preparedStmt.setString(2, elev.getPrenume());
            preparedStmt.setInt(3, elev.getVarsta());
            preparedStmt.setString(4, elev.getProfil());
            preparedStmt.setDouble(5, elev.getMedieIntrare());
            preparedStmt.setString(6, elev.getClasaRepartizata());
            preparedStmt.setInt(7, elev.getNrOreStateLaLiceu());
            preparedStmt.setInt(8, elev.getCNP());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createElev(Elev elev) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_ELEV;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, elev.getCNP());
            preparedStmt.setString(2, elev.getNume());
            preparedStmt.setString(3, elev.getPrenume());
            preparedStmt.setInt(4, elev.getVarsta());
            preparedStmt.setString(5, elev.getProfil());
            preparedStmt.setDouble(6, elev.getMedieIntrare());
            preparedStmt.setString(7, elev.getClasaRepartizata());
            preparedStmt.setInt(8, elev.getNrOreStateLaLiceu());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteElev(Elev elev){
        try{
            String query = Constants.QUERY_STERGE_ELEV;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, elev.getCNP());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
