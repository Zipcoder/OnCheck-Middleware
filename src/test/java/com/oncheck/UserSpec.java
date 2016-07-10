package com.oncheck;

import com.oncheck.Domain.User;
import org.junit.Before;
import org.junit.Test;


public class UserSpec {

    User randy;
    Restaurant mcDonalds;

    @Before
    public void setUp() throws Exception {
        randy = new User("RandyDoodle3457", "itsRaaaaaaandy@gmail.net", "smash", true);
        mcDonalds = new Restaurant();
    }
