package com.oncheck.tipsystem;

import com.oncheck.tipSystem.Tip;
import com.oncheck.tipSystem.TipFactory;
import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

public class TipSpec {

    TipFactory tipFactory = new TipFactory();
    Tip tip = tipFactory.createTip("derp", "C:/tip/hairinmahfood.jpg");

    @Test
    public void tipCreationTest() {
        Tip actual = tip;
        assertNotNull(tip);
    }

    @Test
    public void tipGetMessageTest() {
        String expected = "derp";
        String actual = tip.getMessage();
        assertEquals(expected,actual);
    }

    @Test
    public void tipGetEvidenceTest() {
        String expected = "C:/tip/hairinmahfood.jpg";
        String actual = tip.getEvidence();
        assertEquals(expected,actual);
    }


}
