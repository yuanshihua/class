package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.ClassService;

@SpringBootApplication
public class ClassApplication {

	@Autowired
	private ClassService service;

	public static void main(String[] args) {
		SpringApplication.run(ClassApplication.class, args);
	}

	@Bean
	public ClassService service() {
		service.start();
		return service;
	}
}
