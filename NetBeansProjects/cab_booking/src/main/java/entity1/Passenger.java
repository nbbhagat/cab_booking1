package entity1;

import java.util.UUID;

public class Passenger extends User implements java.io.Serializable {
     public Passenger(String name, String phoneNo,String password, Location location){
            super(name,phoneNo,password,location);
            userId="P"+UUID.randomUUID().toString();
    }
     
    @Override
    public String toString(){
            return "name:-> "+name+", phoneNo-> "+this.phoneNo+", avgRating-> "+this.avgRating+", location-> "+this.location;
    }
}
