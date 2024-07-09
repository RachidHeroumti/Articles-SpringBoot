package com.app.Articles.Controllers;

import com.app.Articles.Services.ArticleService;
import com.app.Articles.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    ArticleService articleService ;

    @GetMapping(" ")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("get-article/{id}")
    public Optional<Article> getArticleById(@PathVariable int id){
        return articleService.getArticleById(id);
    }

    @PostMapping("add-article")
    public Article AddArticle(@RequestBody Article article){
        return articleService.addArticles(article);
    }

    public List<Article> getArticlesByCategory(String category){
        return articleService.getArticlesByCategory(category);
    }

}
