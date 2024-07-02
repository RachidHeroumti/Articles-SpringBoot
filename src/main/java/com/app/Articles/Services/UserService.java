package com.app.Articles.Services;

import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    public User Register(User u) {
//password will be encoded
        User user=new User(u.getName(),u.getEmail(),
                this.passwordEncoder.encode(u.getPassword()),
                u.getAbout_you(),
                u.getDate_creation());

        System.out.println("user :"+user);
       return userDao.save(user);
//return user;
    }

    public Optional<User> getUserById(int id) {
    return userDao.findById(id);
    }


}
