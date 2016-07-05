package com.oncheck.Controller;

import com.oncheck.Repository.AccountRepository;
import com.oncheck.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountManager {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public boolean accountLoggedIn(){
        return true;
    }


    @RequestMapping(value = "/account/read/{userID}", method = RequestMethod.GET)
    @ResponseBody
    public void readAccount() {
        return username;
    }

    @RequestMapping
    @ResponseBody(value = "account/update/{userID}", method = RequestMethod.PUT)
    public void updateAccount() {

//        PUT info for columns in userID

    }

    @RequestMapping
    @ResponseBody(value = "account/delete/{userID}", method = RequestMethod.DELETE)
    public void deleteAccount() {
        return userID.deleteAccount();

    }

    @RequestMapping
    @ResponseBody(value = "account/create", method = RequestMethod.POST)
    public void enterUsername(){
        return new User();
    }


}
