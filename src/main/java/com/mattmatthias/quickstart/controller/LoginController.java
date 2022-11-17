package com.mattmatthias.quickstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }
    @GetMapping("/hello")
    String hello() {
        return "hello";
    }
}
