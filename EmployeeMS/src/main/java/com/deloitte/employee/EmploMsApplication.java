package com.deloitte.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Employee Management System",version = "3.0", description="Employee database"))
public class EmploMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmploMsApplication.class, args);
	}

}
