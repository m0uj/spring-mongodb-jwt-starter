package com.github.m0uj.starter.commons.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MeController {

    @RequestMapping("/me")
    public Object getPrincipal(Authentication authentication){

        return authentication.getPrincipal();
    }
}