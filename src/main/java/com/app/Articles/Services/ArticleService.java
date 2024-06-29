package com.app.Articles.Services;

import com.app.Articles.Dao.ArticlesDao;
import com.app.Articles.models.Article;
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


    public Article addArticles(Article article) {

        return articlesDao.save(article) ;
    }

    public List<Article> getArticlesByCategory(String category) {
        return articlesDao.findByCategory(category);
    }
}
