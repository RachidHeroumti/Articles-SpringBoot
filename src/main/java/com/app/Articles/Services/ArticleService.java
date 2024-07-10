package com.app.Articles.Services;

import com.app.Articles.DTO.ArticleDto;
import com.app.Articles.Dao.ArticlesDao;
import com.app.Articles.Dao.UserDao;
import com.app.Articles.models.Article;
import com.app.Articles.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Article addArticles(ArticleDto article) {
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


            return  articlesDao.save(ar);
        } else {
            System.out.println("user not found");
            return new Article();
        }

    }

    public List<Article> getArticlesByCategory(String category) {
        return articlesDao.findByCategory(category);
    }

    public Article UpdateArticle(Article article) {
        return articlesDao.save(article);
    }

    public String DeleteArticle(int id) {
        articlesDao.deleteById(id);
        return "deleted succefully" ;

    }
}
