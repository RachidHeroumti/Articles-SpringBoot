package com.app.Articles.Services;

import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    public String Register(User u) {
        //check if user alredy existe
      boolean isExist=  userDao.existsByEmail(u.getEmail());

        if (isExist) return  "User already exist!";
        //password will be encoded
        User user=new User(u.getName(),u.getEmail(),
                this.passwordEncoder.encode(u.getPassword()),
                u.getAbout_you(),
                u.getDate_creation());

        System.out.println("user :"+user);
        userDao.save(user);
       return "Register seccessfuly!";
    }

    public String Login(String email,String password) {
        Optional<User> optionalUser = userDao.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid password!";
            }
        } else {
            return "User not found!";
        }
    }

    public Optional<User> getUserById(int id) {
    return userDao.findById(id);
    }


}
