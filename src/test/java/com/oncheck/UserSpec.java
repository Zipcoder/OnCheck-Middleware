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

//    @Test
//    public void addToMyEatsTest() throws Exception {
//        Restaurant expectedValue = mcDonalds;
//        Restaurant actualValue=randy.addToMyEats(mcDonalds);
//        assertEquals(expectedValue,actualValue);
//    }

    @Test
    public void removeFromMyEatsTest() throws Exception {
//        Restaurant expectedValue = true;
//        Restaurant actualValue=randy.removeFromMyEats(mcDonalds);
//        assertEquals(expectedValue,actualValue);
    }

}