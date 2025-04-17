package com._7.spring_basics.service;

import org.springframework.stereotype.Component;

@Component
public class ConstructorService {

    public String getMessage() {
        return "Constructor Injection Works!";
    }
}

