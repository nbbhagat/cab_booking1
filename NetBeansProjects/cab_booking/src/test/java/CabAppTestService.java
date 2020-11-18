import dataStore.MemManager;
import entity.*;
import mainApp.Admin;
import org.junit.Before;
import service.BookingMgmt;
import org.junit.Test;
import service.Payment;
import service.Ride;
import entity.Car;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;


public class CabAppTestService {
    private Admin admin;
    private MemManager Mmanager;
    BookingMgmt bm = new BookingMgmt();
//
    @Before
    public void setUp()
    {
        admin = new Admin();
        Location source = new Location(26,34);
        User pass1 = Passenger.builder().name("shwetha").phoneNo("5555555555").password("shwethalol").location(source).build();
        Auto auto = new Auto();
        Bike bike = new Bike();
        Car car = new Car();
        Driver driver1 = Driver.builder().name("driver1").phoneNo("5555555555").password("driver1lol").location(source).status(true).vehicle(auto).build();
        Driver driver2 = Driver.builder().name("driver2").phoneNo("5555555555").password("driver2lol").location(source).status(true).vehicle(bike).build();
        Driver driver3 = Driver.builder().name("driver3").phoneNo("5555555555").password("driver3lol").location(source).status(true).vehicle(car).build();

        Mmanager = MemManager.getInstance();

        Mmanager.userMap.put(pass1.getUserId(), pass1);
        Mmanager.userMap.put(driver1.getUserId(), driver1);
        Mmanager.userMap.put(driver2.getUserId(), driver2);
        Mmanager.userMap.put(driver3.getUserId(), driver3);
        Mmanager.driverVehicle.put(driver1.getUserId(),auto);
        Mmanager.driverVehicle.put(driver2.getUserId(),bike);
        Mmanager.driverVehicle.put(driver3.getUserId(),car);

    }

    @Test
    public void testCalculateFare(){

        Location source = new Location(26,34);
        Location dest = new Location(78,83);
        Vehicle v1=new Auto();
        ((Auto) v1).setId();
        double fare = bm.calculateFare(source, dest, v1);
        assertEquals(457,(int)fare,0.0);
        Vehicle v2=new Bike();
        ((Bike) v2).setId();
        fare = bm.calculateFare(source, dest, v1);
        assertEquals(355,(int)fare,0.0);
        Vehicle v3=new Car();
        ((Car) v3).setId();
        fare = bm.calculateFare(source, dest, v1);
        assertEquals(650,(int)fare,0.0);
    }
    }
