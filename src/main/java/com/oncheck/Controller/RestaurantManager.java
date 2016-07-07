package com.oncheck.Controller;

import com.oncheck.Domain.Restaurant;
import com.oncheck.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brianabbott on 6/16/16.
 */
@RestController
public class RestaurantManager {

    @Autowired
    private RestaurantRepository restaurantRepository;


    @RequestMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    @RequestMapping(value = "/restaurants/searchByID/{id}", method = RequestMethod.GET)
    public Restaurant findByRestaurantID(@PathVariable String id){
        return restaurantRepository.findByRestaurantID(id);
    }

    @RequestMapping(value = "/restaurants/searchByCity/{city}", method = RequestMethod.GET)
    public Iterable<Restaurant> findByRestaurantCity(@PathVariable String city){
        return restaurantRepository.findByCity(city);
    }

    @RequestMapping(value = "/restaurants/searchByZip/{zip}", method = RequestMethod.GET)
    public Iterable<Restaurant> findByRestaurantZip(@PathVariable String zip){
        return restaurantRepository.findByZip(zip);
    }

    @RequestMapping("/delRest")
    public void deleteAllRestaurants(){
        restaurantRepository.deleteAll();
    }

    public Restaurant[] getRestaurantList(String search, String filter){
        return null;
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
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