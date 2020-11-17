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
                            System.out.println("your current status is " + status);
                            System.out.println("If u want to change to" + !status + "press 1 otherwise 2");
                            int input1 = input.nextInt();
                            if (input1 == 1) {
                                ((Driver) u).setSstatus();
                                System.out.println("status changed to" + !status);
                            } else {
                                System.out.println("status not changed to");
                            }
                            break;
                    }

                    case 2: {
                        System.out.println("Enter your current location");
                        int latitude = input.nextInt();
                        int longitude = input.nextInt();
                        Location location = new Location(latitude, longitude);
                        u.setLocation(location);
                        System.out.println("Location updated");
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
