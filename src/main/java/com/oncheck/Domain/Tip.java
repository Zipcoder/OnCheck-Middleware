package com.oncheck.Domain;

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

    @Column(name="USERID")
    private Long userId;

    @Column(name="LOCATIONID")
    private String locationId;

    public Tip() {

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
