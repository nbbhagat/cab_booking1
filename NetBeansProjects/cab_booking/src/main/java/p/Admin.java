package p;

import java.util.concurrent.ConcurrentHashMap;

public class Admin {
	public void registerPassenger(MemManager mmap,String name,String pno, String pwd,Location location,String region)
	{
		User p=new Passenger(name, pno, pwd,location,region);
        mmap.userMap.put(p.userId,p);
        System.out.println("Added details of Passenger "+p.userId);
		
	}
	
	public void registerDriver(MemManager mmap, String name, String pno, String pwd,Location location, boolean status,Vehicle vehicle,String region)
	{
		User d=new Driver(name, pno, pwd, location, status,vehicle,region);
        mmap.userMap.put(d.userId,d);
        System.out.println("Added details of Driver "+d.userId);
		mmap.driverVehicle.put(d.userId,vehicle);
		System.out.println("Vehicle "+vehicle.vId+" mapped to Driver "+d.userId);
		
	}
	
	public void deletePassenger(MemManager mmap, String userId)
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
	
	public void deleteDriver(MemManager mmap, String userId)
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
	
//	public void driverVehicle(MemManager mmap, String userId, Vehicle vehicle)
//	{
//
//	}
	
	public void viewUserRecord(MemManager mmap,String userId)
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
