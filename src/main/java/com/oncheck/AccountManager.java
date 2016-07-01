package com.oncheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.security.auth.login.LoginException;

@Entity
public class AccountManager {

    @Id
    @GeneratedValue

    User user = new User();

    boolean accountLogin(){

    }

    void readAccount() {

//        PULL info columns for userID;

    }

    void updateAccount() {

//        PUT info for columns in userID

    }

    void deleteAccount() {

//        userID.DELETE;

    }


    void enterUsername(){



    }
}
