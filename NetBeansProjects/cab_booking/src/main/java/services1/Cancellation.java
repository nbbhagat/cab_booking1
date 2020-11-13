package services1;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cancellation {
	String bookingID;
	String reason;
	float penaltyAmt;
        
        public Cancellation() {
        }
	public Cancellation(String bookingID, String reason, float penaltyAmt) {
		this.bookingID = bookingID;
		this.reason = reason;
		this.penaltyAmt = penaltyAmt;
	}
  
}
