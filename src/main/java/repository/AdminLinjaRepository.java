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
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
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
        statement.close();
        return studentList;

    }
    // vendosja e nje studenti te ri ne databaze(add)
    public static AdminOraret insert(CreateAdminOraretDto oraret) throws SQLException {
        String addSql = "INSERT INTO oraret(company_name, prej ,deri, koha_nisjes, koha_arritjes, cmimi_biletes) VALUES (?,?,?,?,?,?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(addSql);

        statement.setString(1, oraret.getCompanyName());
        statement.setString(2, oraret.getVendiNisjes());
        statement.setString(3, oraret.getDestinacioni());
        statement.setString(4, oraret.getKohaNisjes());
        statement.setString(5, oraret.getKohaArritjes());
        statement.setString(6, oraret.getCmimiBiletes());


        statement.executeUpdate();
        return AdminLinjaRepository.getByCompanyName(oraret.getCompanyName());

    }

    // perditesimi-editimi i nje studenti
    public static boolean updateOrarin(UpdateOrariDto orariDto) throws SQLException{
        String updatesql = "UPDATE oraret SET company_name=?, prej=?, deri=?, koha_nisjes=?, koha_arritjes=?, cmimi_biletes=? WHERE id=?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(updatesql) ;

        statement.setString(1, orariDto.getCompany_name());
        statement.setString(2, orariDto.getVend_nisja());
        statement.setString(3, orariDto.getDestinacioni());
        statement.setString(4, orariDto.getKohaNisjes());
        statement.setString(5, orariDto.getKohaArritjes());
        statement.setString(6, orariDto.getCmimi_biletes());
        statement.setInt(7, orariDto.getId());

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Schedule updated successfully.");
        } else {
            System.out.println("Failed to update schedule.");
        }

        return rowsAffected>0;
    }

    // filtrimi i nje orari permes emres se kompanise
    public static List<AdminOraret> filterTable(Connection connection, CreateAdminOraretDto model) throws SQLException {
        List<AdminOraret> studentList = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM oraret WHERE 1=1");

        if (model.getOrariID() != 0) {
            sqlBuilder.append(" AND orari_id= ?");
        }
        if (model.getCompanyName() != null && !model.getCompanyName().isEmpty()) {
            sqlBuilder.append(" AND company_name LIKE ?");
        }

        PreparedStatement statement = connection.prepareStatement(sqlBuilder.toString());
        int parameterIndex = 1;

        if (model.getOrariID()!=0 ) {
            statement.setInt(parameterIndex++,  model.getOrariID());
        }

        if (model.getCompanyName() != null && !model.getCompanyName().isEmpty()) {
            statement.setString(parameterIndex++, "%" + model.getCompanyName() + "%");
        }
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int orariID = resultSet.getInt("orari_id");
            String companyName = resultSet.getString("company_name");
            String prej = resultSet.getString("prej");
            String deri = resultSet.getString("deri");
            String kohaNisjes = resultSet.getString("koha_nisjes");
            String kohaArritjes = resultSet.getString("koha_arritjes");
            String cmimiBiletes = resultSet.getString("cmimi_biletes");

            // Create an instance of AdminStudent with retrieved data
            AdminOraret student = new AdminOraret(orariID, companyName, prej, deri, kohaNisjes, kohaArritjes, cmimiBiletes);
            studentList.add(student);
        }

        resultSet.close();
        statement.close();

        return studentList;
    }


    public static AdminOraret getByCompanyName(String companyName) throws SQLException {
        String sql = "SELECT * FROM oraret WHERE company_name=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            ResultSet resultSet = statement.executeQuery();
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