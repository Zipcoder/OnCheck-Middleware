package com.oncheck.Repository;

import com.oncheck.Domain.Tip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TipRepository extends CrudRepository<Tip, Long> {

    @Query(value="select * from tip t where t.user_id = ?1", nativeQuery=true)
    public Iterable<Tip> findTipByUser(Long userId);
}