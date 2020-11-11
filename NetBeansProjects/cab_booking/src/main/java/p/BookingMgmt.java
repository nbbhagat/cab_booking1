package p;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.*;
import java.time.*;
public class BookingMgmt {
	String passengerID;
	String driverID;
	String bookingID;
	double cancelAmount = 100.0;
	int farePerDistance = 10;
	public BookingMgmt(String passengerID, MemManager mmap) {
		this.bookingID = "B" + UUID.randomUUID().toString();
		this.passengerID = passengerID;
		ArrayList<String> al = mmap.userBooking.get(passengerID);
		al.add(this.bookingID);
		mmap.userBooking.put(this.passengerID,al);
	}
	public String findNearestCab(Location pLocation, String region, String vehicleType, MemManager mmap) {
		ConcurrentMap<String, Vehicle> map = mmap.driverVehicle;
		ConcurrentMap<String, Vehicle> availableDrivers = 
		    map.entrySet()
		       .stream()
		       .filter(e -> e.getValue().type == vehicleType)
		       .filter(e -> ((Driver)mmap.userMap.get(e.getKey())).status == true)
		       .filter(e -> ((Driver)mmap.userMap.get(e.getKey())).region == region)
		       .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr = availableDrivers.entrySet().iterator(); 
		ConcurrentHashMap.Entry<String, Vehicle> entry = itr.next(); 
		Location dLocation = mmap.userMap.get(entry.getKey()).location;
		double minDistance = distanceBetweenLocations(pLocation, dLocation);
		String closestDriver = entry.getKey();
		double distance = 0.0;
		while (itr.hasNext()) { 
			entry = itr.next(); 
			dLocation = mmap.userMap.get(entry.getKey()).location;
			distance = distanceBetweenLocations(pLocation, dLocation);
			if(distance < minDistance) {
				minDistance = distance;
				closestDriver = entry.getKey();
			}
		} 		
		return closestDriver;
	}
	public double calculateFare(Location source, Location dest, Vehicle v) {
		double vFare = (double)v.baseFare;
		double dFare;
		double distance = distanceBetweenLocations(source, dest);
		dFare = distance * farePerDistance;
		return (vFare + dFare);
	}
	//	if waitingTime concept is added
	//	public void calculateActualFare() {}
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
	public Ride startRide(Location source, Location dest, MemManager mmap, String driverID) {
		String startTime = LocalTime.now().toString();
		String date = LocalDate.now().toString();
		Ride r =new Ride(startTime, source, dest, date, bookingID);
		//set driver status as not available
		Driver d = (Driver)mmap.userMap.get(driverID);
		d.status = false;
		mmap.userMap.put(driverID,d);
		mmap.rideMap.put(this.bookingID,r);
		return r;
	}
	public void endRide(Ride r, int rating, MemManager mmap, String driverID) {
		String endTime = LocalTime.now().toString();
		r.setStatus("Completed");
		r.setEndTime(endTime);
		r.setRating(rating);
		mmap.rideMap.put(this.bookingID,r);
		//set driver status as available
		Driver d = (Driver)mmap.userMap.get(driverID);
		d.status = true;
		mmap.userMap.put(driverID,d);
	} 
	public void cancelRide(String mode, MemManager mmap, String passID) {
		Payment p = new Payment(mode, this.cancelAmount, this.bookingID, passID);
		p.setComments(Payment.paymentType.CANCELLATION_FEE);
		p.processPayment();
		mmap.payMap.put(this.bookingID, p);

	}
	public void makePayment(String mode, double amount, MemManager mmap, String passID) {
		Payment p = new Payment(mode, amount, this.bookingID, passID);
		p.setComments(Payment.paymentType.RIDE_FEE);
		p.processPayment();
		mmap.payMap.put(this.bookingID, p);
	}
}
