package p;
public class User implements java.io.Serializable{
    String userId;
    String name;
    int phoneNo;
    int numRides=0;
    String password;
    Location location=null;
    float avgRating=0;
    String region;
    public User(String userId, String name, int phoneNo,String password,Location location, String region){
        this.userId=userId;
        this.name=name;
        this.phoneNo=phoneNo;
        //this.numRides=numRides;
        this.password=password;
        this.location=location;
        this.region = region;
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
    //admin
    public  void viewRideHistory(){
        
    }
    
}

class Passenger extends User{
    Address address=null;
    public Passenger(String userId, String name, int phoneNo,String password,Location location,Address address,String region){
        super(userId,name,phoneNo,password,location,region);
        this.address=address;
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location+" "+address;
    }
}
class Driver extends User{
    boolean status;
    public Driver(String userId, String name, int phoneNo,String password,Location location, boolean status,String region){
        super(userId,name,phoneNo,password,location,region);
        this.status=status;
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location;
    }
}