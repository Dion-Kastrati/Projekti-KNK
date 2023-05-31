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

    public static ObservableList<String> from() throws SQLException  {
        ObservableList<String> prejList = FXCollections.observableArrayList();

        try {
            // Create the SQL statement
            String sql = "SELECT DISTINCT prej FROM oraret";
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            // Process the result set and add values to the prejList
            while (resultSet.next()) {
                String prej = resultSet.getString("prej");
                prejList.add(prej);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prejList;
    }

    public static ObservableList<String> to() throws SQLException {
        ObservableList<String> deriList = FXCollections.observableArrayList();

        try {
            // Create the SQL statement
            String sql = "SELECT DISTINCT deri FROM oraret";
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            // Process the result set and add values to the prejList
            while (resultSet.next()) {
                String prej = resultSet.getString("deri");
                deriList.add(prej);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deriList;
    }


    public static ObservableList<Oraret> getOrarinPrejDeri(String from, String to) throws SQLException {
        ObservableList<Oraret> oraretFilter = FXCollections.observableArrayList();
        try{
        String sql = """
                    SELECT *
                    FROM oraret
                    WHERE prej = ? 
                    AND deri = ?;
                """;
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
        preparedStatement.setObject(1,from.toString());
        preparedStatement.setObject(2,to.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
//            System.out.printf("Vend Nisja %s - Destinacioni %s", from, to);
            int orariID = resultSet.getInt("orari_id");
            String companyName = resultSet.getString("company_name");
            String departureTime = resultSet.getString("koha_nisjes");
            String arrivalTime = resultSet.getString("koha_arritjes");
            double ticketPrice = resultSet.getDouble("cmimi_biletes");
            Oraret oraret = new Oraret(orariID, companyName, from, to, departureTime, arrivalTime, ticketPrice);
            oraretFilter.add(oraret);
        }
        // Close resources
        resultSet.close();
        preparedStatement.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

        return oraretFilter;
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
                String  departureTime = resultSet.getString("koha_nisjes");
                String arrivalTime = resultSet.getString("koha_arritjes");
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
