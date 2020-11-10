package p;

import java.util.concurrent.ConcurrentHashMap;

public class Admin {
	public void addPassenger(MemManager mmap,String userId,String name,int pno, int numRides,String pwd,Location location, Address addr)
	{
		User p=new Passenger(userId, name, pno, numRides, pwd, location, addr);
        mmap.userMap.put(p.userId,p);
        System.out.println("Added details of Passenger "+p.userId);
		
	}
	
	public void addDriver(MemManager mmap, String userId, String name, int pno,int numRides,String pwd,Location location, boolean status)
	{
		User d=new Driver(userId, name, pno, numRides, pwd, location, status);
        mmap.userMap.put(d.userId,d);
        System.out.println("Added details of Driver "+d.userId);
		
	}
	
	public void delPassenger(MemManager mmap, String userId)
	{
		User p=mmap.userMap.get(userId);
		if(p!=null)
		{
			mmap.userMap.remove(userId);
			System.out.println("Deleted details of user "+userId);
		}
		else
		{
			System.out.println("No record found");
		}

	}
	
	public void delDriver(MemManager mmap, String userId)
	{
		User d=mmap.userMap.get(userId);
		if(d!=null)
		{
			mmap.userMap.remove(userId);
			System.out.println("Deleted details of user "+userId);
		}
		else
		{
			System.out.println("No record found");
		}

	}
	
	public void driverVehicle(MemManager mmap, String userId, String vehicleId)
	{
		Vehicle v=new Vehicle();
		mmap.driverVehicle.put(userId,v);
		System.out.println("Vehicle "+vehicleId+" mapped to Driver "+userId);
	}
	
	public void viewRecord(MemManager mmap,String userId)
	{
		User u=mmap.userMap.get(userId);
		if(u!=null)
		{
			System.out.println(u);
		}
		else
		{
			System.out.println("No record found");
		}
		
	}
	public void saveAndExit(MemManager mmap)
	{
		DBManager Dbm = new DBManager();
		Dbm.serializeUserMap(mmap.userMap);
		Dbm.serializeDVMap(mmap.driverVehicle);
		Dbm.serializePayMap(mmap.payMap);
		Dbm.serializeRideMap(mmap.rideMap);
		
		System.out.println("Serializing map before exiting");
		System.exit(0);
	}
}
