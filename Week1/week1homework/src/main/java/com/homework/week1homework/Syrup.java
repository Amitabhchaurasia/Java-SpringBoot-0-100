package com.homework.week1homework;

import org.springframework.stereotype.Component;

@Component
public class Syrup implements Syrupinf{
    
    @Override
    public String getSyrupType() {
        return "Maple";
    }
}
