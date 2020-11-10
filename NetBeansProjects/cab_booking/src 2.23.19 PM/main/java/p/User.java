package p;
public class User implements java.io.Serializable{
    int userId;
    String name;
    int phoneNo;
    int numRides=0;
    String password;
    Location location=null;
    float avgRating=0;
    String region;
    public User(int userId, String name, int phoneNo,int numRides,String password,int latitude,int longitude, String region){
        this.userId=userId;
        this.name=name;
        this.phoneNo=phoneNo;
        //this.numRides=numRides;
        this.password=password;
        this.location=new Location(latitude,longitude);
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
    public Passenger(int userId, String name, int phoneNo,int numRides,String password,int latitude,int longitude,Address address){
        super(userId,name,phoneNo,numRides,password,latitude,longitude);
        this.address=address;
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location+" "+address;
    }
}
class Driver extends User{
    boolean status;
    public Driver(int userId, String name, int phoneNo,int numRides,String password,int latitude,int longitude, boolean status){
        super(userId,name,phoneNo,numRides,password,latitude,longitude);
        this.status=status;
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location;
    }
}