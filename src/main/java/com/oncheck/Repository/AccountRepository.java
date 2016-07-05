package com.oncheck.Repository;

import org.springframework.stereotype.Repository;

/**
 * Created by jaymilnamow on 7/1/16.
 */

@Repository
 public interface AccountRepository extends CrudRepository<Account,Long> {

}
