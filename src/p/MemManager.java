package p;
import java.util.concurrent.ConcurrentHashMap; 
import java.util.*; 

public class MemManager { 
	public ConcurrentHashMap<Integer, User> userMap;
	public ConcurrentHashMap<Integer, Ride> rideMap;
	public ConcurrentHashMap<Integer, Payment> payMap;
	public ConcurrentHashMap<String, String> driverVehicle;
	
	public void mapInit()
	{
		userMap = new ConcurrentHashMap<>();
		rideMap = new ConcurrentHashMap<>();
		payMap = new ConcurrentHashMap<>();
		driverVehicle = new ConcurrentHashMap<>();
	} 
}
