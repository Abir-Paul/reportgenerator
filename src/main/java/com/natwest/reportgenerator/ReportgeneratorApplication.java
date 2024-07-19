package com.natwest.reportgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReportgeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportgeneratorApplication.class, args);
    }

}
