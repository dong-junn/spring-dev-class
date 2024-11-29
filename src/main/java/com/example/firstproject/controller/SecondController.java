package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/random-quote")
    public String randomQuote(Model model) {
        String[] quotes = {
                "하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다. -사무엘존슨",
                "언제나 현재에 집중할수 있다면 행복할것이다. -파울로 코엘료",
                "진정으로 웃으려면 고통을 참아야하며 , 나아가 고통을 즐길 줄 알아야 해 -찰리 채플린",
                "직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다 -엘버트 허버드",
                "피할수 없으면 즐겨라 – 로버트 엘리엇",
                "행복한 삶을 살기위해 필요한 것은 거의 없다. -마르쿠스 아우렐리우스 안토니우스"
        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
