package com.oncheck;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserSpec {

    User randy;
    Restaurant mcDonalds;

    @Before
    public void setUp() throws Exception {
        randy = new User("12","RandyDoodle3457", "itsRaaaaaaandy@gmail.net", "smash");
        mcDonalds = new Restaurant();
    }

    @Test
    public void addToMyEats() throws Exception {
        Restaurant expectedValue = mcDonalds;
        Restaurant actualValue = randy.addToMyEats();
    }

    @Test
    public void removeFromMyEats() throws Exception {

    }

}