package p;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.*; 

public class MemManager { 
	public ConcurrentHashMap<Integer, User> userMap;
	public ConcurrentHashMap<Integer, Ride> rideMap;
	public ConcurrentHashMap<Integer, Payment> payMap;
	public ConcurrentHashMap<String, String> driverVehicle;
	
	public void userMapInit()
	{
		userMap = new ConcurrentHashMap<>();
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
