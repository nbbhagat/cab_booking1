package mainApp;
import entity.Location;
import entity.User;
import service.Ride;
import service.BookingMgmt;
import dataStore.MemManager;
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
                ExceptionHandling exceptionHandling=new ExceptionHandling();
                while (login) {
                    System.out.println("1. Book Cab");
                    System.out.println("2. View Ride History");
                    System.out.println("3. View Payment History");
                    System.out.println("4. Logout");
                    System.out.println("Enter an option - ");
                    int option3 = addInput.nextInt();

                    switch (option3) {
                        case 1: { //Book Cab
                            System.out.println("Enter your current Location:\nLatitude: ");
                            int sLatitude = exceptionHandling.latitudeException();
                            System.out.println("Longitude: ");
                            int sLongitude = exceptionHandling.longitudeException(sLatitude);                                                       
                            Scanner sc = new Scanner(System.in);
                            char  vehicleType = exceptionHandling.vehicleTypeException();
                            
                            System.out.println("Enter destination: \nLatitude:");
                            int dLatitude = exceptionHandling.latitudeException();
                            System.out.println("Longitude: ");
                            int dLongitude = exceptionHandling.longitudeException(dLatitude);
                            
                            System.out.println("Searching for cabs...");
                            bm.createNewBooking(userId);
                            Location source = new Location(sLatitude, sLongitude);
                            Location dest = new Location(dLatitude, dLongitude);
                            String availableDriverID = bm.findNearestCab(source, vehicleType);
                            System.out.println("Driver will be assigned with driver ID " + availableDriverID + "on confirmation.\n1. Confirm\n2. Cancel\nEnter your choice:");
                            int confirmation = addInput.nextInt();
                            switch (confirmation) { //Confirm initially
                                case 1: {
                                    System.out.println("Your cab will arrive shortly\n1.Confirm arrival of cab and start ride");
                                    System.out.println("2. Cancel ride (will incur cancellation charges)");
                                    int confirmation2 = addInput.nextInt();
                                    switch (confirmation2) {
                                        case 1: { //Confirm ride start
                                            System.out.println("Ride has started!");
                                            Ride r = bm.startRide(source, dest, availableDriverID);
                                            System.out.println("Ride is ongoing...\nPress any key to confirm arrival at destination:");
                                            String arrived = addInput.next();
                                            System.out.println("You have arrived at your destination! Please rate your ride (1-5):");
                                            int rating = addInput.nextInt();

                                            double amount = bm.calculateFare(source, dest, mManager.driverVehicle.get(availableDriverID));
                                            bm.endRide(r, rating, availableDriverID);
                                            System.out.println("Please select your mode of payment");
                                            System.out.println("1. Cash\n2. E-Wallet\nEnter your choice:");
                                            int option4 = addInput.nextInt();
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
                                            System.out.println("1. Cash\n2. E-Wallet\nEnter your choice:");
                                            int option4 = addInput.nextInt();
                                            switch (option4) {
                                                case 1: { //cash

                                                    bm.cancelRide("Cash", userId);
                                                    break;
                                                }
                                                case 2: { //e-wallet

                                                    bm.cancelRide("E-wallet", userId);


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
                            break;
                        }
                        case 2:
                            {
                                u.viewRideHistory(userId);
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

