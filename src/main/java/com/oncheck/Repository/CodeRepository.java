package com.oncheck.Repository;

import com.oncheck.Domain.Code;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by stevejaminson on 7/5/16.
 */
public interface CodeRepository extends CrudRepository<Code, Long> {
    Code findByCodeAnnotation(String codeAnnotation);
}
