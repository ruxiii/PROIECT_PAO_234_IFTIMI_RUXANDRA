package model.Persoana.Profesor;

import config.DatabaseConfiguration;
import constants.Constants;
import model.Persoana.Elev.Elev;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

public class ProfesorDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public ProfesorDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public ArrayList<Profesor> readProfesori() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Profesor> profesori = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOTI_PROFESORII);
            while(resultSet.next()) {
                Profesor curent = new Profesor(resultSet.getInt("CNP"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getInt("varsta"),
                        resultSet.getString("materiePredata"),
                        resultSet.getInt("numarOrePredate"),
                        resultSet.getInt("salariu")
                );
                profesori.add(curent);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return profesori;
    }

    public void updateProfesor(Profesor profesor){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_PROFESOR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, profesor.getNume());
            preparedStmt.setString(2, profesor.getPrenume());
            preparedStmt.setInt(3, profesor.getVarsta());
            preparedStmt.setString(4, profesor.getMateriePredata());
            preparedStmt.setInt(5, profesor.getNumarOrePredate());
            preparedStmt.setInt(6, profesor.getSalariu());
            preparedStmt.setInt(7, profesor.getCNP());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createProfesor(Profesor profesor) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_PROFESOR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, profesor.getCNP());
            preparedStmt.setString(2, profesor.getNume());
            preparedStmt.setString(3, profesor.getPrenume());
            preparedStmt.setInt(4, profesor.getVarsta());
            preparedStmt.setString(5, profesor.getMateriePredata());
            preparedStmt.setInt(6, profesor.getNumarOrePredate());
            preparedStmt.setInt(7, profesor.getSalariu());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteProfesor(Profesor profesor){
        try{
            String query = Constants.QUERY_STERGE_PROFESOR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, profesor.getCNP());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
