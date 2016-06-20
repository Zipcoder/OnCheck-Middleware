package com.oncheck.Controller;

import com.oncheck.Domain.Inspection;
import com.oncheck.Repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brianabbott on 6/20/16.
 */
@RestController
public class InspectionManager {

    @Autowired
    InspectionRepository inspectionRepository;

    @RequestMapping("/inspections")
    public Iterable<Inspection> getAllInspections(){
        return inspectionRepository.findAll();
    }
}
