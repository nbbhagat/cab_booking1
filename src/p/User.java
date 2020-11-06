package p;

public class User {
    String userId;
    String name;
    int phoneNo;
    int numRides=0;
    String password;
    Location location;
    float avgRating=0;
    public User(String userId, String name, int phoneNo,int numRides,String password,Location location){
        this.userId=userId;
        this.name=name;
        this.phoneNo=phoneNo;
        //this.numRides=numRides;
        this.password=password;
        this.location=location;
    }
    public void setNumRides() {
        this.numRides++;
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
    public  void viewRideHistory(){
        
    }
}
class Passenger extends User{
    Address address;
    public Passenger(String userId, String name, int phoneNo,int numRides,String password,Location location,Address address){
        super(userId,name,phoneNo,numRides,password,location);
        this.address=address;
    }
}
class Driver extends User{
    boolean status;
    public Driver(String userId, String name, int phoneNo,int numRides,String password,Location location, boolean status){
        super(userId,name,phoneNo,numRides,password,location);
        this.status=status;
    }
}
