package p;

import java.io.Serializable;
import java.time.LocalDateTime; 
import java.util.UUID;

public class Payment implements Serializable{
	String mode;
	int amount;
	String status;
	LocalDateTime dateTime;
	String BookingID;
	String PaymentID;
	String passID;
	//When the transaction happens LocalDateTime myObj = LocalDateTime.now();

public Payment(String mode, int amount, String bid,String passID)
{
	this.mode=mode;
	this.amount=amount; //calculated after ride ends or gets cancelled
	this.dateTime=LocalDateTime.now();
	this.BookingID=bid;
	this.passID=passID;
	this.PaymentID=UUID.randomUUID().toString();
	this.status="Payment Initiated";
}

public String toString()
{
	return "Mode : "+this.mode +" Amount : "+this.amount +" Status : "+this.status+" PaymentID : "+this.PaymentID;
}

public void processPayment()
{
	if (mode=="cash")
	{
		System.out.println("Paid in cash to driver");
	}
	else if(mode=="ewallet")
	{
		System.out.println("Paid using ewallet");
		
	}
	this.status="Success";
}
}