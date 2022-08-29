package com.example.groom;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class GRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(GRoomApplication.class, args);
    }
}
