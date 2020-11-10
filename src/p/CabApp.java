package p;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class CabApp {
	public static void main(String args[])
	{
		MemManager MManager=new MemManager();
		File uf=new File("userhashmap.ser");
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
			//cab booking options with save&exit
		}

		
	}
}
