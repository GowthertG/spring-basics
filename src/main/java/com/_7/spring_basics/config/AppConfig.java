package com._7.spring_basics.config;

import com._7.spring_basics.service.LifecycleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public LifecycleService lifecycleService() {
        return new LifecycleService();
    }
}

