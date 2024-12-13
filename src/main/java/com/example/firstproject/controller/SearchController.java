package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search/main")
    public String mainSearch(@RequestParam("mainSearch") String keyword) {

        System.out.println("main Search keyword: " + keyword);
        return "";
    }
}
