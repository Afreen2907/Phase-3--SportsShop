package com.phase3Assessment.sportshop.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("SportShoes-Web.persistence.repo")
@EntityScan("SportShoes-Web.persistence.model")
@SpringBootApplication(scanBasePackages = {"SportShoes-Web.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
