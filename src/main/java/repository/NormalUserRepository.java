package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import models.Oraret;
import services.ConnectionUtil;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class NormalUserRepository {

    public static ObservableList<String> vendNisja() throws SQLException {
        ObservableList<String> prejList = FXCollections.observableArrayList();
        try{
            String sql = "SELECT DISTINCT prej FROM oraret";
            Connection conn = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String prej = resultSet.getString("prej");
                prejList.add(prej);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return prejList;
    }

    public static ObservableList<String> destinacioni() throws SQLException {
        ObservableList<String> deriList = FXCollections.observableArrayList();
        try{
            String sql = "SELECT DISTINCT deri FROM oraret";
            Connection conn = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String prej = resultSet.getString("deri");
                deriList.add(prej);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deriList;
    }


    public static Oraret getOrarinPrejDeri(String vendNisja, String destinacioni) throws SQLException {
//        System.out.printf("Vend Nisja %s - Destinacioni %s", vendNisja, destinacioni);
        String sql = """
                    SELECT *
                    FROM oraret
                    WHERE o.prej = ? 
                    AND o.deri = ?;
                """;
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
        preparedStatement.setObject(1,vendNisja.toString());
        preparedStatement.setObject(2,destinacioni.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.printf("Vend Nisja %s - Destinacioni %s", vendNisja, destinacioni);
            int orariID = resultSet.getInt("orari_id");
            String companyName = resultSet.getString("company_name");
            int kohaNisjes = resultSet.getInt("koha_nisjes");
            int kohaArritjes = resultSet.getInt("koha_arritjes");
            double cmimiBiletes = resultSet.getDouble("cmimi_biletes");
            System.out.printf("Company Name %s - Koha nisjes %s - Koha Arritjes %s - Cmimi i Biletes %s", companyName, kohaNisjes, kohaArritjes, cmimiBiletes);
            return new Oraret(orariID, companyName ,vendNisja, destinacioni , kohaNisjes, kohaArritjes, cmimiBiletes);
        }
        else{
            System.out.println("Nuk ka gjete te dhena for whatever reason");
            return null;
        }

    }
    public static ObservableList<Oraret> fetchDataFromDatabase() {
        ObservableList<Oraret> oraretList = FXCollections.observableArrayList();

        try {

            // Create the SQL statement
            String sql = "SELECT * FROM oraret";
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                int oraretId = resultSet.getInt("orari_id");
                String companyName = resultSet.getString("company_name");
                String from = resultSet.getString("prej");
                String to = resultSet.getString("deri");
                int departureTime = resultSet.getInt("koha_nisjes");
                int arrivalTime = resultSet.getInt("koha_arritjes");
                double ticketPrice = resultSet.getDouble("cmimi_biletes");

                Oraret oraret = new Oraret(oraretId, companyName, from, to, departureTime, arrivalTime, ticketPrice);
                oraretList.add(oraret);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oraretList;
    }
}
