package mainApp;
import entity.User;
import entity.Driver;
import entity.Location;
import dataStore.MemManager;
import java.util.Scanner;

public class LoginDriver {
    private MemManager mManager;
    public LoginDriver(){
        this.mManager=MemManager.getInstance();
    }
    public void doFun(User u, Admin AObj){
        boolean login = true;
        while (login) {    
            String userId=u.getUserId();
            InputValidation exceptionHandling=new InputValidation();
            Scanner input = new Scanner(System.in);
            System.out.println("1. Set status");
            System.out.println("2. Update current location");
            System.out.println("3. Show ride history");
            System.out.println("4. Logout");
            System.out.println("Enter an option:");
            Scanner input2 = new Scanner(System.in);
            int option_1 = input2.nextInt();
            switch (option_1) {
                    case 1: {
                            boolean status = ((Driver) u).isStatus();
                            String statusString = (status==true)?"Available":"Unavailable";
                            String statusOppString = (status==true)?"Unavailable":"Available";
                            System.out.println("Your current status is " + statusString);
                            System.out.println("If u want to change to " + statusOppString + ", press 1. Press 2 otherwise:");
                            int input1 = input.nextInt();
                            if (input1 == 1) {
                                ((Driver) u).setSstatus();
                                mManager.userMap.put(u.getUserId(),u);
                                System.out.println("Status changed to" + statusOppString);
                            } else {
                                System.out.println("Status remains as " + statusString);
                            }
                            
                            break;
                            
                    }

                    case 2: {
                        System.out.println("Enter your current location");
                        int latitude = exceptionHandling.latitudeValidation();
                        int longitude = exceptionHandling.longitudeValidation(latitude);
                        Location location = new Location(latitude, longitude);
                        u.setLocation(location);
                        System.out.println("Location updated");
                        mManager.userMap.put(u.getUserId(),u);
                        break;

                    }
                    case 3: {
                        u.viewRideHistory(userId);
                        break;
                    }
                    case 4:{
                        login=false;
                        break;
                    }

            }
        }
   
    }
}
