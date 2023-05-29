package services;

import models.User;
import repository.UserRepository;
import repository.interfaces.UserRepositoryInterface;
import services.interfaces.UserServiceInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService implements UserServiceInterface {
    //Repository
    private UserRepositoryInterface userRepository;

    public UserService(){
        //repositories
        this.userRepository= new UserRepository();
    }

    @Override
    public User login(String username, String password) throws SQLException {
        User loginUser = UserRepository.getByUsername(username);
        if(loginUser == null){
            return null;
        }
        boolean isPasswordCorrect = PasswordHasher.compareSaltedHash(
                password, loginUser.getSalt(), loginUser.getSaltedPassword()
        );
        if(isPasswordCorrect){
            UserAuthService.setCurrentUser(loginUser); // Set the current user
            return loginUser;
        }

        return null;
    }
    public boolean updatePassword(User user, String oldPassword, String newPassword) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedSaltedPassword = resultSet.getString("salted_password");
                String storedSalt = resultSet.getString("salt");
                if (PasswordHasher.compareSaltedHash(oldPassword, storedSalt, storedSaltedPassword)) {
                    // Passwords match, update the password in the database
                    String newSalt = PasswordHasher.generateSalt();
                    String newSaltedPassword = PasswordHasher.generateSaltedHash(newPassword, newSalt);

                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE users SET salted_password = ?, salt = ? WHERE username = ?");
                    updateStatement.setString(1, newSaltedPassword);
                    updateStatement.setString(2, newSalt);
                    updateStatement.setString(3, user.getUsername());
                    updateStatement.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
