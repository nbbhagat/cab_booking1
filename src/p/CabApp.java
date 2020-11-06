package p;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class CabApp {
	public static void main(String args[])
	{
		MemManager MManager=new MemManager();
		File f=new File("hashmap.ser");
		if(f.exists())
		{
			System.out.println("Deserialising existing map");
			DBManager DBm = new DBManager();
			MManager.stuMap=DBm.DeserializeMap();
			
		}
		else
		{   		
			System.out.println("Creating map for the first time");
			MManager.mapInit();
			System.out.println(MManager.stuMap);
		}
		while(true)
		{
			Admin AObj=new Admin();
			System.out.println("School Management System");
			System.out.println("1. Add student details");
			System.out.println("2. Delete student record");
			System.out.println("3. Update student name");
			System.out.println("4. View student record");
			System.out.println("5. Save and Exit");
			System.out.println("Enter an option - ");
			Scanner input=new Scanner(System.in);
			int option=input.nextInt();
			
			switch(option)
			{
			case 1:
			{
				Scanner addInput=new Scanner(System.in);
				System.out.println("Enter RollNo - ");
				int rn=addInput.nextInt();
				System.out.println("Enter Name - ");
				String name=addInput.next();
				System.out.println("Enter Mark1 - ");
				int m1=addInput.nextInt();
				System.out.println("Enter Mark2 - ");
				int m2=addInput.nextInt();
				AObj.addStudent(MManager,rn,name,m1,m2);
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
		}

		
	}
}
