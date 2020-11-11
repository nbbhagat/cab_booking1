package p;
public class Location implements java.io.Serializable{
    int latitude;
    int longitude;
    public Location(){
        
    }
    public Location(int latitude, int longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }
    @Override
    public String toString(){
        return "lattitude = "+latitude+", longitude= "+longitude;
    }
}
