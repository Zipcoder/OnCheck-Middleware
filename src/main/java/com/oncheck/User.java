package com.oncheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class User {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private String userId;

    @Column(name="USERNAME")
    private String username;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    public User(String userId, String username, String email, String password){
        this.userId = userId;
        this.username=username;
        this.email=email;
        this.password=password;
    }



}
