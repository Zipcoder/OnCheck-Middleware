package com.oncheck.Repository;

import com.oncheck.Domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by brianabbott on 6/20/16.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {

}
