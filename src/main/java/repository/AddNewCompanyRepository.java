package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.AdminCompany;
import models.AdminOraret;
import models.dto.CreateKompaniDto;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddNewCompanyRepository {
    public static AdminCompany insert(CreateKompaniDto company) throws SQLException {
        String sql = "INSERT INTO autobuset (company_name) values (?)";
        Connection connection = ConnectionUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, company.getCompanyName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw e;
        }
        return AddNewCompanyRepository.getByCompanyName(company.getCompanyName());
    }

    public static ObservableList<AdminCompany> filterCompany(String company_name) throws SQLException{
        ObservableList<AdminCompany> kompanite = FXCollections.observableArrayList();
        String sql = "SELECT bus_id, company_name FROM autobuset WHERE company_name = ?";
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,company_name);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int comp_id = resultSet.getInt("bus_id");
                String comp_name = resultSet.getString("company_name");
                AdminCompany companyName = new AdminCompany(comp_id, comp_name);
                kompanite.add(companyName);
            }
        }catch (SQLException e){
            throw e;
        }
        return kompanite;
    }

    public static AdminCompany getByCompanyName(String companyName) throws SQLException {
        String sql = "SELECT bus_id, company_name FROM autobuset WHERE company_name=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int busId = resultSet.getInt("bus_id");
                String company_name = resultSet.getString("company_name");
                return new AdminCompany(busId,company_name);
            } else {
                return null;
            }
        }
    }

}
