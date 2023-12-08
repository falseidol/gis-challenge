package com.example.renderingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RenderingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenderingServiceApplication.class, args);
    }

}
