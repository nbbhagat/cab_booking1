package entity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Location implements java.io.Serializable{
    int latitude;
    int longitude;
    region r; 
    
    public enum region {
    	DELHI, MUMBAI, CHENNAI, BANGALORE;
    }
    public Location(){
        
    }
    public Location(int latitude, int longitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.r = region.MUMBAI;
        if((latitude>0&&latitude<=25)&&(longitude>0&&longitude<=25))
        	this.r = region.DELHI;
        else if((latitude>25&&latitude<=50)&&(longitude>25&&longitude<=50))
        	this.r = region.MUMBAI;
        else if((latitude>50&&latitude<=75)&&(longitude>50&&longitude<=75))
        	this.r = region.CHENNAI;
        else if((latitude>75&&latitude<=100)&&(longitude>75&&longitude<=100))
        	this.r = region.BANGALORE;
    }
    @Override
    public String toString(){
        return "lattitude = "+latitude+", longitude= "+longitude + ", region= "+r;
    }
}