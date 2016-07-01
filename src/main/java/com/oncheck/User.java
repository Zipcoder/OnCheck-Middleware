package com.oncheck;

import javax.persistence.*;
import java.util.HashMap;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private String userId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @OneToMany
    @JoinColumn(name="RESTAURANT_ID")
    public int myEatsCounter = 0;
    private HashMap<Integer, Restaurant> myEats;

    public User(String userId, String username, String email, String password){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.myEats = new HashMap<Integer, Restaurant>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public Restaurant addToMyEats(Restaurant restaurant){

        myEatsCounter++;
        myEats.put(myEatsCounter,restaurant);
        return restaurant;

    }



    public boolean removeFromMyEats(Restaurant restaurant){

        myEatsCounter--;
        myEats.remove(myEatsCounter,restaurant);
        return false;
    }

}
