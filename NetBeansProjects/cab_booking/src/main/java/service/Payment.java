package service;

import enums.paymentType;
import java.io.Serializable;
import java.time.LocalDateTime; 
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Payment implements Serializable{
	String mode;
	Double amount;
	String status;
	LocalDateTime dateTime;
	String BookingID;
	String PaymentID;
	String passID;
	paymentType comments;


public Payment(String mode, Double amount, String bid,String passID)
{
	this.mode=mode;
	this.amount=amount; //calculated after ride ends or gets cancelled
	this.dateTime=LocalDateTime.now();
	this.BookingID=bid;
	this.passID=passID;
	this.PaymentID="p"+UUID.randomUUID().toString();
	this.status="Payment Initiated";
}

        @Override
        public String toString()
{
	return "Mode : "+this.mode +" Amount : "+this.amount +" Status : "+this.status+" PaymentID : "+this.PaymentID;
}

public void processPayment()
{
	if (mode.equals("cash"))
	{
		System.out.println("Paid in cash to driver");
	}
	else if(mode.equals("ewallet"))
	{
		System.out.println("Paid using ewallet");
		
	}
	this.status="Success";
}
}