package ru.home.chernyadieva.springsecuritytest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.home.chernyadieva.springsecuritytest.security.UsersDetails;

/**
 * Класс-контроллер для связи с БД
 */
@Controller
public class MyController {

    @RequestMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @RequestMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails) authentication.getPrincipal();
        System.out.println(usersDetails.getPerson());

        return "hello";
    }
}
