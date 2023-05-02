package com.programming.techie.clouditMalek;

import com.programming.techie.clouditMalek.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(OpenAPIConfiguration.class)
public class SpringCloudItMalek {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudItMalek.class, args);
    }

}
