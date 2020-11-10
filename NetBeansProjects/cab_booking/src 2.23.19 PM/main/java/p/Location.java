package p;
public class Location {
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
