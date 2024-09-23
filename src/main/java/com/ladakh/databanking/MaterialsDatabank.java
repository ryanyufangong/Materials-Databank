package com.ladakh.databanking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.ladakh.databanking.controller", "com.ladakh.databanking.service"})
@ComponentScan(basePackages = {"com.ladakh.databanking.controller", "com.ladakh.databanking.service"})
public class MaterialsDatabank {
    public static void main(String[] args) {
        SpringApplication.run(MaterialsDatabank.class, args);
    }
}

