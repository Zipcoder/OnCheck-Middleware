package com.oncheck;

import com.oncheck.Controller.RestaurantManager;
import com.oncheck.Scraper.Scraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnCheckMiddleWareApplication {

	public static void main(String[] args) {

		SpringApplication.run(OnCheckMiddleWareApplication.class, args);

	}
}
