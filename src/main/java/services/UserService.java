package services;

import models.User;
import repository.UserRepository;
import repository.interfaces.UserRepositoryInterface;
import services.interfaces.UserServiceInterface;

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
            return loginUser;
        }

        return null;
    }
}
