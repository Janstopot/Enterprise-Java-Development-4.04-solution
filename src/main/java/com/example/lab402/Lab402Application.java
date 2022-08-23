package com.example.lab402;

import com.example.lab402.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab402Application {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		SpringApplication.run(Lab402Application.class, args);


	}

}
