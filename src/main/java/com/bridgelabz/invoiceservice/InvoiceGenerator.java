package com.bridgelabz.invoiceservice;

/**
 * @desc : InvoiceGenerator Class
 */
public class InvoiceGenerator {
    public static final double COST_PER_KILOMETER = 10.000;
    public static final int COST_PER_MINUTE = 1;
    public static double MINIMUM_FARE_COST = 5.00;
    public double calculateFare(double distance , int time){
        return Math.max(MINIMUM_FARE_COST ,distance*COST_PER_KILOMETER + time*COST_PER_MINUTE);
    }
    public static void main(String[] args) {

    }
}
