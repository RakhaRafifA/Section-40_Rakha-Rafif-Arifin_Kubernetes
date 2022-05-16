package com.rakharafifa.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}

	@GetMapping("/")
	public void welcome(){
		System.out.println("Selamat datang di Mini Project Rakha Rafif Arifin");
	}
}
