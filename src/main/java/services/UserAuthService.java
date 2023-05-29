package services;

import models.Session;
import models.User;
import models.dto.CreateUserDto;
import repository.UserRepository;

import java.sql.SQLException;

public class UserAuthService {
    private static User currentUser;

    public static User login(String username, String password) throws SQLException {
        User user = UserRepository.getByUsername(username);
        if (user == null) {
            return null;
        }
        if (PasswordHasher.compareSaltedHash(password, user.getSalt(), user.getSaltedPassword())) {
            // Set the current user in the session
            setCurrentUser(user);
            return user;
        } else {
            return null;
        }
    }
    public static User register(String emri, String mbiemri, String email, String username, String password) throws SQLException {
        User existingUser = UserRepository.getByUsername(username);
        if (existingUser != null) {
            // User with the same username already exists
            return null;
        }

        String salt = PasswordHasher.generateSalt();
        String saltedPasswordHash = PasswordHasher.generateSaltedHash(password, salt);

        CreateUserDto userDto = new CreateUserDto(emri, mbiemri, email, username, saltedPasswordHash, salt);
        UserRepository userRepository = new UserRepository();
        return userRepository.insert(userDto);
    }

    public static void setCurrentUser(User currentUser) {
        UserAuthService.currentUser = currentUser;
    }

    public User getCurrentUser(){
        return currentUser;
    }



}
