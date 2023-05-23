package repository;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        String sql = "INSERT INTO users (username, salted_hash, salt) VALUES (?, ?, ?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getSaltedPassword());
        statement.setString(3, user.getSalt());
        statement.executeUpdate();

        return UserRepository.getByUsername(user.getUsername());
    }


    public static User getByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String saltedHash = resultSet.getString("salted_hash");
                String salt = resultSet.getString("salt");
                return new User(id, username, saltedHash, salt);
            } else {
                return null;
            }
        }
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String tittle, String username){
        Parent root=null;
        try {
            root= FXMLLoader.load(UserRepository.class.getResource(fxmlFile));
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(tittle);
        stage.setScene(new Scene(root,600,450));
        stage.show();
    }


}
