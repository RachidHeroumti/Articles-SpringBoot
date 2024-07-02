package com.app.Articles.Controllers;

import com.app.Articles.Services.UserService;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService ;

    @PostMapping("/register")
    public User RegisterUser(@RequestBody User u){

        return userService.Register(u);
    }

//    @GetMapping("get-user/{id}")
//    public Optional<User> getUserById(@PathVariable int id){
//        return userService.getUserById(id);
//    }
}
