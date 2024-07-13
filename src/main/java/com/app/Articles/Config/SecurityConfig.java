package com.app.Articles.Config;


import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Optional;
import java.util.logging.Filter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private  JwtAuthFilter jwtAuthFilter ;

    @Autowired
   private UserDao userDao;

    @Bean
    public PasswordEncoder passwordEncoder(){
    return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection for testing purposes
                .authorizeHttpRequests(authz -> authz.requestMatchers("/user/register","/article/all-articles","/user/login",
                                "/article/add-article").permitAll() // Allow public access to the register endpoint
                .anyRequest()
                .authenticated() // Require authentication for any other requests

                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(withDefaults()); // Use basic HTTP authentication

        return http.build();
    }
    @Bean
    UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Optional<User> user = userDao.findByEmail(email);
                if (user.isPresent()) {
                    User foundUser = user.get();
                    return org.springframework.security.core.userdetails.User
                            .withUsername(foundUser.getEmail())
                            .password(foundUser.getPassword())
                            .accountExpired(false)
                            .accountLocked(false)
                            .credentialsExpired(false)
                            .disabled(false)
                            .build();
                    //authorities("ROLE_USER") // Adjust roles and authorities as needed
                } else {
                    throw new UsernameNotFoundException("User not found with email : " + email);
                }
            }
        };
    }
}
