package com.app.Articles.Services;

import com.app.Articles.Config.JwtUtils;
import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;

    @Autowired
    JwtUtils jwtUtils ;
    private final AuthenticationManager authenticationManager;

    public UserService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


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
//        Optional<User> optionalUser = userDao.findByEmail(email);
//
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                return "Login successful!";
//            } else {
//                return "Invalid password!";
//            }
//        } else {
//            return "User not found!";
//        }
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            // If authentication is successful, generate a JWT token
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwtToken = jwtUtils.generateToken(userDetails);

            return jwtToken; // Return the JWT token

        } catch (AuthenticationException e) {
            return "Invalid email or password!";
        }
    }

    public Optional<User> getUserById(int id) {
    return userDao.findById(id);
    }


}
