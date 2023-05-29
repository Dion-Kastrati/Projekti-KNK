package repository;

import models.AdminKompanite;
import models.AdminOraret;
import models.dto.CreateKompaniDto;
import models.dto.CreateOraretDto;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminKompaniRepository {

    public static AdminKompanite insert(CreateKompaniDto kompani) throws SQLException {
        String addSql = "INSERT INTO autobuset(company_name) VALUES (?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(addSql);

        statement.setString(1, kompani.getCompanyName());

        statement.executeUpdate();
        return AdminKompaniRepository.getByCompanyName(kompani.getCompanyName());

    }

    public static AdminKompanite getByCompanyName(String companyName) throws SQLException {
        String sql = "SELECT * FROM oraret WHERE company_name=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int orariId = resultSet.getInt("orari_id");
                String company_name = resultSet.getString("company_name");
                int bus_seats = resultSet.getInt("bus_seats");
                return new AdminKompanite(orariId,company_name,bus_seats);
            } else {
                return null;
            }
        }
    }
}
