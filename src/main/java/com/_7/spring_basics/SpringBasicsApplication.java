package com._7.spring_basics;

import com._7.spring_basics.service.LifecycleService;
import com._7.spring_basics.service.SetterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {

    public static void main(String[] args) {
        // Use ConfigurableApplicationContext so we can close it later
        ConfigurableApplicationContext context = SpringApplication.run(SpringBasicsApplication.class, args);

        // Getting a bean and calling a method
        SetterService obj = context.getBean(SetterService.class);
        System.out.println("From main:");
        obj.WhoAmI();

        // Test lifecycle bean
        LifecycleService service = context.getBean(LifecycleService.class);
        service.doSomething();

        // Properly close the context to trigger @PreDestroy
       context.getBeanFactory().destroyBean(service);

        // context.close();
    }
}

// IOC (Inversion of Control): program controls object lifetimes.
// DI (Dependency Injection): concrete implementation of IoC.
// ApplicationContext: the container managing all Spring beans.

