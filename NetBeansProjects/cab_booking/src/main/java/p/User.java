package p;

import java.util.UUID;
import java.util.ArrayList;

public class User implements java.io.Serializable {
    private MemManager mManager;

    
    String userId;
    String name;
    String phoneNo;
    int numRides=0;
    String password;
    Location location;
    float avgRating=0;
    public User(){

    }
    public User(String name, String phoneNo,String password,Location location){
        this.name=name;
        this.phoneNo=phoneNo;
        this.password=password;
        this.location=location;
        this.mManager=MemManager.getInstance();
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
    
    public void setAvgRating(int rating) {
        this.avgRating=avgRating+(rating-avgRating)/(numRides);
    }
    
    public  void viewRideHistory(String userId){
        ArrayList<String> record= mManager.userBooking.get(userId);
            if(record!=null)
            {
                for (int i = 0; i < record.size(); i++) {
                        String bookingId=record.get(i) ;
                        Ride ride=mManager.rideMap.get(bookingId);
                        System.out.println(i+1+". "+ride);
                }

            }
            else  System.out.println("No record found");
    }

    public  void viewPaymentHistory(String userId){
            ArrayList<String> record= mManager.userBooking.get(userId);
            if(record!=null)
            {
                for (int i = 0; i < record.size(); i++) {
                        String bookingId=record.get(i) ;
                        Payment payment =mManager.payMap.get(bookingId);
                        System.out.println(i+1+". "+payment);
                }

            }
            else  System.out.println("No record found");
    }
}
class Passenger extends User{
     public Passenger(String name, String phoneNo,String password,Location location){
        super(name,phoneNo,password,location);
        this.userId="P"+UUID.randomUUID().toString();
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location;
    }
}
class Driver extends User{
        boolean status;
        public Driver(String name, String phoneNo,String password,Location location, boolean status,Vehicle vehicle){
                super(name,phoneNo,password,location);
                this.status=status;
                this.userId="D"+UUID.randomUUID().toString();
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
