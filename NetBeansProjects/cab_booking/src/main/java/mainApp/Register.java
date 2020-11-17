
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
    public void doFun(Admin AObj){
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
                        flag=false;
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
                        flag=false;
                    } while (sLatitude>100||sLatitude<0);


                    int sLongitude;
                    flag=true;
                    int low;
                    int high;
                    if(sLatitude<=25) {
                        low = 0;
                        high = 25;
                    }
                    else if(sLatitude<=50) {
                        low = 25;
                        high = 50;
                    }
                    else if(sLatitude<=75) {
                        low = 50;
                        high = 75;
                    }
                    else {
                        low = 75;
                        high = 100;
                    }
                    do {
                        if(flag==false)
                        {
                            System.out.println("Invalid coordinate");
                        }
                        System.out.println("\nLongitude: ("+low+" - "+high+")");
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid location!");
                            sc.next(); // this is important!
                        }
                        sLongitude = sc.nextInt();
                        flag=false;
                    } while (sLongitude>high||sLongitude<low);

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
                        flag=false;
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
                        flag=false;
                    } while (Latitude>100||Latitude<0);


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
                        flag=false;
                    } while (Longitude>100||Longitude<0);

                    Location l = new Location(Latitude, Longitude);
                    int answer;
                    boolean flag1=true;
                    do {
                        if(flag1==false)
                        {
                            System.out.println("Invalid input");
                        }
                        System.out.println("Enter Status:\n1. Available\n2. Unavailable");
                        while (!sc.hasNext()) 
                        {
                            System.out.println("That's not a valid input!");
                            sc.next(); // this is important!
                        }
                        answer = sc.nextInt();
                        flag1=false;
                    } while (answer!=1&&answer!=2);
                    boolean status = false;
                    switch(answer) {
                        case 1 -> status = true;
                        case 2 -> status = false;
                    }
                    flag1=true;
                    do {
                        if(flag1==false)
                        {
                            System.out.println("Invalid input");
                        }
                        System.out.println("Enter the vehicle type");
                        System.out.println("1. Auto \n 2.Bike \n 3. Car");
                        while (!sc.hasNext()) 
                        {
                            System.out.println("That's not a valid input!");
                            sc.next(); // this is important!
                        }
                        answer = sc.nextInt();
                        flag1=false;
                    } while (answer!=1&&answer!=2&&answer!=3);
                    switch(answer){
                            case 1 : {
                                Auto auto=new Auto();
                                auto.setId();
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
    }
}
