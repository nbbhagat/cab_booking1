/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainApp;

import java.util.Scanner;

public class ExceptionHandling {
   Scanner sc = new Scanner(System.in);
    
    public String passwordException(){
        boolean flag=true;
        String pwd;
        do {
                if(flag==false)
                    System.out.println("Invalid password");
                
                System.out.println("Enter Password - (minimum 8 characters)");
                while (!sc.hasNext()) {
                    System.out.println("That's not a valid password!");
                    sc.next(); // this is important!
                }
                pwd = sc.next();
            flag=false;
            } while (pwd.length() < 8);
        return pwd;
    }
    public int statusException(){
        int answer;
        boolean flag=true;
            do {
                if(flag==false)
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
                flag=false;
            } while (answer!=1&&answer!=2);
            return answer;
    }
    public char vehicleTypeException(){
        boolean flag=true;
        char answer;
            do {
                if(flag==false)
                {
                    System.out.println("Invalid input");
                }
                System.out.println("Enter the vehicle type");
                System.out.println("A. Auto \nB. Bike \nC. Car");
                while (!sc.hasNext()) 
                {
                    System.out.println("That's not a valid input!");
                    sc.next(); // this is important!
                }
                answer = sc.next().charAt(0);
                flag=false;
            } while (answer!='A' &&answer!='B' &&answer!='C');
            return  answer;
    }
    
    
    public int latitudeException(){
        int latitude;
        boolean flag=true;
        do {
                if(flag==false)
                    System.out.println("Invalid coordinate");
                
                System.out.println("Enter the Location:\nLatitude: (1-100)");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a valid latitude!");
                    sc.next(); // this is important!
                }
                latitude = sc.nextInt();
                flag=false;
            } while (latitude>100||latitude<0);
        return latitude;
    }
    public int longitudeException(int latitude){
            int longitude;
            boolean flag=true;
            int low;
            int high;
            if(latitude<=25) {
                low = 0;
                high = 25;
            }
            else if(latitude<=50) {
                low = 25;
                high = 50;
            }
            else if(latitude<=75) {
                low = 50;
                high = 75;
            }
            else {
                low = 75;
                high = 100;
            }
            
        do {
                if(flag==false)
                    System.out.println("Invalid coordinate");
                
                System.out.println("Longitude: ("+low+" - "+high+")");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a valid location!");
                    sc.next(); // this is important!
                }
                longitude = sc.nextInt();
                flag=false;
            } while(longitude>high||longitude<low);
        return longitude;
    }
    
    public String phoneNoException(){
        boolean flag=true;
        String pno;
        do {
                if(flag==false)
                    System.out.println("Invalid phone number");
                
                System.out.println("Enter 10 digit Phone Number - ");
                while (!sc.hasNext()) {
                    System.out.println("That's not a valid number!");
                    sc.next(); // this is important!
                }
                pno = sc.next();
                flag=false;
            } while (pno.length() != 10);
        return pno;
    }   
}
