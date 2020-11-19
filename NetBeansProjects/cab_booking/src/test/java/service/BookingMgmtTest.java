/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dataStore.MemManager;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pranavasishmenon
 */
public class BookingMgmtTest {
    private MemManager memManager;
    public BookingMgmtTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findNearestCab method, of class BookingMgmt.
     */
    @Test
    public void testFindNearestCab() {
        this.memManager = MemManager.getInstance();
        Location pLocation = new Location(1, 1);
        Location loc1 = new Location(2, 2);
        Location loc2 = new Location(3, 3);
        Location loc3 = new Location(4, 4);
        Auto auto = new Auto();
        auto.setId();        
        Bike bike = new Bike();
        bike.setId();        
        Car car = new Car();
        car.setId();
        Driver driver1 = new Driver("driver1", "5555555555", "driver1lol", loc1, true, auto);
        Driver driver2 = new Driver("driver2", "5555555555", "driver2lol", loc2, true, bike);
        Driver driver3 = new Driver("driver3", "5555555555", "driver3lol", loc3, true, car);
        System.out.println(driver1);
        this.memManager.userMap.put(driver1.getUserId(), driver1);
        this.memManager.userMap.put(driver2.getUserId(), driver2);
        this.memManager.userMap.put(driver3.getUserId(), driver3);
        this.memManager.driverVehicle.put(driver1.getUserId(), auto);
        this.memManager.driverVehicle.put(driver2.getUserId(), bike);
        this.memManager.driverVehicle.put(driver3.getUserId(), car);
        System.out.println("findNearestCab");
            
        char vehicleType = 'A';
        BookingMgmt instance = new BookingMgmt();
        String expResult = driver1.getUserId();
        String result = instance.findNearestCab(pLocation, vehicleType);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFare method, of class BookingMgmt.
     */
    @Test
    public void testCalculateFare() {
        System.out.println("calculateFare");
        Location source = new Location(1, 1);
        Location dest = new Location(4,5);
        Vehicle v=new Auto();
        ((Auto) v).setId();
        BookingMgmt instance = new BookingMgmt();
        double expResult = 125.0;
        double result = instance.calculateFare(source, dest, v);
        assertEquals(expResult, result, 0.0);
    }
    
}
