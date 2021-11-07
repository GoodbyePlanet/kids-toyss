package com.kidstoys.kidstoys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: delete this after all is working with liquibase
//@SpringBootApplication(exclude = {
//    DataSourceAutoConfiguration.class,
//    DataSourceTransactionManagerAutoConfiguration.class,
//    HibernateJpaAutoConfiguration.class
//})
@SpringBootApplication
public class KidsToysApplication {

    public static void main(String[] args) {
        SpringApplication.run(KidsToysApplication.class, args);
    }
}
