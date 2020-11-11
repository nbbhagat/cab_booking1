/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author namrata
 */
import java.util.HashMap;
import java.util.Scanner;


public class CabApp_n {
	public static void main(String args[])
	{
		MemManager MManager=new MemManager();
		File uf=new File("userhashmap.ser");
		File ubf= new File("ubhashmap.ser");
		File dvf= new File("dvhashmap.ser");
		File pf=new File("payhashmap.ser");
		File rf=new File("ridehashmap.ser");
		if(uf.exists())
		{
			System.out.println("Deserialising existing user map");
			DBManager DBm = new DBManager();
			MManager.userMap=DBm.deserializeUserMap();
			
		}
		else
		{   		
			System.out.println("Creating user map for the first time");
			MManager.userMapInit();
			System.out.println(MManager.userMap);
		}
		if(ubf.exists())
		{
			System.out.println("Deserialising existing user booking map");
			DBManager DBm = new DBManager();
			MManager.userBooking=DBm.deserializeUBMap();
			
		}
		else
		{   		
			System.out.println("Creating user map for the first time");
			MManager.userMapInit();
			System.out.println(MManager.userBooking);
		}
		if(dvf.exists())
		{
			System.out.println("Deserialising existing dv map");
			DBManager DBm = new DBManager();
			MManager.driverVehicle=DBm.deserializeDVMap();
			
		}
		else
		{   		
			System.out.println("Creating dv map for the first time");
			MManager.dvMapInit();
			System.out.println(MManager.driverVehicle);
		}
		if(pf.exists())
		{
			System.out.println("Deserialising existing pay map");
			DBManager DBm = new DBManager();
			MManager.payMap=DBm.deserializePayMap();
			
		}
		else
		{   		
			System.out.println("Creating pay map for the first time");
			MManager.payMapInit();
			System.out.println(MManager.payMap);
		}
		if(rf.exists())
		{
			System.out.println("Deserialising existing ride map");
			DBManager DBm = new DBManager();
			MManager.rideMap=DBm.deserializeRideMap();
			
		}
		else
		{   		
			System.out.println("Creating ride map for the first time");
			MManager.rideMapInit();
			System.out.println(MManager.rideMap);
		}
                
                while(true)
		{
			//for driver
			//if driver
			System.out.println("Enter the number according your option");
			System.out.println("1. Set status");
                        System.out.println("2. Update current location");
                        System.out.println("3. Show ride history");
                        String userId="";
			Scanner input=new Scanner(System.in);
			int option=input.nextInt();
                        MemManager mmap;
                        User d= MManager.userMap.get(userId);
                        switch(option)
			{
			case 1:
			{
                                
                                boolean status=((Driver)d).isStatus();                             
                                System.out.println("your current status is "+status);
                                System.out.println("If u want to change to"+ !status+"press 1 otherwise 2");
                                int input1=input.nextInt();
                                if(input1==1) {
                                    ((Driver)d).setStatus();
                                    System.out.println("status changed to"+!status);
                                }
                                else{
                                    System.out.println("status not changed to");
                                }
				break;
			}

			case 2:
			{
				System.out.println("enter your current location");
                                int latitude=input.nextInt();
                                int longitude=input.nextInt();
                                Location location=new Location(latitude,longitude);
                                d.setLocation(location);
                                System.out.println("Location updated");
                                
			}
			case 3:
			{
				d.viewRideHistory(MManager, userId);
			}
                    }
                }
		/*while(true)
		{
			//cab booking options with save&exit
			Admin AObj=new Admin();
			System.out.println("Cab Booking Application");
			System.out.println("1. Register as a Passenger");
                        System.out.println("2. Register as a Driver");
                        System.out.println("3. Delete Passengerr");
                        System.out.println("4. Delete Driver");
			System.out.println("5. Assign driver a vehicle");
			System.out.println("6. View user record ");
                        System.out.println("7. Save and Exit");
			Scanner input=new Scanner(System.in);
			int option=input.nextInt();
			
			switch(option)
			{
			case 1:
			{
				Scanner addInput=new Scanner(System.in);
				System.out.println("Enter name - ");
				String userId=addInput.next();
                                System.out.println("Enter Phone Number -");
                                String phoneNo=addInput.next();
                                
                                
				System.out.println("Enter Name - ");
				String name=addInput.next();
				System.out.println("Enter Mark1 - ");
				int m1=addInput.nextInt();
				System.out.println("Enter Mark2 - ");
				int m2=addInput.nextInt();
				//AObj.addStudent(MManager,rn,name,m1,m2);
				break;
			}
			case 2:
			{
				Scanner addInput=new Scanner(System.in);
				System.out.println("Enter RollNo - ");
				int rn=addInput.nextInt();
				AObj.delStudent(MManager,rn);	
				break;
			}
			case 3:
			{
				Scanner addInput=new Scanner(System.in);
				System.out.println("Enter RollNo - ");
				int rn=addInput.nextInt();
				System.out.println("Enter New Name - ");
				String newname=addInput.next();
				AObj.editName(MManager,rn,newname);	
				break;
			}
			case 4:
			{   Scanner addInput=new Scanner(System.in);
				System.out.println("Enter view option: 1. All 2. By Roll No 3. Passed 4. Failed");
				int option1=addInput.nextInt();
				switch(option1)
				{
				case 1:
				{
					for(Student s:MManager.stuMap.values())
					{
						s.display();
					}
					break;
				}
				case 2:
				{
					
					System.out.println("Enter RollNo - ");
					Scanner addInput1=new Scanner(System.in);
					int rn=addInput1.nextInt();
					AObj.viewRecord(MManager,rn);
					break;
				}
				case 3:
				{
					for(Student s:MManager.stuMap.values())
					{
						if(s.sub1+s.sub2>50)
						{
							s.display();
						}
					}
					break;
				}
				case 4:
				{
					for(Student s:MManager.stuMap.values())
					{
						if(s.sub1+s.sub2<=50)
						{
							s.display();
						}
					}
					break;
				}
				}
				break;

			}
			case 5:
			{
				AObj.saveAndExit(MManager);	
				break;
			}
			
			
			}
		}*/

		
	}
}
        
}
