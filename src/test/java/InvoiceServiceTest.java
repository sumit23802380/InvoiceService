import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.invoiceservice.InvoiceGenerator;

/**
 * UC 1 - Calculate Fare
 * Given distance and time, the invoice generator
 * should return the total fare for the journey.
 * Cost - Rs. 10 per kilometer + Rs. 1 per minute.
 * Minimum Fare - Rs. 5
 */
public class InvoiceServiceTest {
    @Test
    public void calculateFareTest(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance , time);
        Assert.assertEquals(25.00 ,fare , 0.00);
    }
}
