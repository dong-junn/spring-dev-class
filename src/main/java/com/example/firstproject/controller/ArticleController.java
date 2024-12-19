package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @PostMapping("/articles/update")
    public String update(@RequestParam("id") Long id, ArticleForm fo) {

        Article resultEntity = fo.toEntity();
        Article resultEntity2 = articleRepository.save(resultEntity);
        return "redirect:/articles/" + resultEntity2.getId();
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model mo) {
        Article result = articleRepository.findById(id).orElse(null);
        mo.addAttribute("articleResult", result);

        return "articles/edit";
    }
    
    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> resultAr = (List<Article>) articleRepository.findAll();
        model.addAttribute("resultObj", resultAr);
        return "articles/index";
    }

    @PostMapping("/articles")
    public String index(@RequestParam("boardSearch") String keyword, Model model) {

        List<Article> resultAr = null;

        if (keyword != null) {
            resultAr = (List<Article>) articleRepository.findBytitleContaining(keyword);
        }
        resultAr = (List<Article>) articleRepository.findAll();

        model.addAttribute("resultObj", resultAr);
        return "articles/index";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id, Model mo) {
        Article result = articleRepository.findById(id).orElse(null);
        mo.addAttribute("articleResult", result);

        return "articles/show";
    }

    @GetMapping("/article/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String newArticleForm(ArticleForm form) {
        //System.out.println(form.toString());
        Article ar = form.toEntity();
        //System.out.println("entity: " + ar.toString());
        Article afterAr = articleRepository.save(ar);
        return "redirect:/articles/" + afterAr.getId(); // foward:/articles/ 도 가능하다
    }
}
