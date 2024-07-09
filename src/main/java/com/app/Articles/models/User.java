package com.app.Articles.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="articlesDB")
@Table(name="users",
        uniqueConstraints = {
    @UniqueConstraint(columnNames="email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 64)
    private String password;
    private String about_you ;
    private  String date_creation ;


    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String about_you, String date_creation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.about_you = about_you;
        this.date_creation = date_creation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout_you() {
        return about_you;
    }

    public void setAbout_you(String about_you) {
        this.about_you = about_you;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }
}
