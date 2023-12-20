import com.bridgelabz.invoiceservice.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * UC 1 - Calculate Fare
 * Given distance and time, the invoice generator
 * should return the total fare for the journey.
 * Cost - Rs. 10 per kilometer + Rs. 1 per minute.
 * Minimum Fare - Rs. 5
 *
 *
 * UC 2 - Multiple Rides
 * The Invoice Generator should now take in multiple
 * rides, and calculate the aggregate total for all.
 *
 *
 * UC 3 - Enhanced Invoice
 * The Invoice Generator should now return the
 * following as a part of the invoice -
 *  - Total Number of Rides
 *  - Total Fare
 *  - Average Fare Per Ride
 *
 * UC 4 - Invoice Service
 * Given a user id, the Invoice Service gets the List
 * of rides from the RideRepository, and returns the
 * Invoice.
 */

public class InvoiceServiceTest {
    InvoiceService invoiceService;
    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }
    @Test
    public void calculateFareTest() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time , RideType.NORMAL);
        Assert.assertEquals(25.00, fare, 0.00);
        distance = 0.1;
        time = 1;
        Assert.assertEquals(5.00, invoiceService.calculateFare(distance, time , RideType.NORMAL), 0.00);

        distance = 1.00;
        time = 1;
        fare = invoiceService.calculateFare(distance,time,RideType.PREMIUM);
        Assert.assertEquals(20 , fare , 0.00);
    }

    @Test
    public void testMultipleRidesSummary() {
        Ride[] rides = {new Ride(2.0, 5 , RideType.NORMAL), new Ride(0.1, 1 ,RideType.NORMAL)};
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2 , 30.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    @Test
    public void getInvoiceSummaryByUserIdIfUserIdExists(){
        Ride[] rides = {new Ride(2.0, 5 , RideType.NORMAL), new Ride(0.1, 1 ,RideType.NORMAL)};
        User user = new User("sumit@gmail.com" , rides);
        UsersList.add(user);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary("sumit@gmail.com");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2 , 30.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);


        User userWithNoRides = new User("amit@gmail.com");
        UsersList.add(userWithNoRides);
        InvoiceSummary invoiceSummaryOfNoRides = invoiceService.getInvoiceSummary("amit@gmail.com");
        InvoiceSummary expectedInvoiceSummaryOfNoRides = new InvoiceSummary(0 , 0);
        Assert.assertEquals(expectedInvoiceSummaryOfNoRides, invoiceSummaryOfNoRides);
    }
    @Test
    public void getInvoiceSummaryByUserIdIfUserDoesNotExists(){
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary("sumit@gmail.com");
        Assert.assertNull(invoiceSummary);
    }


}
