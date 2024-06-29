package com.app.Articles.Dao;

import com.app.Articles.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesDao extends JpaRepository<Article,Integer> {


    List<Article> findByCategory(String category);
}
