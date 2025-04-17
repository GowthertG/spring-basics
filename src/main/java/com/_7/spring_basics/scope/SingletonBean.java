package com._7.spring_basics.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;


// Make this class a bean in the spring ioc container
// single instance shared across the entire app
// ps : noo need for this annotation Beans are singleton by default
@Component
@Scope("singleton")
public class SingletonBean {

    @PostConstruct
    public void init() {
        System.out.println("Singleton Bean Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Singleton Bean Destroyed");
    }

    public String getMessage() {
        return "I am a Singleton Bean!";
    }
}

