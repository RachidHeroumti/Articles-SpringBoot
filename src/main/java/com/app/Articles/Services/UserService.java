package com.app.Articles.Services;

import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User addUser(User u) {
        return userDao.save(u);
    }

    public Optional<User> getUserById(int id) {
        return userDao.findById(id) ;
    }
}
