package com.example.firstproject.dto;

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

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
