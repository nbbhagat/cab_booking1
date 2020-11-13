package entity;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Car extends Vehicle implements java.io.Serializable{
    
    public int capacity=4;
    public double baseFare=150;

    public double factor=7;
    public void setId(){
        vId="VC"+UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
    	return "VId: "+vId +" capacity: "+capacity +" base fare: "+baseFare+" factor : "+factor;
    }

}
