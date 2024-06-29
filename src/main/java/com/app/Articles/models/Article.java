package com.app.Articles.models;



import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import java.util.List;

@Data
@Entity(name="articlesdb")
@Table(name="articles")


public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title ;
    private String content ;
    private String user_id ;
    private String category ;
    private String date_creation;
}
