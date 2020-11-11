package p;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class CabApp {
    public static void main(String args[]) {
        MemManager MManager = new MemManager();
        File uf = new File("userhashmap.ser");
        File ubf = new File("ubhashmap.ser");
        File dvf = new File("dvhashmap.ser");
        File pf = new File("payhashmap.ser");
        File rf = new File("ridehashmap.ser");
        if (uf.exists()) {
            System.out.println("Deserialising existing user map");
            DBManager DBm = new DBManager();
            MManager.userMap = DBm.deserializeUserMap();

        } else {
            System.out.println("Creating user map for the first time");
            MManager.userMapInit();
            System.out.println(MManager.userMap);
        }
        if (ubf.exists()) {
            System.out.println("Deserialising existing user booking map");
            DBManager DBm = new DBManager();
            MManager.userBooking = DBm.deserializeUBMap();

        } else {
            System.out.println("Creating user map for the first time");
            MManager.userMapInit();
            System.out.println(MManager.userBooking);
        }
        if (dvf.exists()) {
            System.out.println("Deserialising existing dv map");
            DBManager DBm = new DBManager();
            MManager.driverVehicle = DBm.deserializeDVMap();

        } else {
            System.out.println("Creating dv map for the first time");
            MManager.dvMapInit();
            System.out.println(MManager.driverVehicle);
        }
        if (pf.exists()) {
            System.out.println("Deserialising existing pay map");
            DBManager DBm = new DBManager();
            MManager.payMap = DBm.deserializePayMap();

        } else {
            System.out.println("Creating pay map for the first time");
            MManager.payMapInit();
            System.out.println(MManager.payMap);
        }
        if (rf.exists()) {
            System.out.println("Deserialising existing ride map");
            DBManager DBm = new DBManager();
            MManager.rideMap = DBm.deserializeRideMap();

        } else {
            System.out.println("Creating ride map for the first time");
            MManager.rideMapInit();
            System.out.println(MManager.rideMap);
        }
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
                                    System.out.println("Enter Phone Number - ");
                                    String pno = addInput.next();
                                    System.out.println("Enter Password - ");
                                    String pwd = addInput.next();
                                    System.out.println("Enter Location - ");
                                    Location l = new Location();
                                    AObj.registerPassenger(MManager, name, pno, pwd, l);
                                    break;
                                }
                            case 2: //Driver Registration
                                {

                                    Scanner addInput1 = new Scanner(System.in);
                                    System.out.println("Enter Name - ");
                                    String name = addInput.next();
                                    System.out.println("Enter Phone Number - ");
                                    String pno = addInput.next();
                                    System.out.println("Enter Password - ");
                                    String pwd = addInput.next();
                                    System.out.println("Enter Location - ");
                                    Location l = new Location();
                                    System.out.println("Enter Status - ");
                                    Boolean status = addInput.nextBoolean();
                                    //add vehicle details
                                    //create vehicle object
                                    Vehicle vehicle = new Vehicle();
                                    AObj.registerDriver(MManager, name, pno, pwd, l, status, vehicle);
                                    break;
                                }
                        }
                        break;

                    }
                case 2: //Login
                    {
                        Scanner addInput = new Scanner(System.in);
                        System.out.println("1. Passenger Login");
                        System.out.println("2. Driver Login");
                        System.out.println("Enter an option - ");
                        int option2 = addInput.nextInt();
                        switch (option2) {
                            case 1:
                                { //Passenger Login
                                    //Passenger login code
                                    System.out.println("1. Book Cab");
                                    System.out.println("2. View Ride History");
                                    System.out.println("3. View Payment History");
                                    System.out.println("Enter an option - ");
                                    int option3 = addInput.nextInt();
                                    switch (option3) {
                                        case 1:
                                            { //Book Cab
                                                System.out.println("Enter your region:");
                                                String region = addInput.next();
                                                System.out.println("Enter your current Location:\nLatitude: ");
                                                int sLatitude = addInput.nextInt();
                                                System.out.println("Longitude: ");
                                                int sLongitude = addInput.nextInt();
                                                System.out.println("Select preferred vehicle type:\n1. ");
                                                String vehicleType = addInput.next(); //must change
                                                System.out.println("Enter destination \nLatitude");
                                                int dLatitude = addInput.nextInt();
                                                System.out.println("Longitude: ");
                                                int dLongitude = addInput.nextInt();
                                                System.out.println("Searching for cabs...");
                                                BookingMgmt bm = new BookingMgmt(passengerID, MManager);
                                                Location source = new Location(sLatitude, sLongitude);
                                                Location dest = new Location(dLatitude, dLongitude);
                                                String availableDriverID = bm.findNearestCab(source, region, vehicleType, MManager);
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
                                                                        Ride r = bm.startRide(source, dest, MManager, availableDriverID);
                                                                        System.out.println("Ride is ongoing...\nPress any key to confirm arrival at destination:");
                                                                        String arrived = addInput.next();
                                                                        System.out.println("You have arrived at your destination! Please rate your ride (1-5):");
                                                                        int rating = addInput.nextInt();
                                                                        Vehicle v = new Vehicle(); //change
                                                                        double amount = bm.calculateFare(source, dest, v);
                                                                        bm.endRide(r, rating, MManager, availableDriverID);
                                                                        System.out.println("Please select your mode of payment");
                                                                        System.out.println("1. Cash\n2. E-Wallet\nEnter your choice:");
                                                                        int option4 = addInput.nextInt();
                                                                        switch (option4) {
                                                                            case 1:
                                                                                { //Cash
                                                                                    bm.makePayment("cash", amount, MManager, passengerID);
                                                                                    break;
                                                                                }
                                                                            case 2:
                                                                                { //E-Wallet
                                                                                    bm.makePayment("ewallet", amount, MManager, passengerID);
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
                                                                                    bm.cancelRide("cash", MManager, passengerID);
                                                                                    break;
                                                                                }
                                                                            case 2:
                                                                                { //e-wallet
                                                                                    bm.cancelRide("ewallet", MManager, passengerID);
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
                                                            break;
                                                        }
                                                }
                                                break;
                                            }
                                        case 2:
                                            {
                                                break;
                                            }
                                        case 3:
                                            {
                                                break;
                                            }
                                    }
                                    break;
                                }
                            case 2:
                                {
                                    System.out.println("Enter the number according your option");
                                    System.out.println("1. Set status");
                                    System.out.println("2. Update current location");
                                    System.out.println("3. Show ride history");
                                    String userId = "";
                                    Scanner input2 = new Scanner(System.in);
                                    int option_1 = input2.nextInt();
                                    MemManager mmap;
                                    User d = MManager.userMap.get(userId);
                                    switch (option_1) {
                                        case 1:
                                            {

                                                boolean status = ((Driver) d).isStatus();
                                                System.out.println("your current status is " + status);
                                                System.out.println("If u want to change to" + !status + "press 1 otherwise 2");
                                                int input1 = input.nextInt();
                                                if (input1 == 1) {
                                                    ((Driver) d).setStatus();
                                                    System.out.println("status changed to" + !status);
                                                } else {
                                                    System.out.println("status not changed to");
                                                }
                                                break;
                                            }

                                        case 2:
                                            {
                                                System.out.println("enter your current location");
                                                int latitude = input.nextInt();
                                                int longitude = input.nextInt();
                                                Location location = new Location(latitude, longitude);
                                                d.setLocation(location);
                                                System.out.println("Location updated");
                                                break;

                                            }
                                        case 3:
                                            {
                                                d.viewRideHistory(MManager, userId);
                                                break;
                                            }
                                    }
                                }
                                break;
                        }
                    }
                    break;
            case 3:
                {
                    AObj.saveAndExit(MManager);
                    break;
                }


        }
    }


}
}