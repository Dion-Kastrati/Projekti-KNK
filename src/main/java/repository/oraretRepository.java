package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Oraret;
import models.dto.CreateOraretDto;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class oraretRepository {
    public static Oraret insert(CreateOraretDto Oraret) throws SQLException{
        String sql = "INSERT INTO oraret(prej,deri,koha_nisjes,koha_arritjes,cmimi_biletes) values(?,?,?,?,?)";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,Oraret.getVendiNisjes());
        preparedStatement.setString(2,Oraret.getDestinacioni());
        preparedStatement.setString(3,Oraret.getKohaNisjes());
        preparedStatement.setString(4,Oraret.getKohaArritjes());
        preparedStatement.setString(5,Oraret.getCmimiBiletes());
        preparedStatement.executeUpdate();

        // TODO: Me ndreq qe me kthy diqka te tipit Oraret;
        return null;
    }

}
