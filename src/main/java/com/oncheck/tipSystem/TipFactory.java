package com.oncheck.tipSystem;

import com.oncheck.Domain.Tip;

public class TipFactory {

    public Tip createTip(String message, String evidence, Long userId, String locationId) {
        return new Tip(message, evidence, userId, locationId);
    }
}
