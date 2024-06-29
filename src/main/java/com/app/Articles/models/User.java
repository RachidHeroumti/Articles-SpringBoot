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
    private String email;
    private String passsword;
    private String aboutYou ;
    private  String date_creation ;



}
