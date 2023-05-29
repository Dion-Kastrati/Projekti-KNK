package repository;

import models.Ankesa;
import models.dto.StoreAnkesaDto;
import repository.interfaces.AnkesaRepositoryInterface;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnkesaRepository implements AnkesaRepositoryInterface{
 @Override
    public  Ankesa insert(StoreAnkesaDto ankesa) throws SQLException {
        String sql = "INSERT INTO ankesat (email, ankesa) VALUES (?, ?)";
        Connection connection = ConnectionUtil.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ankesa.getEmail());
            statement.setString(2, ankesa.getAnkesa());

            statement.executeUpdate();

        } catch (SQLException e) {
            // Handle exceptions
            throw e;
        }
    return new Ankesa(ankesa.getEmail(), ankesa.getAnkesa());
    }


}

