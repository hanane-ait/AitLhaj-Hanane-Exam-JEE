package com.youssfi.controle.security;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/profile")
    public String profile(){

        return "Authentification réussie";
    }
}