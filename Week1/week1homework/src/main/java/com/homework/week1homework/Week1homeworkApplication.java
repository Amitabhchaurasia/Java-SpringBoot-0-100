package com.homework.week1homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week1homeworkApplication implements CommandLineRunner {

    @Autowired
    private CakeBaker cakeBaker;

    public static void main(String[] args) {
        SpringApplication.run(Week1homeworkApplication.class, args);
    }

    @Override
    public void run(String... args) {
        cakeBaker.bakeCake();
    }
}
