package services;
public class Cancellation {
	String bookingID;
	String reason;
	float penaltyAmt;
//	String cancelledBy;
        public Cancellation() {
        }
	public Cancellation(String bookinID, String reason, float penaltyAmt) {
		this.bookingID = bookingID;
		this.reason = reason;
		this.penaltyAmt = penaltyAmt;
	}

    
}
