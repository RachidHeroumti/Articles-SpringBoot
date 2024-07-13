package com.app.Articles.Controllers;

import com.app.Articles.DTO.ArticleDto;
import com.app.Articles.Services.ArticleService;
import com.app.Articles.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Article>  AddArticle(@RequestBody ArticleDto article){
        System.out.println(article.toString()+"hhhh");
        return ResponseEntity.ok( articleService.addArticles(article));
    }

    public List<Article> getArticlesByCategory(String category){
        return articleService.getArticlesByCategory(category);
    }

    @PostMapping("/update")
    public Article UpdateArticle(@RequestBody Article article){
        return  articleService.UpdateArticle(article);
    }

    @PostMapping("/delete/{id}")
    public String DeletArticle(@PathVariable int id){
        return  articleService.DeleteArticle(id);
    }


}
