package com.shivam.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(FirstAppApplication.class, args);
		// Without IOC/DI
//		Dev obj = new Dev();
		// With IOC
		Dev obj = context.getBean(Dev.class);
		obj.build();
	}

}
