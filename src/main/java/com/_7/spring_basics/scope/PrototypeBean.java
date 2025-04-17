package com._7.spring_basics.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    public String getMessage() {
        return "I am a Prototype Bean!";
    }
}

