package com.oncheck.tipSystem;

public class TipFactory {

    public Tip createTip(String message, String evidence, Long userId) {
        return new Tip(message, evidence, userId);
    }
}
