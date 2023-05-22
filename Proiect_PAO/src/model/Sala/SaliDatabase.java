package model.Sala;

import config.DatabaseConfiguration;
import constants.Constants;
import model.Persoana.Elev.Elev;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SaliDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public SaliDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public ArrayList<Sali> readSali() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Sali> sali = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOATE_SALILE);
            while(resultSet.next()) {
                Sali curent = new Sali(resultSet.getString("denumire"),
                        resultSet.getString("eOcupata"),
                        resultSet.getInt("capacitate"),
                        resultSet.getString("clasaRepartizata")
                );
                sali.add(curent);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return sali;
    }

    public void updateSala(Sali sali){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_SALA;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, sali.geteOcupata());
            preparedStmt.setInt(2, sali.getCapacitate());
            preparedStmt.setString(3, sali.getClasaRepartizata());
            preparedStmt.setString(4, sali.getDenumire());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createSali(Sali sali) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_SALA;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, sali.getDenumire());
            preparedStmt.setString(2, sali.geteOcupata());
            preparedStmt.setInt(3, sali.getCapacitate());
            preparedStmt.setString(4, sali.getClasaRepartizata());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteSali(Sali sali){
        try{
            String query = Constants.QUERY_STERGE_SALA;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, sali.getDenumire());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
