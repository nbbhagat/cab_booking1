package entity;

import java.io.Serializable;
import java.util.ArrayList;
import dataStore.MemManager;
import service.Payment;
import service.Ride;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class User implements java.io.Serializable {
        private MemManager mManager;
        
        String userId;
        String name;
        String phoneNo;
        int numRides=0;
        String password;
        Location location;
        float avgRating=0;
        
        public User(){
        }
        public User(String name, String phoneNo,String password,Location location){
                this.name=name;
                this.phoneNo=phoneNo;
                this.password=password;
                this.location=location;
                this.mManager=MemManager.getInstance();
        }
        public void setNumRides1() {
                this.numRides++;
        }
        public void setAvgRating1(int rating) {
                this.avgRating=avgRating+(rating-avgRating)/(numRides);
        }

        public  void viewRideHistory(String userId){
                this.mManager=MemManager.getInstance();
                ArrayList<String> record= mManager.userBooking.get(userId);
                    
                    if(record!=null)
                    {
                        for (int i = 0; i < record.size(); i++) {
                                String bookingId=record.get(i) ;
                                Ride ride=mManager.rideMap.get(bookingId);
                                if(ride!=null)
                                    System.out.println(i+1+". "+ride);
                                else
                                    System.out.println(i+1+". Ride cancelled");
                        }

                    }
                    else  System.out.println("No record found");
        }

        public  void viewPaymentHistory(String userId){
            this.mManager=MemManager.getInstance();
                ArrayList<String> record= mManager.userBooking.get(userId);
                if(record!=null)
                {
                    for (int i = 0; i < record.size(); i++) {
                            String bookingId=record.get(i) ;
                            Payment payment =mManager.payMap.get(bookingId);
                            System.out.println(i+1+". "+payment);
                    }

                }
                else  System.out.println("No record found");
        }
}

