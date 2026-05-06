package com.trashforquota.ProjectPBO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectPboApplication {

// Tambahkan di dalam main method atau sebagai CommandLineRunner
	public static void main(String[] args) {
		System.out.println("Hash untuk password123 adalah: " + new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("password123"));
		SpringApplication.run(ProjectPboApplication.class, args);
	}

}
