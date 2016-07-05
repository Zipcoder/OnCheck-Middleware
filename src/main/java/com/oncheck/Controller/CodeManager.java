package com.oncheck.Controller;

import com.oncheck.Domain.Code;
import com.oncheck.Repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stevejaminson on 7/5/16.
 */
@RestController
public class CodeManager {

    @Autowired
    private CodeRepository codeRepository;

    @RequestMapping("/codes")
    public Iterable<Code> getAllCodes(){return codeRepository.findAll();}

    @RequestMapping(value = "/codes/searchByAnnotation/{codeAnnotation:.+}", method = RequestMethod.GET)
    public Code findByCodeAnnotation(@PathVariable String codeAnnotation){
        return codeRepository.findByCodeAnnotation(codeAnnotation);
    }
}
