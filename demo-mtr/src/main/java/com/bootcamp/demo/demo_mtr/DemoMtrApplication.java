package com.bootcamp.demo.demo_mtr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoMtrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMtrApplication.class, args);
	}

}
