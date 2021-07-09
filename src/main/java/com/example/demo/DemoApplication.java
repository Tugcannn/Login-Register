package com.example.demo;

import com.example.demo.Entity.UserTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		UserTable user1 = new UserTable();
		user1.setUsername("tugcan");
		user1.setPassword("hoser");




	}


}
