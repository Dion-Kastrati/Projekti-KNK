package repository;

import models.Oraret;
import models.dto.CreateOraretDto;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class oraretRepository {
    public Oraret inser(CreateOraretDto Oraret) throws SQLException{
        String sql = "INSERT INTO oraret(prej,deri,koha_nisjes,koha_arritjes,cmimi_biletes) values(?,?,?,?,?)";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,Oraret.getPrej());
        preparedStatement.setString(2,Oraret.getDeri());
        preparedStatement.setString(3,Oraret.getKohaNisjes());
        preparedStatement.setString(4,Oraret.getKohaArritjes());
        preparedStatement.setDouble(5,Oraret.getCmimiBiletes());
        preparedStatement.executeUpdate();

        // TODO: Me ndreq qe me kthy diqka te tipit Oraret;
        return null;
    }

    public static Oraret getOrarinPrejDeri(String prej, String deri) throws SQLException {
        String sql = """
                    SELECT a.bus_company "Emri i kompanise", o.koha_nisjes as "Koha e nisjes",
                     o.koha_arritjes as "Koha e Arritjes",
                     o.cmimi_biletes as "Cmimi i Biletes"
                     FROM oraret o
                    INNER JOIN bus_company a ON o.bus_id = a.bus_id
                    WHERE o.prej = ? AND o.deri = ?;
                """;
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,prej);
        preparedStatement.setString(2,deri);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            // TODO: Me i shfaq me ni tabele qe e kemi te krijume prej scene builder
            System.out.printf("Company Name - Koha nisjes - Koha Arritjes - Cmimi i Biletes");
            int busId = resultSet.getInt("bus_id");
            String kohaNisjesStr = resultSet.getString("koha_nisjes");
            LocalTime kohaNisjes = LocalTime.parse(kohaNisjesStr);
            String kohaArritjesStr = resultSet.getString("koha_arritjes");
            LocalTime kohaArritjes = LocalTime.parse(kohaArritjesStr);
            double cmimiBiletes = resultSet.getDouble("cmimi_biletes");
            return new Oraret(busId, prej, deri, kohaNisjes, kohaArritjes, cmimiBiletes);
        }
        else{
            return null;
        }

    }


}
