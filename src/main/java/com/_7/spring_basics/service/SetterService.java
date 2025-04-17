package com._7.spring_basics.service;

import org.springframework.stereotype.Component;

@Component
public class SetterService {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "Setter Injection Works!";
    }
    public void WhoAmI(){
      System.out.println("Hello m A Bean (a running instence managed by ioc container)");
    }
}

