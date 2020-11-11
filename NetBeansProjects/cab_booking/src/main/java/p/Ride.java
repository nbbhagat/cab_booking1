package p;
public class Ride implements java.io.Serializable{
	String startTime;
	String endTime;
	int rating;
	String status; //started, completed, waiting(?)
	Location source;
	Location dest;
	String date;
//	long otp;
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
	public void setStatus(String status) {
		this.status = status;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setRating(int  rating) {
		this.rating = rating;
	}
}
