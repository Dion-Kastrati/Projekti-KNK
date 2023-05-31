package repository;
import models.AdminOraret;
import models.dto.CreateAdminOraretDto;
import models.dto.CreateOraretDto;
import models.dto.UpdateOrariDto;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminLinjaRepository {
    //marrja e te dhenave nga databaza
    public static List<AdminOraret> getOraret(Connection connection) throws SQLException {
        List<AdminOraret> studentList = new ArrayList<>();
        String sql = "Select * from tbl_students";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int orariID = resultSet.getInt("Id");
            String company_name = resultSet.getString("company_name");
            String prej = resultSet.getString("prej");
            String deri = resultSet.getString("deri");
            String kohaNisjes = resultSet.getString("koha_nisjes");
            String kohaArritjes = resultSet.getString("koha_arritjes");
            String cmimiBiletes = resultSet.getString("cmimi_biletes");

            AdminOraret studentModel = new AdminOraret(orariID,company_name,prej,deri,kohaNisjes,kohaArritjes,cmimiBiletes);
            studentList.add(studentModel);
        }
        resultSet.close();
        preparedStatement.close();
        return studentList;

    }
    // vendosja e nje studenti te ri ne databaze(add)
    public static AdminOraret insert(CreateAdminOraretDto oraret) throws SQLException {
        String addSql = "INSERT INTO oraret(company_name, prej ,deri, koha_nisjes, koha_arritjes, cmimi_biletes) VALUES (?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(addSql);

        preparedStatement.setString(1, oraret.getCompanyName());
        preparedStatement.setString(2, oraret.getVendiNisjes());
        preparedStatement.setString(3, oraret.getDestinacioni());
        preparedStatement.setString(4, oraret.getKohaNisjes());
        preparedStatement.setString(5, oraret.getKohaArritjes());
        preparedStatement.setString(6, oraret.getCmimiBiletes());

        preparedStatement.executeUpdate();
        return AdminLinjaRepository.getByCompanyName(oraret.getCompanyName());

    }

    // perditesimi i nje orari
//    public static boolean updateOrarin(UpdateOrariDto orariDto) throws SQLException{
//        String updatesql = "UPDATE oraret SET company_name=?, prej=?, deri=?, koha_nisjes=?, koha_arritjes=?, cmimi_biletes=? WHERE id=?";
//        Connection connection = ConnectionUtil.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(updatesql) ;
//
//        preparedStatement.setString(1, orariDto.getCompany_name());
//        preparedStatement.setString(2, orariDto.getVend_nisja());
//        preparedStatement.setString(3, orariDto.getDestinacioni());
//        preparedStatement.setString(4, orariDto.getKohaNisjes());
//        preparedStatement.setString(5, orariDto.getKohaArritjes());
//        preparedStatement.setString(6, orariDto.getCmimi_biletes());
//        preparedStatement.setInt(7, orariDto.getId());
//
//        int rowsAffected = preparedStatement.executeUpdate();
//
//        if (rowsAffected > 0) {
//            System.out.println("Schedule updated successfully.");
//        } else {
//            System.out.println("Failed to update schedule.");
//        }
//
//        return rowsAffected>0;
//    }



    public static AdminOraret getByCompanyName(String companyName) throws SQLException {
        String sql = "SELECT * FROM oraret WHERE company_name=?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, companyName);
                ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int orariId = resultSet.getInt("orari_id");
                String company_name = resultSet.getString("company_name");
                String prej = resultSet.getString("prej");
                String deri = resultSet.getString("deri");
                String kohaNisjes = resultSet.getString("koha_nisjes");
                String kohaArritjes = resultSet.getString("koha_arritjes");
                String cmimiBiletes = resultSet.getString("cmimi_biletes");
                return new AdminOraret(orariId,company_name,prej,deri,kohaNisjes,kohaArritjes,cmimiBiletes);
            } else {
                return null;
            }
        }
    }
}