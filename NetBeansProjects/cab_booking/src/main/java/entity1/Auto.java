package entity1;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Auto extends Vehicle implements java.io.Serializable{
    
    int capacity=3;
    double baseFare=100;
    double factor=5;
    public void setId(){
        this.vId="VA"+UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
    	return "VId: "+this.vId +" capacity: "+this.capacity +" base fare: "+this.baseFare+" factor : "+this.factor;
    }
}
