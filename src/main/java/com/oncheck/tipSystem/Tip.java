package com.oncheck.tipSystem;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Tip {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long Id;

    @Column(name="MESSAGE")
    private String message;

    @Column(name="EVIDENCE")
    private String evidence;

    @Column(name="USER_ID")
    private Long userId;

    @Column(name="LOCATION_ID")
    private String locationId;

    public Tip() {

    }

    public Tip(String message, String evidence, Long userId) {
        this.message = message;
        this.evidence = evidence;
        this.userId = userId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }
}
