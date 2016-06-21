package com.oncheck.Controller;

import com.oncheck.Domain.Restaurant;
import com.oncheck.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brianabbott on 6/16/16.
 */
@RestController
public class RestaurantManager {

    @Autowired
    RestaurantRepository restaurantRepository;


    @RequestMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurant(){
        saveRestaurant("test","123 fake","wilmin","12345","chester","Other","1/2004/5","12321");
        return restaurantRepository.findAll();
    }

    @RequestMapping("/delRest")
    public void deleteAllRestaurants(){
        restaurantRepository.deleteAll();
    }

    public Restaurant[] getRestaurantList(String search, String filter){
        return null;
    }

    public Restaurant getRandomRestaurant(){
        return null;
    }

    public Restaurant saveRestaurant(String name, String address, String city,
                                     String zip, String county,String inspectionType,
                                     String inspectionDate, String violations){

        Restaurant restaurant = new Restaurant(name,address,city,zip,county,inspectionType,inspectionDate,violations);
        restaurantRepository.save(restaurant);
        return  restaurant;
    }



}