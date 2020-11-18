
package service;
import entity.Vehicle;
import entity.Auto;
import entity.Bike;
import entity.Driver;
import entity.Location;
import entity.Car;
import enums.paymentType;

import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.*;
import java.time.*;
import dataStore.MemManager;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class BookingMgmt {
        private MemManager mManager;
	String passengerID;
	String driverID;
	String bookingID;
	public double cancelAmount = 100.0;
	
	public BookingMgmt() {
                this.mManager=MemManager.getInstance();		
	}
        public void createNewBooking(String passengerID) {
                this.bookingID = "B" + UUID.randomUUID().toString();
		this.passengerID = passengerID;
		if(mManager.userBooking.get(this.passengerID)!=null)
		{
			mManager.userBooking.get(this.passengerID).add(this.bookingID);
		}
		else
		{
			ArrayList<String> al = new ArrayList<>();
			al.add(this.bookingID);
			mManager.userBooking.put(this.passengerID,al);
		}		
            
        }
	public String findNearestCab(Location pLocation,char vehicleType) {
		ConcurrentMap<String, Vehicle> map = mManager.driverVehicle;
		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr1 = map.entrySet().iterator(); 
		while(itr1.hasNext()) {
			ConcurrentHashMap.Entry<String, Vehicle> entry1 = itr1.next(); 
			System.out.println(entry1.getValue().getVId().charAt(1)+" "+vehicleType);		
			System.out.println(mManager.userMap.get(entry1.getKey()));
		}
		System.out.println("All fine till now");
		ConcurrentMap<String, Vehicle> availableDrivers = 
		    map.entrySet()
		       .stream()
		       .filter(e -> e.getValue().getVId().charAt(1)== vehicleType)
		       .filter(e -> ((Driver)mManager.userMap.get(e.getKey())).isStatus() == true)
		       .filter(e -> ((Driver)mManager.userMap.get(e.getKey())).getLocation().getR().equals(pLocation.getR()))
		       .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(availableDrivers);
		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr = availableDrivers.entrySet().iterator();
		String closestDriver="lol";
		if(itr.hasNext()) {
			ConcurrentHashMap.Entry<String, Vehicle> entry = itr.next(); 
			Location dLocation = mManager.userMap.get(entry.getKey()).getLocation();
			double minDistance = distanceBetweenLocations(pLocation, dLocation);
			closestDriver = entry.getKey();
			double distance = 0.0;
			while (itr.hasNext()) { 
				entry = itr.next(); 
				dLocation = mManager.userMap.get(entry.getKey()).getLocation();
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
                String vId=v.getVId();
                double vFare=0;
                double dFare=0;
                switch(vId.charAt(1)){
                    case 'A' : {
                        vFare = ((Auto)v).getBaseFare();
                        dFare=((Auto)v).getFactor();
                        break;
                    }
                        
                    case 'B' :
                    {
                       vFare = ((Bike)v).getBaseFare();
                       dFare=((Bike)v).getFactor();
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
	public double distanceBetweenLocations(Location l1, Location l2) {
		int x1 = l1.getLongitude();
		int y1 = l1.getLatitude();
		int x2 = l2.getLongitude();
		int y2 = l2.getLatitude();
		int x = Math.abs(x2 -x1);
		int y = Math.abs(y2 -y1);
		return Math.sqrt(x*x + y*y);
	}
	public Ride startRide(Location source, Location dest,  String driverID) {
		String startTime = LocalTime.now().toString();
		String date = LocalDate.now().toString();
		Ride r =new Ride(startTime, source, dest, date, bookingID);
		//set driver status as not available
		Driver d = (Driver)mManager.userMap.get(driverID);
		d.setSstatus() ;
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
		Driver d = (Driver)mManager.userMap.get(driverID);
		d.setSstatus() ;
                Location dlocation = r.getDest();
                d.setLocation(dlocation);
		mManager.userMap.put(driverID,d);
	} 
	public void cancelRide(String mode,  String passID) {
		Payment p = new Payment(mode, this.cancelAmount, this.bookingID, passID);
		p.setComments(paymentType.CANCELLATION_FEE);
		p.processPayment();
		mManager.payMap.put(this.bookingID, p);

	}
	public void makePayment(String mode, double amount,  String passID) {
		Payment p = new Payment(mode, amount, this.bookingID, passID);
		p.setComments(paymentType.RIDE_FEE);
		p.processPayment();
		mManager.payMap.put(this.bookingID, p);
	}
}
