package com._7.spring_basics.controller;


import com._7.spring_basics.service.LifecycleService;
import com._7.spring_basics.service.ConstructorService;
import com._7.spring_basics.service.SetterService;
import com._7.spring_basics.scope.SingletonBean;
import com._7.spring_basics.scope.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    
    private ConstructorService constructorService;
    private SetterService setterService;


  // this is a constructor Service injection ps: no need for @Autowired annotation
    public MyController(ConstructorService constructorService){
    this.constructorService = constructorService;
  }

  // this is a setter injection
    @Autowired
    public void SettheSetterService(SetterService setterService){
      this.setterService = setterService; 
    }
    
  // this is a field injection not recommanded (less Testable, hidden Dependencies)
    @Autowired
    private LifecycleService lifecycleService;
    @Autowired
    private ApplicationContext context;




    @GetMapping("/test/bean")
    public String test() {
        lifecycleService.doSomething();
        return "Bean tested!";
    }
    @GetMapping("/test/constructor")
    public String testConstructorInjection() {
        return constructorService.getMessage();
    }

    @GetMapping("/test/setter")
    public String testSetterInjection() {
        return setterService.getMessage();
    }

/*
 This endpoint just to see the difference beetween singleton(default) bean and prototypeBean
*/
    @GetMapping("/test/scopes")
    public String testScopes() {
        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);

        System.out.println(prototypeBean2);
        System.out.println(prototypeBean1);
        System.out.println(singletonBean2);
        System.out.println(singletonBean1);
        return "Singletons are the same: " + (singletonBean1 == singletonBean2) + 
               "<br>Prototypes are different: " + (prototypeBean1 != prototypeBean2);
    }
}

