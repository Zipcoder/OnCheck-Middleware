package com.oncheck.Domain;

import javax.persistence.*;

/**
 * Created by brianabbott on 6/16/16.
 */
@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INSPECTION_ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DATE")
    private String date;

    @Column(name = "VIOLATIONS")
    private String violations;

    Inspection(){

    }

    public Inspection(String type, String date,String violations){
        this.type = type;
        this.date = date;
        this.violations = violations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getViolations() {
        return violations;
    }

    public void setViolations(String violations) {
        this.violations = violations;
    }
}
