package com.tax.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(value = {"com.tax.system.entities"})
@EnableJpaRepositories(basePackages = {"com.tax.system.repositories"})
public class TaxCollectionSystem {

    public static void main(String[] args) {
        SpringApplication.run(TaxCollectionSystem.class, args);
    }
}
