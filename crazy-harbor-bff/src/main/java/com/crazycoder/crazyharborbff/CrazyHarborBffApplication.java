package com.crazycoder.crazyharborbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class CrazyHarborBffApplication {
    static {
        System.out.println("Application starting..  ");
    }


    public static void main(String[] args) {
        SpringApplication.run(CrazyHarborBffApplication.class, args);
    }


}
