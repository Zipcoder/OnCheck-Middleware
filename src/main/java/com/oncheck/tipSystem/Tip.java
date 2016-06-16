package com.oncheck.tipSystem;

public class Tip {

    private String message;
    private String evidence;

    Tip(String message, String evidence) {
        this.message = message;
        this.evidence = evidence;
    }

    public String getMessage() {
        return message;
    }

    public String getEvidence() {
        return evidence;
    }



}
