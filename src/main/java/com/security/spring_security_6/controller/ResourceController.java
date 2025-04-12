package com.security.spring_security_6.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ResourceController {

    @GetMapping("")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken( HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

}
