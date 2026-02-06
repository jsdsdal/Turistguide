package com.example.turistguide.controller;

import com.example.turistguide.service.LoggedUserManagementService;
import com.example.turistguide.service.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login";
    }
    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        this.loginProcessor.setUsername(username);
        this.loginProcessor.setPassword(password);

        boolean loggedIn = this.loginProcessor.login();
        if(loggedIn) {
/*
            model.addAttribute("message", "You are now logged in. Welcome Benne");
*/
            return "redirect:/main";
        } else {
            model.addAttribute("message", "Login failed!");
        }
        return "login";
    }



}
