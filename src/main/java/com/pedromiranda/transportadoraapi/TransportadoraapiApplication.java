package com.pedromiranda.transportadoraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableSwagger2
public class TransportadoraapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportadoraapiApplication.class, args);
    }
}
