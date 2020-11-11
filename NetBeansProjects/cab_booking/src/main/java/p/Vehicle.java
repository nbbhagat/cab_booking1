package p;
import java.util.UUID;
abstract public class Vehicle {
    String vId;
    //public Vegicle()
    abstract public void setId();

    public String getvId() {
        return vId;
    }
    
}
class Auto extends Vehicle implements java.io.Serializable{
    
    int capacity=3;
    double baseFare=100;
    double factor=5;
    public void setId(){
        vId="VA"+UUID.randomUUID().toString();
    }
}
class Bike extends Vehicle implements java.io.Serializable{
    
    int capacity=2;
    double baseFare=70;
    double factor=4;
    public void setId(){
        vId="VB"+UUID.randomUUID().toString();
    }
}
class Car extends Vehicle implements java.io.Serializable{
    
    int capacity=4;
    double baseFare=150;
    double factor=7;
    public void setId(){
        vId="VC"+UUID.randomUUID().toString();
    }
}