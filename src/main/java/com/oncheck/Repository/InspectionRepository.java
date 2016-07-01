package com.oncheck.Repository;

import com.oncheck.Domain.Inspection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by brianabbott on 6/20/16.
 */
public interface InspectionRepository extends CrudRepository<Inspection,Long> {

}
