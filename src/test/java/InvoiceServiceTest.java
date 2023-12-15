import com.bridgelabz.invoiceservice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bridgelabz.invoiceservice.InvoiceGenerator;
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
 */

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    @Test
    public void calculateFareTest() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.00, fare, 0.00);
        distance = 0.1;
        time = 1;
        Assert.assertEquals(5.00, invoiceGenerator.calculateFare(distance, time), 0.00);
    }

    @Test
    public void testMultipleRides() {
        Ride[] rides = {new Ride(2.0, 5) , new Ride(0.1 , 1)};
        double fare  = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30.00 , fare , 0.00);
    }
}
