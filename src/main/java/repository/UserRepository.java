package repository;

import models.User;
import models.dto.CreateUserDto;
import repository.interfaces.UserRepositoryInterface;
import services.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements UserRepositoryInterface {


    @Override
    public User insert(CreateUserDto user) throws SQLException {
        String sql = "INSERT INTO users (emri, mbiemri, email, username, salted_password, salt) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = ConnectionUtil.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getEmri());
            statement.setString(2, user.getMbiemri());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getSaltedPassword());
            statement.setString(6, user.getSalt());
            statement.executeUpdate();

            return getByUsername(user.getUsername());
        } catch (SQLException e) {
            // Handle exceptions
            throw e;
        }
    }


    public static User getByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String emri=resultSet.getString("emri");
                String mbiemri=resultSet.getString("mbiemri");
                String email=resultSet.getString("email");
                String salted_password= resultSet.getString("salted_password");
                String salt = resultSet.getString("salt");
                return new User(id,emri,mbiemri,email, username, salted_password, salt);
            } else {
                return null;
            }
        }
    }



}
