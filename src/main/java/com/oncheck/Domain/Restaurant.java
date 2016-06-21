package com.oncheck.Domain;

import javax.persistence.*;


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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Inspection_ID")
    private Inspection inspections;

    @Column
    private int onCheckScore;

    Restaurant(){
    }


    public Restaurant(String restaurantName, String restaurantAddress, String city,String zip, String county,String inspectionType,String inspectionDate,String violations){
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantID = restaurantName+restaurantAddress;
        this.city = city;
        this.zip = zip;
        this.county = county;
        this.inspections = new Inspection(inspectionType,inspectionDate,violations);
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

    public Inspection getInspections() {
        return inspections;
    }

    public void setInspections(Inspection inspections) {
        this.inspections = inspections;
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

}
