package com.bridgelabz.invoiceservice;

import java.util.List;

public class User {
    public String userId;
    public Ride[] ridesList;
    public User(String userId){
        this.userId = userId;
    }
    public User(String userId , Ride[] ridesList){
        this.userId = userId;
        this.ridesList = ridesList;
    }
}
