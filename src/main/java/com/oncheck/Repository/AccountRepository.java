package com.oncheck.Repository;

/**
 * Created by jaymilnamow on 7/1/16.
 */

public interface AccountRepository extends CrudRepository<Account,Long> {

  public User createAccount(String username);

  public User get(Long userID);

  public void updateAccount(User userID);

  public void deleteAccount(Long userId);

}
