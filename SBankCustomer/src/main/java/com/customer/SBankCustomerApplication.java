package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients

public class SBankCustomerApplication {


	
	public SBankCustomerApplication()
	{
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SBankCustomerApplication.class, args);
	}
}
