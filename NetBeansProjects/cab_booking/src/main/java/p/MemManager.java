package p;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.*; 

public class MemManager { 
	public ConcurrentHashMap<String, User> userMap;
	public ConcurrentHashMap<String, ArrayList<String>> userBooking;
	public ConcurrentHashMap<String, Ride> rideMap;
	public ConcurrentHashMap<String, Payment> payMap;
	public ConcurrentHashMap<String, Vehicle> driverVehicle;
	
	public void userMapInit()
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
	} 
}
