package com.oncheck;

import com.oncheck.Domain.Restaurant;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by brianabbott on 6/16/16.
 */
public class RestaurantSpec {

    @Test
    public void restaurantConstructedTest() {
        Restaurant restaurant = new Restaurant("test","123 fake","wilmin","12345","chester","Other","1/2004/5","12321");
        assertNotNull(restaurant);
    }


}
