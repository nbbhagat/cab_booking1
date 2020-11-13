package services1;
import entity1.Location;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ride implements java.io.Serializable{
	String startTime;
	String endTime;
	int rating;
	String status; //started, completed, waiting(?)
	Location source;
	Location dest;
	String date;
	String bookingID;
	long waitingTime;
        
        
	public Ride(String startTime, Location source, Location dest, String date, String bookingID) {
		this.startTime = startTime;
		this.source = source;
		this.dest = dest;
		this.date = date;
		this.bookingID = bookingID;
		this.status = "Started";
	}
	
	@Override
	public String toString() {
		return ("Start time = "+this.startTime+", End time = "+this.endTime+", rating = "+rating + ", status = "+this.status+", source= "+source+", dest="+this.dest+", date= "+this.date);
	}
}
