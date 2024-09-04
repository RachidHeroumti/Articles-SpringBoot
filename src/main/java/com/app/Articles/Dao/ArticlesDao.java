package com.app.Articles.Dao;

import com.app.Articles.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticlesDao extends JpaRepository<Article,Integer> {


    List<Article> findByCategory(String category);


}
