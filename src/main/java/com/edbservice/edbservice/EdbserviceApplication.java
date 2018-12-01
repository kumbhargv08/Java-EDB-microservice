package com.edbservice.edbservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class EdbserviceApplication {
	
	@RequestMapping("/")
    String hello() {
        return "Hello World! JavaInterviewPoint";
    }
	
	@GetMapping("/users")
	List<String> getUsers() {
		List<String> l1= new ArrayList<String>();
		l1.add("ganesh");
		l1.add("Lakshaya");
		return l1;
	}
	
	@PostMapping("/uesr-list")
	String userList(@RequestBody String newEmployee) {
		return "save";
	}

	public static void main(String[] args) {
		SpringApplication.run(EdbserviceApplication.class, args);
	}
}
