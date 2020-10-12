package com.example.bootpreparation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.bootpreparation.*")
public class BootPreparationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootPreparationApplication.class, args);
    }

}
