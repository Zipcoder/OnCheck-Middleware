//package com.oncheck.Controller;
//
//import com.oncheck.Repository.UserRepository;
//import com.oncheck.Restaurant;
//import com.oncheck.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class UserManager {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean accountLoggedIn(){
//        return true;
//    }
//
//
//    @RequestMapping(value = "/account/read/{userID}", method = RequestMethod.GET)
//    @ResponseBody
//    public User readAccount(@PathVariable Long userID) {
//        return userRepository.get(userID);
//    }
//
////    @RequestMapping
////    @ResponseBody(value = "account/update/{userID}", method = RequestMethod.PUT)
////    public void updateAccount(@PathVariable) {
//
////        PUT info for columns in userID
//
////    }
//
//    @RequestMapping(value = "/account/delete/{userID}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public void deleteAccount(@PathVariable Long userID) {
//        userRepository.deleteAccount(userID);
//
//    }
//
//    @RequestMapping(value = "/account/create/{userID}", method = RequestMethod.POST)
//    @ResponseBody
//    public User enterUsername(@PathVariable Long userID){
//        return userRepository.save(new User());
//    }
//
//
////    public Restaurant addToMyEats(Restaurant restaurantID){
////        myEats.add(restaurantID);
////        return restaurantID;
////    }
////
////    public boolean removeFromMyEats(Restaurant restaurantID){
////        myEats.remove(restaurantID);
////        return false;
////    }
//
//
//    public UserRepository getUserRepository() {
//        return userRepository;
//    }
//
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//}
