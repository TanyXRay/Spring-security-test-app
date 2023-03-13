package ru.home.chernyadieva.springsecuritytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс-контроллер для связи с БД
 */
@Controller
public class MyController {

    @RequestMapping("/hello")
    public String helloPage() {
        return "hello";
    }
}
