package com.cursos.api.authorization_server.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    /**
     * Action to log out. Authorization Server work as Stateful that's why we must delete JSESSIONID cookie
     * @param http
     * @return
     * @throws Exception
     */
    @PostMapping("/logout")
    public String logoutOk(HttpSecurity http) throws Exception {
        http.logout(logoutConfig -> {
           logoutConfig.logoutSuccessUrl("login?logout")
                   .deleteCookies("JSESSIONID")
                   .clearAuthentication(true)
                   .invalidateHttpSession(true);
        });
        return "login?logout";
    }
}