package com.oncheck.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by stevejaminson on 7/5/16.
 */

@Entity
public class Code {

    @Id
    @GeneratedValue
    @Column
    private Long Id;

    @Column(name = "CODE_ANNOTATION")
    private String codeAnnotation;

    @Column(name = "CODE_PART")
    private String codePart;

    @Column(name = "CODE_SUB_PART")
    private String codeSubPart;

    @Column(name = "CODE_HEADING")
    private String codeHeading;

    public Code(){
    }

    public Code(String codeAnnotation, String codePart, String codeSubPart, String codeHeading){
        this.codeAnnotation = codeAnnotation;
        this.codePart = codePart;
        this.codeSubPart = codeSubPart;
        this.codeHeading = codeHeading;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCodeAnnotation() {
        return codeAnnotation;
    }

    public void setCodeAnnotation(String codeAnnotation) {
        this.codeAnnotation = codeAnnotation;
    }

    public String getCodePart() {
        return codePart;
    }

    public void setCodePart(String codePart) {
        this.codePart = codePart;
    }

    public String getCodeSubPart() {
        return codeSubPart;
    }

    public void setCodeSubPart(String codeSubPart) {
        this.codeSubPart = codeSubPart;
    }

    public String getCodeHeading() {
        return codeHeading;
    }

    public void setCodeHeading(String codeHeading) {
        this.codeHeading = codeHeading;
    }
}
