package dataStore;
import dataStore.DBManager;
import services.Payment;
import services.Ride;
import entity.Vehicle;
import entity.User;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.*;
import java.io.File;

public class MemManager implements java.io.Serializable{ 
    private static MemManager MManager;
	public ConcurrentHashMap<String, User> userMap= new ConcurrentHashMap<>();
	public ConcurrentHashMap<String, ArrayList<String>> userBooking= new ConcurrentHashMap<>();
	public ConcurrentHashMap<String, Ride> rideMap=new ConcurrentHashMap<>();
	public ConcurrentHashMap<String, Payment> payMap=new ConcurrentHashMap<>();
	public ConcurrentHashMap<String, Vehicle> driverVehicle=new ConcurrentHashMap<>();
        
        
	public static MemManager getInstance() {
        if (MManager == null) {
            synchronized (MemManager.class) {
                if (MManager == null) {
                    MManager = new MemManager();
                    
                    File uf = new File("userhashmap.ser");
                    File ubf = new File("ubhashmap.ser");
                    File dvf = new File("dvhashmap.ser");
                    File pf = new File("payhashmap.ser");
                    File rf = new File("ridehashmap.ser");

                    if (uf.exists()) {
                        System.out.println("Deserialising existing user map");
                        DBManager DBm = new DBManager();
                        MManager.userMap = DBm.deserializeUserMap();
                        System.out.println(MManager.userMap );
                    } else {
                        System.out.println("Creating user map for the first time");
                        
                        System.out.println(MManager.userMap);
                    }
                    if (ubf.exists()) {
                        System.out.println("Deserialising existing user booking map");
                        DBManager DBm = new DBManager();
                        MManager.userBooking = DBm.deserializeUBMap();

                    } else {
                        System.out.println("Creating user booking map for the first time");
                        
                        System.out.println(MManager.userBooking);
                    }
                    if (dvf.exists()) {
                        System.out.println("Deserialising existing dv map");
                        DBManager DBm = new DBManager();
                        MManager.driverVehicle = DBm.deserializeDVMap();

                    } else {
                        System.out.println("Creating dv map for the first time");
                        
                        System.out.println(MManager.driverVehicle);
                    }
                    if (pf.exists()) {
                        System.out.println("Deserialising existing pay map");
                        DBManager DBm = new DBManager();
                        MManager.payMap = DBm.deserializePayMap();

                    } else {
                        System.out.println("Creating pay map for the first time");
                        
                        System.out.println(MManager.payMap);
                    }
                    if (rf.exists()) {
                        System.out.println("Deserialising existing ride map");
                        DBManager DBm = new DBManager();
                        MManager.rideMap = DBm.deserializeRideMap();

                    } else {
                        System.out.println("Creating ride map for the first time");
                        
                        System.out.println(MManager.rideMap);
                    }

                            }
            }
        }
        return MManager;
    }
	/*public void userMapInit()
	{
		userMap = new ConcurrentHashMap<>();
	}
	public void userBookingInit()
	{
		userBooking = new ConcurrentHashMap<>();
	}
	public void rideMapInit()
	{
		rideMap = new ConcurrentHashMap<>();
	}
	public void payMapInit()
	{
		payMap = new ConcurrentHashMap<>();
	}
	public void dvMapInit()
	{
		driverVehicle = new ConcurrentHashMap<>();
	} */
}
