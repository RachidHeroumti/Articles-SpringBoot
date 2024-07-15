package com.app.Articles.Controllers;

import com.app.Articles.DTO.Loginrequest;
import com.app.Articles.Services.UserService;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService ;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@RequestBody User u){

        return ResponseEntity.ok(userService.Register(u));
    }
    @PostMapping("/login")
    public String login(@RequestBody Loginrequest loginRequest) {
        return userService.Login(loginRequest.getEmail(), loginRequest.getPassword());
    }
    @GetMapping("get-user/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }


}
