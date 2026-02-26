package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController
{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String USERNAME_ATTR = "username";
    private static final String PASSWORD_ATTR = "password";
    private static final String EMAIL_ATTR = "email";

    @GetMapping("/h")
    @SuppressWarnings("unused")
    String m1()
    {
        return "home";
    }

    @GetMapping("/reg")
    @SuppressWarnings("unused")
    String m2()
    {
        return "register";
    }

    @PostMapping("/register")
    @SuppressWarnings("unused")
    String m3(@RequestParam String uname, @RequestParam String psw, @RequestParam(required = false) String email, @RequestParam(required = false) String submit, Model x)
    {
        logger.info("Username: {}", uname);
        logger.info("Password received");
        logger.info("Email processing");
        x.addAttribute(USERNAME_ATTR, uname);
        x.addAttribute(EMAIL_ATTR, email);
        x.addAttribute(PASSWORD_ATTR, psw);

        return "admin";
    }
}