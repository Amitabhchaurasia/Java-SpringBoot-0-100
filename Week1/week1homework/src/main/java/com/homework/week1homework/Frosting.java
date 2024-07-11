package com.homework.week1homework;

import org.springframework.stereotype.Component;

@Component
public class Frosting implements FrostingInf{

    @Override
    public String getFrostingType() {
       return "Vanilla";
    }
    
    
}
