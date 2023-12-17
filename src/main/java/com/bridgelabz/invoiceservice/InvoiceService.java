package com.bridgelabz.invoiceservice;

/**
 * @desc : InvoiceGenerator Class
 */
public class InvoiceService {
    public static final double NORMAL_COST_PER_KILOMETER = 10.000;
    public static final int NORMAL_COST_PER_MINUTE = 1;
    public static double NORMAL_MINIMUM_FARE_COST = 5.00;

    public static final double PREMIUM_COST_PER_KILOMETER = 15.000;
    public static final int PREMIUM_COST_PER_MINUTE = 2;
    public static double PREMIUM_MINIMUM_FARE_COST = 20.00;

    public double calculateFare(double distance , int time , RideType rideType){
        if(rideType == RideType.NORMAL){
            return Math.max(NORMAL_MINIMUM_FARE_COST ,distance*NORMAL_COST_PER_KILOMETER + time*NORMAL_COST_PER_MINUTE);
        }
        return Math.max(PREMIUM_MINIMUM_FARE_COST ,distance*PREMIUM_COST_PER_KILOMETER + time*PREMIUM_COST_PER_MINUTE);
    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0.00;
        for(Ride ride : rides){
            totalFare += calculateFare(ride.distance , ride.time , ride.rideType);
        }
        return new InvoiceSummary(rides.length , totalFare);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        User user = UsersList.getUserById.get(userId);
        if(user == null){
            return null;
        }
        else if(user.ridesList == null){
            return new InvoiceSummary(0,0);
        }
        return calculateFare(user.ridesList);
    }
}
