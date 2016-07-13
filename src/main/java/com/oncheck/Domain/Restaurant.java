package com.oncheck.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @Column(name = "RESTAURANT_ADDRESS")
    private String restaurantAddress;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIPCODE")
    private String zip;

    @Column
    private String county;

    @Column(name = "RESTAURANT_ID")
    private String restaurantID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Inspection> inspections = new ArrayList<>();

    @Column
    private int onCheckScore;

    public Restaurant(){
    }


    public Restaurant(String restaurantName, String restaurantAddress, String city,String zip, String county,String inspectionType,String inspectionDate,String violations){

        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantID = restaurantName+restaurantAddress;
        this.city = city;
        this.zip = zip;
        this.county = county;
        this.inspections.add(new Inspection(inspectionType,inspectionType,violations));
    }

    public String getRestaurantName(){
        return restaurantName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
    }

    public void addInspection(Inspection inspection){
        this.inspections.add(inspection);
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public int getOnCheckScore() {
        return onCheckScore;
    }

    public void setOnCheckScore(int onCheckScore) {
        this.onCheckScore = onCheckScore;
    }

    public String getRestaurantAddress(){
        return restaurantAddress;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }
}
