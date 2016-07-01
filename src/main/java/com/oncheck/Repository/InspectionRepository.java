package com.oncheck.Repository;

import com.oncheck.Domain.Inspection;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by brianabbott on 6/20/16.
 */
public interface InspectionRepository extends CrudRepository<Inspection,Long> {

}
