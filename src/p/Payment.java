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
}
public void processPayment()
{
	if (mode=="cash")
	{
		
	}
	else if(mode=="netbanking")
	{
		System.out.println("Enter card Number :");
		System.out.println("Enter Pin :");
		System.out.println("Enter ExpMonth :");
		System.out.println("Enter ExpYear :");
		
	}
	else
	{
		
	}
}
public void updateStatus() {
	//if driver has accepted cash return success
	//If bank returns successful payment return success
}
}