package entity1;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Bike extends Vehicle implements java.io.Serializable{
    
    int capacity=2;
    double baseFare=70;
    double factor=4;
    public void setId(){
        this.vId="VB"+UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
    	return "VId: "+this.vId +" capacity: "+this.capacity +" base fare: "+this.baseFare+" factor : "+this.factor;
    }
}
