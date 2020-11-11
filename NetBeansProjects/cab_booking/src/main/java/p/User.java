package p;

import java.util.ArrayList;
import java.util.UUID;
public class User implements java.io.Serializable{
    String userId;
    String name;
    String phoneNo;
    int numRides=0;
    String password;
    Location location=null;
    float avgRating=0;
    String region;
    public User(){
        
    }
    public User(String name, String phoneNo,String password,Location location, String region){
        this.name=name;
        this.phoneNo=phoneNo;
        
        this.password=password;
        this.location=location;
        this.region = region;
    }
    
    public void setNumRides() {
        this.numRides++;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getNumRides() {
        return numRides;
    }
    public float getAvgRating() {
        return avgRating;
    }
    public void setAvgRating(int rating) {
        this.avgRating=avgRating+(rating-avgRating)/(numRides);
    }
    
    public  void viewRideHistory(MemManager mmap,String userId){
        ArrayList<String> record= mmap.userBooking.get(userId);
            if(record!=null)
            {
                for (int i = 0; i < record.size(); i++) {
                        String bookingId=record.get(i) ;
                        Ride ride=mmap.rideMap.get(i);
                        System.out.println(i+1+". "+ride);
                }

            }
            else  System.out.println("No record found");
    }
    
    public  void viewPaymentHistory(MemManager mmap,String userId){
            ArrayList<String> record= mmap.userBooking.get(userId);
            if(record!=null)
            {
                for (int i = 0; i < record.size(); i++) {
                        String bookingId=record.get(i) ;
                        Payment payment =mmap.payMap.get(i);
                        System.out.println(i+1+". "+payment);
                }

            }
            else  System.out.println("No record found");
    }
    
}

class Passenger extends User{
    Address address=null;
    public Passenger(String name, String phoneNo,String password,Location location,Address address,String region){
        super(name,phoneNo,password,location,region);
        this.address=address;
        this.userId="p"+UUID.randomUUID().toString();
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location+" "+address;
    }
}
class Driver extends User{
    boolean status;
    public Driver(String name, String phoneNo,String password,Location location, boolean status,String region){
        super(name,phoneNo,password,location,region);
        this.status=status;
        this.userId="d"+UUID.randomUUID().toString();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus() {
        this.status = !status;
    }
    
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location;
    }
}