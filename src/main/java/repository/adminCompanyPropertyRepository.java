package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.AdminCompanyProperty;
import models.dto.CreateKompaniDto;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminCompanyPropertyRepository {

     public static ObservableList<AdminCompanyProperty> fetchDataFromDatabase(){
         ObservableList<AdminCompanyProperty> comps = FXCollections.observableArrayList();
         try {
             // Create the SQL statement
             String sql = "SELECT bus_id, company_name FROM autobuset";
             Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

             // Execute the query
             ResultSet resultSet = preparedStatement.executeQuery(sql);

             // Process the result set
             while (resultSet.next()) {
                 int companyId = resultSet.getInt("bus_id");
                 String companyName = resultSet.getString("company_name");
                 AdminCompanyProperty companies = new AdminCompanyProperty(companyId, companyName);
                 comps.add(companies);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return comps;
     }

    public static AdminCompanyProperty insert(CreateKompaniDto kompani) throws SQLException {
        String addSql = "INSERT INTO autobuset(company_name) VALUES (?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(addSql);

        statement.setString(1, kompani.getCompanyName());

        statement.executeUpdate();
        return adminCompanyPropertyRepository.getByCompanyName(kompani.getCompanyName());

    }

    public static AdminCompanyProperty getByCompanyName(String companyName) throws SQLException {
        String sql = "SELECT * FROM oraret WHERE company_name=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int orariId = resultSet.getInt("orari_id");
                String company_name = resultSet.getString("company_name");
                return new AdminCompanyProperty(orariId,company_name);
            } else {
                return null;
            }
        }
    }

    }
