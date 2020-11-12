package mainApp;
import entity.Location;
import dataStore.MemManager;
import dataStore.DBManager;
import entity.Vehicle;
import entity.Passenger;
import entity.Driver;
import entity.User;
import java.util.concurrent.ConcurrentHashMap;

public class Admin {
    private MemManager mManager;
        public Admin(){
            this.mManager=MemManager.getInstance();
        }
	public void registerPassenger(String name,String pno, String pwd,Location location)
	{
		User p=new Passenger(name, pno, pwd,location);
        mManager.userMap.put(p.userId,p);
        System.out.println("Added details of Passenger "+p.userId);
		
	}
	
	public void registerDriver( String name, String pno, String pwd,Location location, boolean status,Vehicle vehicle)
	{
		User d=new Driver(name, pno, pwd, location, status,vehicle);
        mManager.userMap.put(d.userId,d);
        System.out.println("Added details of Driver "+d.userId);
		mManager.driverVehicle.put(d.userId,vehicle);
		System.out.println("Vehicle "+vehicle.vId+" mapped to Driver "+d.userId);
		System.out.println(mManager.driverVehicle.get(d.userId));
		
	}
	
	public void deletePassenger( String userId)
	{
		User p=mManager.userMap.get(userId);
		if(p!=null)
		{
			mManager.userMap.remove(userId);
			System.out.println("Deleted details of user "+userId);
		}
		else
		{
			System.out.println("No record found");
		}

	}
	
	public void deleteDriver( String userId)
	{
		User d=mManager.userMap.get(userId);
		if(d!=null)
		{
			mManager.userMap.remove(userId);
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
	
	public void viewUserRecord(String userId)
	{
		User u=mManager.userMap.get(userId);
		if(u!=null)
		{
			System.out.println(u);
		}
		else
		{
			System.out.println("No record found");
		}
		
	}
	public void saveAndExit()
	{
		DBManager Dbm = new DBManager();
		Dbm.serializeUserMap(mManager.userMap);
		Dbm.serializeDVMap(mManager.driverVehicle);
		Dbm.serializePayMap(mManager.payMap);
		Dbm.serializeRideMap(mManager.rideMap);
		Dbm.serializeUBMap(mManager.userBooking);
		System.out.println("Serializing map before exiting");
		System.exit(0);
	}
}
