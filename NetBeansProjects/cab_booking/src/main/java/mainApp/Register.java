
package mainApp;
import entity.Bike;
import entity.Location;
import entity.Auto;
import entity.Car;
import dataStore.MemManager;
import java.util.Scanner;

public class Register {
    private MemManager mManager;
    public Register(){
        this.mManager=MemManager.getInstance();
    }
    ExceptionHandling exceptionHandling=new ExceptionHandling();
    public void doFun(Admin AObj){
        Scanner addInput = new Scanner(System.in);
        System.out.println("Register : 1. Passenger 2. Driver");
        int option1 = addInput.nextInt();
        switch (option1) {
            case 1: //Passenger Registration
                {
                    Scanner addInput1 = new Scanner(System.in);
                    System.out.println("Enter Name:");
                    String name = addInput.next();
                    Scanner sc = new Scanner(System.in);
                    
                    String pno=exceptionHandling.phoneNoException();
                    String pwd=exceptionHandling.passwordException();
                    int sLatitude=exceptionHandling.latitudeException();
                    int sLongitude=exceptionHandling.longitudeException(sLatitude);
                    
                    Location l = new Location(sLatitude,sLongitude);
                    AObj.registerPassenger( name, pno, pwd, l);
                    break;
                }
            case 2: //Driver Registration
                {
                    System.out.println("Enter Name:");
                    String name = addInput.next();
                    Scanner sc = new Scanner(System.in);
                    String pno=exceptionHandling.phoneNoException();
                    String pwd=exceptionHandling.passwordException();
                    int dLatitude=exceptionHandling.latitudeException();
                    int dLongitude=exceptionHandling.longitudeException(dLatitude);
                    
                    Location l = new Location(dLatitude, dLongitude);
                    int answer= exceptionHandling.statusException();
                    
                    
                    boolean status = false;
                    switch(answer) {
                        case 1 -> status = true;
                        case 2 -> status = false;
                    }
                    char type=exceptionHandling.vehicleTypeException();
                    switch(type){
                            case 'A' : {
                                Auto auto=new Auto();
                                auto.setId();
                                AObj.registerDriver( name, pno, pwd, l, status, auto);
                                break;
                            }

                            case 'B' :
                            {
                               Bike bike=new Bike();
                                bike.setId();
                                AObj.registerDriver( name, pno, pwd, l, status, bike);
                                break;
                            }
                            case 'C' :
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
    }
}
