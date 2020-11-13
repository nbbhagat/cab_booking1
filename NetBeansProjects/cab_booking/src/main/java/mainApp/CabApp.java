package mainApp;
import entity.User;
import dataStore.MemManager;
import java.util.Scanner;


public class CabApp {
    public static void main(String args[]) {
        
        MemManager MManager = MemManager.getInstance();
        Admin AObj = new Admin();
        Register register= new Register();
        LoginDriver loginDriver=new LoginDriver();
        LoginPassenger loginPassenger=new LoginPassenger();
        while (true) {
            
            System.out.println("Cab Booking Application");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Save and Exit");
            System.out.println("Enter an option - ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            if (option==1) {
                
                register.doFun( AObj);
            }
            else if(option==2){
                    Scanner addInput = new Scanner(System.in);
                    System.out.println("1. Enter UserId and password");
                    String userId=addInput.next();
                    String userPass=addInput.next();
                    System.out.println(MManager.userMap);
                    User u=MManager.userMap.get(userId);
                    
                    if(userId.charAt(0)=='P'&&u.getPassword().equals(userPass)){
                        
                        loginPassenger.doFun(u, AObj);
                    }    
                    else if(userId.charAt(0)=='D'&&u.getPassword().equals(userPass)){
                        
                        loginDriver.doFun(u, AObj);
                    }    
                    else{
                            System.out.println("password incorrect");
                    }
            }
            else if(option==3){
                    AObj.saveAndExit();
            }
        }
    }
}
       