package com._7.spring_basics.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class LifecycleService {

    public LifecycleService() {
        System.out.println("👉 Constructor: LifecycleService instantiated");
    }

    @PostConstruct
    public void init() {
        System.out.println("✅ @PostConstruct: Bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("🧹 @PreDestroy: Bean will be destroyed");
    }

    public void doSomething() {
        System.out.println("💼 Working inside doSomething()");
    }
}

