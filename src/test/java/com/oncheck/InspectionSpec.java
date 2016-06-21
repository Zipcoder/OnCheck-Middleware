package com.oncheck;

import com.oncheck.Domain.Inspection;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by brianabbott on 6/16/16.
 */
public class InspectionSpec {

    @Test
    public void inspectionCreatedTest(){
        Inspection inspection = new Inspection("Type","Date","Violations");
        assertNotNull("An object should be created",inspection);
    }
}
