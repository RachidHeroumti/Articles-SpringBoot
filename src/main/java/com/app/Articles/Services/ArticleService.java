package com.app.Articles.Services;

import com.app.Articles.DTO.ArticleDto;
import com.app.Articles.Dao.ArticlesDao;
import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.Article;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticlesDao articlesDao ;

    public List<Article> getAllArticles() {
        return articlesDao.findAll();
    }

    public Optional<Article> getArticleById(int id) {
        return articlesDao.findById(id);
    }
@Autowired
    UserDao userDao ;

    public ResponseEntity<Article> addArticles(ArticleDto article) {
        Optional<User> optionalUser = userDao.findById(article.getUserId());
        System.out.println(article.getUserId()+"----------");
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Article ar = new Article();
            ar.setTitle(article.getTitle());
            ar.setContent(article.getContent());
            ar.setUser(user);
            ar.setCategory(article.getCategory());
            ar.setDate_creation(article.getDateCreation());

Article a= articlesDao.save(ar);
            return new ResponseEntity<>(a, HttpStatus.CREATED) ;
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    public ResponseEntity<List<Article>> getArticlesByCategory(String category) {
        List<Article> ar=articlesDao.findByCategory(category);
        return new ResponseEntity<>(ar,HttpStatus.OK);
    }

    public Article UpdateArticle(Article article) {
        return articlesDao.save(article);
    }

    public ResponseEntity<String> DeleteArticle(int id) {
        articlesDao.deleteById(id);
        return new ResponseEntity<>("deleted ",HttpStatus.OK) ;

    }
}
