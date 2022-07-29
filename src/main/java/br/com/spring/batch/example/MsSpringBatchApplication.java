package br.com.spring.batch.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.*")
public class MsSpringBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsSpringBatchApplication.class, args);
    }
}
