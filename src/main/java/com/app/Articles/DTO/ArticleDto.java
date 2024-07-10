package com.app.Articles.DTO;

public class ArticleDto {

    private String title;
    private String content;
    private int userId; // use int instead of String for user_id
    private String category;
    private String dateCreation;


    public String getTitle() {
        return title;
    }

    public ArticleDto(String title, String content, int userId, String category, String dateCreation) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.category = category;
        this.dateCreation = dateCreation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", category='" + category + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                '}';
    }
}
