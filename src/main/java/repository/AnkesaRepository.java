package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Ankesa;
import models.Oraret;
import models.dto.StoreAnkesaDto;
import repository.interfaces.AnkesaRepositoryInterface;
import services.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnkesaRepository implements AnkesaRepositoryInterface{
 @Override
    public  Ankesa insert(StoreAnkesaDto ankesa) throws SQLException {
        String sql = "INSERT INTO ankesat (email, ankesa) VALUES (?, ?)";
        Connection connection = ConnectionUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ankesa.getEmail());
            preparedStatement.setString(2, ankesa.getAnkesa());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // Handle exceptions
            throw e;
        }
    return new Ankesa(ankesa.getEmail(), ankesa.getAnkesa());
    }




    public static ObservableList<Ankesa> fetchAnkesat() {
        ObservableList<Ankesa> ankesaList = FXCollections.observableArrayList();

        try {

            // Create the SQL statement
            String sql = "SELECT email,ankesa FROM ankesat";
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                String emailcol = resultSet.getString("email");
                String ankesacol = resultSet.getString("ankesa");
                Ankesa ankesa = new Ankesa(emailcol, ankesacol);
                ankesaList.add(ankesa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ankesaList;
    }
}

