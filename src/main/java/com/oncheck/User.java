package com.oncheck;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="LOGGEDIN")
    private boolean loggedIn;

    @OneToMany
    @JoinColumn(name="RESTAURANT_ID")
    private ArrayList<Restaurant> myEats;

    private User(Long userID){
        this.userId = userID;
    }

    private User(String username, String email, String password, boolean loggedIn){
        this.username = username;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
        this.myEats = new ArrayList<Restaurant>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Restaurant addToMyEats(Restaurant restaurantID){
        myEats.add(restaurantID);
        return restaurantID;
    }

    public boolean removeFromMyEats(Restaurant restaurantID){
        myEats.remove(restaurantID);
        return false;
    }

}
