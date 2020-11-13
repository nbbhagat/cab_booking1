package mainApp;
import mainApp.Admin;
import entity.Location;
import dataStore.MemManager;
import services.BookingMgmt;
import services.Ride;
import entity.Car;
import entity.Bike;
import entity.Auto;
import entity.Driver;
import entity.User;
import java.util.Scanner;


public class CabApp {
    public static void main(String args[]) {
        MemManager MManager = MemManager.getInstance();
        
        while (true) {
            //cab booking options with save&exit
            Admin AObj = new Admin();
            System.out.println("Cab Booking Application");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Save and Exit");
            System.out.println("Enter an option - ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            switch (option) {
                case 1: //Register
                    {
                        Scanner addInput = new Scanner(System.in);
                        System.out.println("Register : 1. Passenger 2. Driver");
                        int option1 = addInput.nextInt();
                        switch (option1) {
                            case 1: //Passenger Registration
                                {
                                    Scanner addInput1 = new Scanner(System.in);
                                    System.out.println("Enter Name - ");
                                    String name = addInput.next();
                                    Scanner sc = new Scanner(System.in);
                                    String pno;
                                    boolean flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid phone number");
                                        }
                                        System.out.println("Enter 10 digit Phone Number - ");
                                        while (!sc.hasNext()) {
                                            System.out.println("That's not a valid number!");
                                            sc.next(); // this is important!
                                        }
                                        pno = sc.next();
                                        flag=false;
                                    } while (pno.length() != 10);

                                    String pwd;
                                    flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid password");
                                        }
                                        System.out.println("Enter Password - (minimum 8 characters)");
                                        while (!sc.hasNext()) {
                                            System.out.println("That's not a valid password!");
                                            sc.next(); // this is important!
                                        }
                                        pwd = sc.next();
                                    } while (pwd.length() < 8);

                                    int sLatitude;
                                    flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid coordinate");
                                        }
                                        System.out.println("Enter your current Location:\nLatitude: (1-100)");
                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a valid location!");
                                            sc.next(); // this is important!
                                        }
                                        sLatitude = sc.nextInt();
                                    } while (sLatitude<=100&&sLatitude>=0);


                                    int sLongitude;
                                    flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid coordinate");
                                        }
                                        System.out.println("\nLongitude: (1-100)");
                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a valid location!");
                                            sc.next(); // this is important!
                                        }
                                        sLongitude = sc.nextInt();
                                    } while (sLongitude<=100&&sLongitude>=0);

                                    Location l = new Location(sLatitude,sLongitude);
                                    AObj.registerPassenger( name, pno, pwd, l);
                                    break;
                                }
                            case 2: //Driver Registration
                                {
//                                    Scanner addInput1 = new Scanner(System.in);
                                    System.out.println("Enter Name - ");
                                    String name = addInput.next();
                                    Scanner sc = new Scanner(System.in);
                                    String pno;
                                    boolean flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid phone number");
                                        }
                                        System.out.println("Enter 10 digit Phone Number - ");
                                        while (!sc.hasNext()) {
                                            System.out.println("That's not a valid number!");
                                            sc.next(); // this is important!
                                        }
                                        pno = sc.next();
                                        flag=false;
                                    } while (pno.length() != 10);

                                    String pwd;
                                    flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid password");
                                        }
                                        System.out.println("Enter Password - (minimum 8 characters)");
                                        while (!sc.hasNext()) {
                                            System.out.println("That's not a valid password!");
                                            sc.next(); // this is important!
                                        }
                                        pwd = sc.next();
                                    } while (pwd.length() < 8);

                                    int Latitude;
                                    flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid coordinate");
                                        }
                                        System.out.println("Enter your current Location:\nLatitude: (1-100)");
                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a valid location!");
                                            sc.next(); // this is important!
                                        }
                                        Latitude = sc.nextInt();
                                    } while (Latitude<=100&&Latitude>=0);


                                    int Longitude;
                                    flag=true;
                                    do {
                                        if(flag==false)
                                        {
                                            System.out.println("Invalid coordinate");
                                        }
                                        System.out.println("\nLongitude: (1-100)");
                                        while (!sc.hasNextInt()) {
                                            System.out.println("That's not a valid location!");
                                            sc.next(); // this is important!
                                        }
                                        Longitude = sc.nextInt();
                                    } while (Longitude<=100&&Longitude>=0);

                                    Location l = new Location(Latitude, Longitude);
                                    System.out.println("Enter Status - ");
                                    Boolean status = addInput.nextBoolean();
                                    System.out.println("Enter the vehicle type");
                                    System.out.println("1. Auto \n 2.Bike \n 3. Car");
                                    int type=addInput.nextInt();
                                    switch(type){
                                            case 1 : {
                                                Auto auto=new Auto();
                                                auto.setId();
//                                                System.out.println(auto.vId);
                                                AObj.registerDriver( name, pno, pwd, l, status, auto);
                                                break;
                                            }

                                            case 2 :
                                            {
                                               Bike bike=new Bike();
                                                bike.setId();
                                                AObj.registerDriver( name, pno, pwd, l, status, bike);
                                                break;
                                            }
                                            case 3 :
                                            {
                                                Car car=new Car();
                                                car.setId() ;
                                                AObj.registerDriver( name, pno, pwd, l, status, car);
                                                break;
                                            }

                                        }
                                    break;
                                }
                        }
                        break;

                    }
                case 2: //Login
                    {

                        Scanner addInput = new Scanner(System.in);
                        System.out.println("1. Enter UserId and password");
                        String userId=addInput.next();
                        String userPass=addInput.next();
                        System.out.println(MManager.userMap);
                        User u=MManager.userMap.get(userId);
                        if(userId.charAt(0)=='P'&&u.password.equals(userPass)){
                             System.out.println("1. Book Cab");
                                System.out.println("2. View Ride History");
                                System.out.println("3. View Payment History");
                                System.out.println("Enter an option - ");
                                int option3 = addInput.nextInt();
                                switch (option3) {
                                    case 1:
                                        { //Book Cab
                                            System.out.println("Enter your current Location:\nLatitude: ");
                                            int sLatitude = addInput.nextInt();
                                            System.out.println("Longitude: ");
                                            int sLongitude = addInput.nextInt();
                                            System.out.println("Select preferred vehicle type:\n A. Auto \n B. Bike \n C. Car. ");
                                            char vehicleType = addInput.next().charAt(0); //must change
                                            System.out.println("Enter destination \nLatitude");
                                            int dLatitude = addInput.nextInt();
                                            System.out.println("Longitude: ");
                                            int dLongitude = addInput.nextInt();
                                            System.out.println("Searching for cabs...");
                                            BookingMgmt bm = new BookingMgmt(userId);
                                            Location source = new Location(sLatitude, sLongitude);
                                            Location dest = new Location(dLatitude, dLongitude);
                                            String availableDriverID = bm.findNearestCab(source, vehicleType);
                                            System.out.println("Driver will be assigned with driver ID " + availableDriverID + "on confirmation.\n1. Confirm\n2. Cancel\nEnter your choice:");
                                            int confirmation = addInput.nextInt();
                                            switch (confirmation) { //Confirm initially
                                                case 1:
                                                    {
                                                        System.out.println("Your cab will arrive shortly\n1.Confirm arrival of cab and start ride");
                                                        System.out.println("2. Cancel ride (will incur cancellation charges)");
                                                        int confirmation2 = addInput.nextInt();
                                                        switch (confirmation2) {
                                                            case 1:
                                                                { //Confirm ride start
                                                                    System.out.println("Ride has started!");
                                                                    Ride r = bm.startRide(source, dest,  availableDriverID);
                                                                    System.out.println("Ride is ongoing...\nPress any key to confirm arrival at destination:");
                                                                    String arrived = addInput.next();
                                                                    System.out.println("You have arrived at your destination! Please rate your ride (1-5):");
                                                                    int rating = addInput.nextInt();


                                                                    double amount = bm.calculateFare(source, dest,MManager.driverVehicle.get(availableDriverID) );
                                                                    bm.endRide(r, rating,  availableDriverID);
                                                                    System.out.println("Please select your mode of payment");
                                                                    System.out.println("1. Cash\n2. E-Wallet\nEnter your choice:");
                                                                    int option4 = addInput.nextInt();
                                                                    switch (option4) {
                                                                        case 1:
                                                                            { //Cash
                                                                                bm.makePayment("cash", amount,  userId);
                                                                                break;
                                                                            }
                                                                        case 2:
                                                                            { //E-Wallet
                                                                                bm.makePayment("e-wallet", amount, userId);
                                                                                break;
                                                                            }
                                                                    }
                                                                    break;
                                                                }
                                                            case 2:
                                                                { //Cancel ride
                                                                    System.out.println("Your cancellation charges are: " + bm.cancelAmount);
                                                                    System.out.println("Please select your mode of payment");
                                                                    System.out.println("1. Cash\n2. E-Wallet\nEnter your choice:");
                                                                    int option4 = addInput.nextInt();
                                                                    switch (option4) {
                                                                        case 1:
                                                                            { //cash

                                                                                bm.cancelRide("Cash",  userId);
                                                                                break;
                                                                            }
                                                                        case 2:
                                                                            { //e-wallet

                                                                                bm.cancelRide("E-wallet",  userId);


                                                                                break;
                                                                            }
                                                                    }
                                                                    break;
                                                                } //case 2
                                                        } //switch
                                                        break;
                                                    } //confirmation case 1
                                                case 2:
                                                    {

                                                        System.out.println("You have cancelled your booking");


                                                        break;
                                                    }
                                            }
                                            break;
                                        }
                                    case 2:
                                        {
                                            u.viewRideHistory( userId);
                                            break;
                                        }
                                    case 3:
                                        {
                                            u.viewPaymentHistory( userId);
                                            break;
                                        }
                                }
                                break;
                            }

                        else if(userId.charAt(0)=='D'&&u.password.equals(userPass)){
                                    System.out.println("Enter the number according your option");
                                    System.out.println("1. Set status");
                                    System.out.println("2. Update current location");
                                    System.out.println("3. Show ride history");

                                    Scanner input2 = new Scanner(System.in);
                                    int option_1 = input2.nextInt();

                                    //User d = MManager.userMap.get(userId);
                                    switch (option_1) {
                                        case 1:
                                            {

                                                boolean status = ((Driver) u).isStatus();
                                                System.out.println("your current status is " + status);
                                                System.out.println("If u want to change to" + !status + "press 1 otherwise 2");
                                                int input1 = input.nextInt();
                                                if (input1 == 1) {
                                                    ((Driver) u).setStatus();
                                                    System.out.println("status changed to" + !status);
                                                } else {
                                                    System.out.println("status not changed to");
                                                }
                                                break;
                                            }

                                        case 2:
                                            {
                                                System.out.println("Enter your current location");
                                                int latitude = input.nextInt();
                                                int longitude = input.nextInt();
                                                Location location = new Location(latitude, longitude);
                                                u.setLocation(location);
                                                System.out.println("Location updated");
                                                break;

                                            }
                                        case 3:
                                            {
                                                u.viewRideHistory( userId);
                                                break;
                                            }
                                    }
                        }
                                    else{
                                            System.out.println("password incorrect");
                                            }
                        break;
                        }


            case 3:
                {
                    AObj.saveAndExit();
                    break;
                }


        }
    }


}
}