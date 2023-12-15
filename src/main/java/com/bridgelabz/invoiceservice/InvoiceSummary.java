package com.bridgelabz.invoiceservice;

import java.util.Objects;

public class InvoiceSummary {
    private final int noOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int noOfRides , double totalFare){
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass()!=object.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) object;
        return noOfRides == that.noOfRides && Double.compare(totalFare, that.totalFare) == 0;
    }
}
