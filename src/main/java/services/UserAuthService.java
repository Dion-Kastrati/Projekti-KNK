package services;

import models.User;
import repository.UserRepository;

import java.sql.SQLException;

public class UserAuthService {

    public static User login(String username, String password) throws SQLException{
        User user = UserRepository.getByUsername(username);
        if(user==null){
            return null;
        }
        if(PasswordHasher.compareSaltedHash(password,user.getSalt(),user.getSaltedPassword())){
            return user;
        }
        return null;
    }
}
