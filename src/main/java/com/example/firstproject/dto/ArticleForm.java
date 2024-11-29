package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    private String title;

    private String content;

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        Article ar = new Article(null, title, content);

        return ar;
    }

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
