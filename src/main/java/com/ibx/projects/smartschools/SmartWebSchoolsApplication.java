package com.ibx.projects.smartschools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = { "com.ibx.projects.smartschools" })
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement    
public class SmartWebSchoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartWebSchoolsApplication.class, args);
	}
}
