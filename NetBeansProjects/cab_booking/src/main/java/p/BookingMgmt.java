package p;
import Entity.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.*;
import java.time.*;
public class BookingMgmt {
        private MemManager mManager;
	String passengerID;
	String driverID;
	String bookingID;
	double cancelAmount = 100.0;
	
	public BookingMgmt(String passengerID) {
                this.mManager=MemManager.getInstance();
		this.bookingID = "B" + UUID.randomUUID().toString();
		this.passengerID = passengerID;
		if(mManager.userBooking.get(this.passengerID)!=null)
		{
			ArrayList<String> al = mManager.userBooking.get(this.passengerID);
			al.add(this.bookingID);
			mManager.userBooking.put(this.passengerID,al);
		}
		else
		{
			ArrayList<String> al = new ArrayList<String>();
			al.add(this.bookingID);
			mManager.userBooking.put(this.passengerID,al);
		}		

	}
	public String findNearestCab(Location pLocation, char vehicleType) {
		ConcurrentMap<String, Vehicle> map = mManager.driverVehicle;
		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr1 = map.entrySet().iterator(); 
		while(itr1.hasNext()) {
			ConcurrentHashMap.Entry<String, Vehicle> entry1 = itr1.next(); 
			System.out.println(entry1.getValue().getvId().charAt(1)+" "+vehicleType);		
			System.out.println(mManager.userMap.get(entry1.getKey()));
		}
		System.out.println("All fine till now");
		ConcurrentMap<String, Vehicle> availableDrivers = 
		    map.entrySet()
		       .stream()
		       .filter(e -> e.getValue().getvId().charAt(1)== vehicleType)
		       .filter(e -> ((Driver)mManager.userMap.get(e.getKey())).status == true)
		       .filter(e -> ((Driver)mManager.userMap.get(e.getKey())).location.r.equals(pLocation.r))
		       .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(availableDrivers);
		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr = availableDrivers.entrySet().iterator();
		String closestDriver="lol";
		if(itr.hasNext()) {
			ConcurrentHashMap.Entry<String, Vehicle> entry = itr.next(); 
			Location dLocation = mManager.userMap.get(entry.getKey()).location;
			double minDistance = distanceBetweenLocations(pLocation, dLocation);
			closestDriver = entry.getKey();
			double distance = 0.0;
			while (itr.hasNext()) { 
				entry = itr.next(); 
				dLocation = mManager.userMap.get(entry.getKey()).location;
				distance = distanceBetweenLocations(pLocation, dLocation);
				if(distance < minDistance) {
					minDistance = distance;
					closestDriver = entry.getKey();
				}
			} 	
		}
		return closestDriver;
	}
	public double calculateFare(Location source, Location dest, Vehicle v) {
                String vId=v.getvId();
                //String str=new String();
                double vFare=0;
                double dFare=0;
                switch(vId.charAt(1)){
                    case 'A' : {
                        vFare = ((Auto)v).baseFare;
                        dFare=((Auto)v).factor;
                        break;
                    }
                        
                    case 'B' :
                    {
                       vFare = ((Bike)v).baseFare;
                       dFare=((Bike)v).factor;
                        break;
                    }
                    case 'C' :
                    {
                         vFare = ((Car)v).baseFare;
                         dFare=((Car)v).factor;
                        break;
                    }
                    
                }
                
		
		double distance = distanceBetweenLocations(source, dest);
		return (vFare +  distance * dFare);
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
	public Ride startRide(Location source, Location dest,  String driverID) {
		String startTime = LocalTime.now().toString();
		String date = LocalDate.now().toString();
		Ride r =new Ride(startTime, source, dest, date, bookingID);
		//set driver status as not available
		Driver d = (Driver)mManager.userMap.get(driverID);
		d.status = false;
		mManager.userMap.put(driverID,d);
		mManager.rideMap.put(this.bookingID,r);
		return r;
	}
	public void endRide(Ride r, int rating, String driverID) {
		String endTime = LocalTime.now().toString();
		r.setStatus("Completed");
		r.setEndTime(endTime);
		r.setRating(rating);
		mManager.rideMap.put(this.bookingID,r);
		//set driver status as available
		Driver d = (Driver)mManager.userMap.get(driverID);
		d.status = true;
		mManager.userMap.put(driverID,d);
	} 
	public void cancelRide(String mode,  String passID) {
		Payment p = new Payment(mode, this.cancelAmount, this.bookingID, passID);
		p.setComments(Payment.paymentType.CANCELLATION_FEE);
		p.processPayment();
		mManager.payMap.put(this.bookingID, p);

	}
	public void makePayment(String mode, double amount,  String passID) {
		Payment p = new Payment(mode, amount, this.bookingID, passID);
		p.setComments(Payment.paymentType.RIDE_FEE);
		p.processPayment();
		mManager.payMap.put(this.bookingID, p);
	}
}
