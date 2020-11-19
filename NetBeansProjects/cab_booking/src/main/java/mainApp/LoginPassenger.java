package mainApp;
import entity.Location;
import entity.User;
import service.Ride;
import service.BookingMgmt;
import dataStore.MemManager;
import java.util.ArrayList;
import java.util.Scanner;


public class LoginPassenger {
    private MemManager mManager;
    public LoginPassenger(){
        this.mManager=MemManager.getInstance();
    }
    public void doFun(User u,Admin AObj){
            String userId=u.getUserId();
            BookingMgmt bm = new BookingMgmt();
            Scanner addInput = new Scanner(System.in);
                boolean login = true;
                InputValidation inputValidation=new InputValidation();
                while (login) {
                    System.out.println("1. Book Cab");
                    System.out.println("2. View Ride History");
                    System.out.println("3. View Payment History");
                    System.out.println("4. Logout");
//                    System.out.println("Enter an option - ");
                    int option3 = inputValidation.optionValidation(4);

                    switch (option3) {
                        case 1: { //Book Cab
                            System.out.println("Current location ");
                            int sLatitude = inputValidation.latitudeValidation();
                            
                            int sLongitude = inputValidation.longitudeValidation(sLatitude);                                                       
                            Scanner sc = new Scanner(System.in);
                            char  vehicleType = inputValidation.vehicleTypeValidation();
                            
                            System.out.println("Enter destination :");
                            int dLatitude = inputValidation.latitudeValidation();
                            int dLongitude = inputValidation.longitudeValidation(dLatitude);
                            
                            System.out.println("Searching for cabs...");
                            bm.createNewBooking(userId);
                            Location source = new Location(sLatitude, sLongitude);
                            Location dest = new Location(dLatitude, dLongitude);
                            String availableDriverID = bm.findNearestCab(source, vehicleType);
                            if(availableDriverID.equals("lol")) System.out.println("cab not available");
                            
                            else{
                                    System.out.println("Driver will be assigned with driver ID " + availableDriverID + " on confirmation.\n1. Confirm\n2. Cancel");
                                    //String id = availableDriverID;
                                    
                            int confirmation = inputValidation.optionValidation(2);
                            switch (confirmation) { //Confirm initially
                                case 1: {
                                            if(mManager.userBooking.get(availableDriverID)!=null)
                                            {
                                                    mManager.userBooking.get(availableDriverID).add(bm.getBookingID());
                                            }
                                            else
                                            {
                                                    ArrayList<String> al = new ArrayList<>();
                                                    al.add(bm.getBookingID());
                                                    mManager.userBooking.put(availableDriverID,al);
                                            }
                                        System.out.println("Your cab will arrive shortly\n1.Confirm arrival of cab and start ride");
                                            System.out.println("2. Cancel ride (will incur cancellation charges)");
                                            int confirmation2 = inputValidation.optionValidation(2);
                                        Ride r = bm.startRide(source, dest, availableDriverID);
                                    switch (confirmation2) {
                                        
                                        case 1: { //Confirm ride start
                                            
                                            System.out.println("Ride has started!");
                                            //Ride r = bm.startRide(source, dest, availableDriverID);
                                            System.out.println("Ride is ongoing...\nPress any key to confirm arrival at destination:");
                                            String arrived = addInput.next();
                                            System.out.println("You have arrived at your destination! ");
                                            int rating = inputValidation.ratingValidation();

                                            double amount = bm.calculateFare(source, dest, mManager.driverVehicle.get(availableDriverID));
                                            bm.endRide(r, rating, availableDriverID);
                                            System.out.println("Please select your mode of payment");
                                            System.out.println("1. Cash\n2. E-Wallet");
                                            int option4 = inputValidation.optionValidation(2);
                                            switch (option4) {
                                                case 1: { //Cash
                                                    bm.makePayment("cash", amount, userId);
                                                    break;
                                                }
                                                case 2: { //E-Wallet
                                                    bm.makePayment("e-wallet", amount, userId);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 2: { //Cancel ride
                                            System.out.println("Your cancellation charges are: " + bm.cancelAmount);
                                            System.out.println("Please select your mode of payment");
                                            System.out.println("1. Cash\n2. E-Wallet");
                                            int option4 = inputValidation.optionValidation(2);
                                            bm.endRide(r, 0, availableDriverID);
                                            switch (option4) {
                                                case 1: { //cash

                                                    bm.cancelRide("cash", userId);
                                                    break;
                                                }
                                                case 2: { //e-wallet

                                                    bm.cancelRide("e-wallet", userId);


                                                    break;
                                                }
                                            }
                                            break;
                                        } //case 2
                                    } //switch
                                    break;
                                } //confirmation case 1
                                case 2: {

                                    System.out.println("You have cancelled your booking");


                                    break;
                                }
                            }
                        }
                            break;
                        }
                        
                        case 2:
                            {
                                u.viewRideHistory(userId);
                                //System.out.println(userId);
                                break;
                            }
                        case 3:
                            {
                                u.viewPaymentHistory(userId);
                                break;
                            }
                        case 4:
                            {
                                login = false;
                                break;
                            }

                    }
                }
            }


    }

