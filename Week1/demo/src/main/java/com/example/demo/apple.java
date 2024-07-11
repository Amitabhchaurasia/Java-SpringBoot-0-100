package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("singleton")  
public class apple {
    
    @PostConstruct
    void postConstruct(){
        System.out.println("This is from postConstructMethod");
    }
    
    void callApple(){
        System.out.println("This is from callApple");
    }

    @PreDestroy
    void destroy(){
        System.out.println("This is from preDestroyer");
    }
}
