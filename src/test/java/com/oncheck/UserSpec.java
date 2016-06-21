package com.oncheck;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 6/21/16.
 */
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

    }

    @Test
    public void removeFromMyEats() throws Exception {

    }

}