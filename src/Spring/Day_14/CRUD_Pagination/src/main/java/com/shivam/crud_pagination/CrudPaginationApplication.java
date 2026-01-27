package com.shivam.crud_pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CrudPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudPaginationApplication.class, args);
    }

}
