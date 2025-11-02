package org.unitbean.comfortablesofttestapplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ComfortableSoftTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComfortableSoftTestApplication.class, args);
    }

}
