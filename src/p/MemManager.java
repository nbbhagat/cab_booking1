package p;
import java.util.HashMap;

public class MemManager {
	public HashMap<Integer, User> userMap;
	public HashMap<Integer, Ride> rideMap;
	public HashMap<Integer, Payment> payMap;
	public HashMap<String, String> driverVehicle;
	
	public void mapInit()
	{
		userMap = new HashMap<>();
		rideMap = new HashMap<>();
		payMap = new HashMap<>();
		driverVehicle = new HashMap<>();
	} 
}
