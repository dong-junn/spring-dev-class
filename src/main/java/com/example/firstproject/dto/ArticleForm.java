package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {

    private Long id;
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
        Article ar = new Article(id, title, content);

        return ar;
    }

    public ArticleForm(String title, String content, Long id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }
}
