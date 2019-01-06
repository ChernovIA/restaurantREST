package com.votes.myRestaurant;

import com.votes.myRestaurant.init.DataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class MyRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestaurantApplication.class, args);
	}

	@Bean
	public CharacterEncodingFilter characterEncodingFilter(){
		return new CharacterEncodingFilter("UTF-8");
	}

	@Bean(initMethod = "init")
	public DataInitializer initTestData() {
		return new DataInitializer();
	}
}

