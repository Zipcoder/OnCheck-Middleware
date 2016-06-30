package com.oncheck;

import com.oncheck.Controller.RestaurantManager;
import com.oncheck.Scraper.Scraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnCheckMiddleWareApplication {

	public static void main(String[] args) {
		Scraper scraper = new Scraper();
		RestaurantManager restaurantManager = new RestaurantManager();
		SpringApplication.run(OnCheckMiddleWareApplication.class, args);
		scraper.runScraper();
		restaurantManager.saveAll();
	}
}
