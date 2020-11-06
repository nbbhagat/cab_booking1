package p;
import java.util.HashMap;

public class MemManager {
	public HashMap<Integer, User> userMap;
	public HashMap<Integer, Ride> rideMap;
	public HashMap<Integer, Payment> payMap;
	
	public void mapInit()
	{
		userMap = new HashMap<>();
		rideMap = new HashMap<>();
		payMap = new HashMap<>();
	} 
	public HashMap<Integer, User> userMapRet()
	{
		return userMap;
	}
	public HashMap<Integer, Ride> rideMapRet()
	{
		return rideMap;
	}
	public HashMap<Integer, Payment> payMapRet()
	{
		return payMap;
	}
}
