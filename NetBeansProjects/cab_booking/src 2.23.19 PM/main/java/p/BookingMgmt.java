package p;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.*;
public class BookingMgmt {
	String passengerID;
	String driverID;
	String bookingID;
	public String findNearestCab(Location pLocation, String region, String vehicleType, 
			ConcurrentHashMap<String, Vehicle> driverVehicle, 
			ConcurrentHashMap<String, User> userMap) {
		ConcurrentMap<String, Vehicle> map = driverVehicle;
		ConcurrentMap<String, Vehicle> availableDrivers = 
		    map.entrySet()
		       .stream()
		       .filter(e -> e.getValue().type == vehicleType)
		       .filter(e -> ((Driver)userMap.get(e.getKey())).status == true)
		       .filter(e -> userMap.get(e.getKey()).region == region)
		       .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr = availableDrivers.entrySet().iterator(); 
		ConcurrentHashMap.Entry<String, Vehicle> entry = itr.next(); 
		Location dLocation = userMap.get(entry.getKey()).location;
		double minDistance = distanceBetweenLocations(pLocation, dLocation);
		String closestDriver = entry.getKey();
		double distance = 0.0;
		while (itr.hasNext()) { 
			entry = itr.next(); 
			dLocation = userMap.get(entry.getKey()).location;
			distance = distanceBetweenLocations(pLocation, dLocation);
			if(distance < minDistance) {
				minDistance = distance;
				closestDriver = entry.getKey();
			}
			//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		} 		
		return closestDriver;
	}
	public void calculatePredictedFare() {
		
	}
	public double distanceBetweenLocations(Location l1, Location l2) {
		int x1 = l1.longitude;
		int y1 = l1.latitude;
		int x2 = l2.longitude;
		int y2 = l2.latitude;
		int x = Math.abs(x2 -x1);
		int y = Math.abs(y2 -y1);
		return Math.sqrt(x*x + y*y);
	}
//	public void driverRequest() {	}
//	public void generateOTP() {	}
	public void createRide() {
		//init startTime, status = started, create ride object
		//set driver status as working (?)
	}
}
