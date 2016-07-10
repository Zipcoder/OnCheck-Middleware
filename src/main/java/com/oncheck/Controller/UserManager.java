
package com.oncheck.Controller;

import com.oncheck.Repository.UserRepository;
import com.oncheck.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManager {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public boolean accountLoggedIn() {
        return true;
    }

    @RequestMapping(value = "account/create/{userID}", method = RequestMethod.POST)
    @ResponseBody
    public User enterUsername(@PathVariable Long userID) {
        return userRepository.save(new User());
    }
}



