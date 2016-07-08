package com.oncheck.Repository;

import com.oncheck.Domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jaymilnamow on 7/1/16.
 */

public interface UserRepository extends CrudRepository<User,Long> {


}