import entity.*;
import service.BookingMgmt;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CabAppTestService {

    BookingMgmt bm = new BookingMgmt();

    @Test
    public void testCalculateFare(){
        Location source = new Location(26,34);
        Location dest = new Location(78,83);
        Vehicle v1=new Auto();
        double fare = bm.calculateFare(source, dest, v1);
        assertEquals(457,(int)fare,0.0);
        v1=new Bike();
        fare = bm.calculateFare(source, dest, v1);
        assertEquals(355,(int)fare,0.0);
        v1=new Car();
        fare = bm.calculateFare(source, dest, v1);
        assertEquals(650,(int)fare,0.0);
    }
    }
