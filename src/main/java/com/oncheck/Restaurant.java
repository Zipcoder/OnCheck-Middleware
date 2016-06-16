package com.oncheck;

/**
 * Created by brianabbott on 6/15/16.
 */
public class Restaurant {

    private Inspection[] inspections;
    //private Tips[] tips;
    private final String restaurantName;
    private final String restaurantAddress;
    private final String restaurantID;
    private int onCheckScore;

    Restaurant(String restaurantName, String restaurantAddress, String restaurantID, int onCheckScore){
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantID = restaurantID;
        this.onCheckScore = onCheckScore;
    }


    public  boolean submitTip(){
        return false;
    }

    public boolean addToFavorites(){
        return false;
    }





}
