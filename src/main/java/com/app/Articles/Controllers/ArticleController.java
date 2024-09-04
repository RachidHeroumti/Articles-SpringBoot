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

    @GetMapping("/all-articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("get-article/{id}")
    public Optional<Article> getArticleById(@PathVariable int id){
        return articleService.getArticleById(id);
    }

    @PostMapping("add-article")
    public ResponseEntity<Article>  AddArticle(@RequestBody ArticleDto article){

        return articleService.addArticles(article);
    }

    public ResponseEntity<List<Article>> getArticlesByCategory(String category){
        return articleService.getArticlesByCategory(category);
    }

    @PostMapping("/update")
    public Article UpdateArticle(@RequestBody Article article){
        return  articleService.UpdateArticle(article);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> DeletArticle(@PathVariable int id){
        return  articleService.DeleteArticle(id);
    }


}
