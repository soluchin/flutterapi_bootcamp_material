package com.flutter.api.flutterapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.flutter.api.flutterapi.Service.IService;
import com.flutter.api.flutterapi.Model.UserModel;

@SpringBootApplication
public class FlutterapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlutterapiApplication.class, args);
	}

	// @Bean
	CommandLineRunner run(IService service) {
		return args -> {
			UserModel user1= new UserModel();
			user1.Construct("akun", "satu", "akun.1@gmail.com", 1);
			UserModel user2= new UserModel();
			user2.Construct("akun", "dua", "akun.2@gmail.com", 0);
			UserModel user3= new UserModel();
			user3.Construct("akun", "tiga", "akun.3@gmail.com", 0);
			service.createUser(user1);
			service.createUser(user2);
			service.createUser(user3);
		};
	}

}
