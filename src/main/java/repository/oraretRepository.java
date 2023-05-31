package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.AdminOraret;
import models.Oraret;
import models.dto.CreateAdminOraretDto;
import models.dto.CreateOraretDto;
import repository.interfaces.OraretRepositoryInterface;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class oraretRepository{
    public static Oraret insert(CreateOraretDto Oraret) throws SQLException{
        String sql = "INSERT INTO oraret(prej,deri,koha_nisjes,koha_arritjes,cmimi_biletes) values(?,?,?,?,?)";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,Oraret.getVendiNisjes());
        preparedStatement.setString(2,Oraret.getDestinacioni());
        preparedStatement.setString(3,Oraret.getKohaNisjes());
        preparedStatement.setString(4,Oraret.getKohaArritjes());
        preparedStatement.setDouble(5,Oraret.getCmimiBiletes());
        preparedStatement.executeUpdate();

        return new Oraret(Oraret.getOrariID(), Oraret.getCompanyName(),Oraret.getVendiNisjes(),Oraret.getDestinacioni(),Oraret.getKohaNisjes(),Oraret.getKohaArritjes(), Oraret.getCmimiBiletes());
    }

    public static ObservableList<String> selectCompanies() throws SQLException{
        ObservableList<String> kompanite = FXCollections.observableArrayList();
        try{
            String sql = "SELECT DISTINCT company_name FROM autobuset";
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery(sql);
        while(resultSet.next()){
            String companyName = resultSet.getString("company_name");
            kompanite.add(companyName);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return kompanite;

    }

    public static AdminOraret insert(CreateAdminOraretDto oraret) throws SQLException {
        String addSql = "INSERT INTO oraret(company_name, prej ,deri, koha_nisjes, koha_arritjes, cmimi_biletes) VALUES (?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(addSql);)
        {
            preparedStatement.setString(1, oraret.getCompanyName());
            preparedStatement.setString(2, oraret.getVendiNisjes());
            preparedStatement.setString(3, oraret.getDestinacioni());
            preparedStatement.setString(4, oraret.getKohaNisjes());
            preparedStatement.setString(5, oraret.getKohaArritjes());
            preparedStatement.setString(6, oraret.getCmimiBiletes());

            preparedStatement.executeUpdate();
            return AdminLinjaRepository.getByCompanyName(oraret.getCompanyName());
        }catch (SQLException e){
            throw e;
        }
    }
}
