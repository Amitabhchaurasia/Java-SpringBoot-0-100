package com.week2.work.week2work.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.core.model.Model;

@Configuration
public class appConfig {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    
}
