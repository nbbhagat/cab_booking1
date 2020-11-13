package entity1;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Driver extends User implements java.io.Serializable {
        boolean status;
        Vehicle vehicle;
        public Driver(String name, String phoneNo, String password, Location location, boolean status, Vehicle vehicle){
                super(name,phoneNo,password,location);
                this.status=status;
                this.vehicle=vehicle;
                userId="D"+UUID.randomUUID().toString();
        }
        public void setSstatus() {
            this.status = !status;
        }

        @Override
        public String toString(){
            return "name:-> "+this.name+", phoneNo-> "+this.phoneNo+", avgRating-> "+this.avgRating+", location-> "+this.location;
        }
}

