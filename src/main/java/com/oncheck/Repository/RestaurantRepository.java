package com.oncheck.Repository;

import com.oncheck.Domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by brianabbott on 6/20/16.
 */

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {

}
