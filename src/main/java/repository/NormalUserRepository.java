package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Oraret;
import services.ConnectionUtil;

import java.sql.*;
import java.time.LocalTime;

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
                    SELECT o.bus_id, a.company_name, o.koha_nisjes, o.koha_arritjes, o.cmimi_biletes
                    FROM oraret o
                    INNER JOIN bus_company a ON o.bus_id = a.company_id
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
            // TODO: Me i shfaq me ni tabele qe e kemi te krijume prej scene builder
            int busId = resultSet.getInt("bus_id");
            String kohaNisjesStr = resultSet.getString("koha_nisjes");
            String companyName = resultSet.getString("company_name");
            String kohaNisjes = resultSet.getString("koha_nisjes");
            String kohaArritjes = resultSet.getString("koha_arritjes");
            double cmimiBiletes = resultSet.getDouble("cmimi_biletes");
            System.out.printf("Company Name %s - Koha nisjes %s - Koha Arritjes %s - Cmimi i Biletes %s", companyName, kohaNisjes, kohaArritjes, cmimiBiletes);
            return new Oraret(busId, vendNisja, destinacioni , kohaNisjes, kohaArritjes, cmimiBiletes);
        }
        else{
            System.out.println("Nuk ka gjete te dhena for whatever reason");
            return null;
        }

    }
}
