package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceTomeetyou(Model mo) {
        mo.addAttribute("userName", "이동준");
        return "greetings";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/bye")
    public String bye(Model mo) {
        mo.addAttribute("userName", "이동준");
        return "goodbye";
    }
}
