package com.oncheck.tipSystem;

public class TipFactory {

    public Tip createTip(String message, String evidence) {
        return new Tip(message, evidence);
    }
}
