package model.Extrascolar;

import config.DatabaseConfiguration;
import constants.Constants;
import model.Persoana.Elev.Elev;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExtrascolarDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public ExtrascolarDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public ArrayList<Extrascolar> readExtrascolar() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Extrascolar> extra = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOATE_EXTRASCOLARELE);
            while(resultSet.next()) {
                Extrascolar curent = new Extrascolar(resultSet.getString("denumire"),
                        resultSet.getString("zi"),
                        resultSet.getInt("ora"),
                        resultSet.getInt("nrElevi")
                );
                extra.add(curent);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return extra;
    }

    public void updateExtrascolar(Extrascolar extrascolar){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_EXTRASCOLAR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, extrascolar.getZi());
            preparedStmt.setInt(2, extrascolar.getOra());
            preparedStmt.setInt(3, extrascolar.getNrElevi());
            preparedStmt.setString(4, extrascolar.getDenumire());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createExtrascolar(Extrascolar extrascolar) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_EXTRASCOLAR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, extrascolar.getDenumire());
            preparedStmt.setString(2, extrascolar.getZi());
            preparedStmt.setInt(3, extrascolar.getOra());
            preparedStmt.setInt(4, extrascolar.getNrElevi());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteExtrascolar(Extrascolar extrascolar){
        try{
            String query = Constants.QUERY_STERGE_EXTRASCOLAR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, extrascolar.getDenumire());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
