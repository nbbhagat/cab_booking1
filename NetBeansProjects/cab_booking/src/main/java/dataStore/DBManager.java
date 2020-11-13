package dataStore;

import services1.Payment;
import services1.Ride;
import entity1.Vehicle;
import entity1.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


public class DBManager{
	public  void serializeUserMap(ConcurrentHashMap<String, User> userMap)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("userhashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(userMap);
               oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in userhashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
	public  void serializeUBMap(ConcurrentHashMap<String, ArrayList<String>> userBooking)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("ubhashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(userBooking);
               oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in ubhashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
	public  void serializeDVMap(ConcurrentHashMap<String, Vehicle> driverVehicle)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("dvhashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(driverVehicle);
               System.out.println("Testing in DBManager");
	       		Iterator<ConcurrentHashMap.Entry<String, Vehicle> > itr1 = driverVehicle.entrySet().iterator(); 
	       		while(itr1.hasNext()) {
	       			ConcurrentHashMap.Entry<String, Vehicle> entry1 = itr1.next(); 
	       			System.out.println(entry1.getValue());			
	       		}               
	       		oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in dvhashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
	public  void serializePayMap(ConcurrentHashMap<String, Payment> payMap)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("payhashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(payMap);
               oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in payhashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
	public  void serializeRideMap(ConcurrentHashMap<String, Ride> rideMap)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("ridehashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(rideMap);
               oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in ridehashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
	public  ConcurrentHashMap<String, User> deserializeUserMap()
	{
		ConcurrentHashMap<String, User> umap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("userhashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         umap = (ConcurrentHashMap) ois.readObject();
		         System.out.println("Deserialized HashMap data" + umap);
		         ois.close();
		         fis.close();
		      }catch(IOException ioe)
		      {
		         ioe.printStackTrace();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Class not found");
		         c.printStackTrace();
		      }
		      return umap;
			}
	public  ConcurrentHashMap<String, ArrayList<String>> deserializeUBMap()
	{
		ConcurrentHashMap<String, ArrayList<String>> ubmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("ubhashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         ubmap = (ConcurrentHashMap) ois.readObject();
		         System.out.println("Deserialized HashMap data" + ubmap);
		         ois.close();
		         fis.close();
		      }catch(IOException ioe)
		      {
		         ioe.printStackTrace();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Class not found");
		         c.printStackTrace();
		      }
		      return ubmap;
			}
	public  ConcurrentHashMap<String, Ride> deserializeRideMap()
	{
		ConcurrentHashMap<String, Ride> rmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("ridehashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         rmap = (ConcurrentHashMap) ois.readObject();
		         System.out.println("Deserialized HashMap data" + rmap);
		         ois.close();
		         fis.close();
		      }catch(IOException ioe)
		      {
		         ioe.printStackTrace();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Class not found");
		         c.printStackTrace();
		      }
		      return rmap;
		}

	public  ConcurrentHashMap<String, Payment> deserializePayMap()
	{
		ConcurrentHashMap<String, Payment> pmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("ridehashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         pmap = (ConcurrentHashMap) ois.readObject();
		         System.out.println("Deserialized HashMap data" + pmap);
		         ois.close();
		         fis.close();
		      }catch(IOException ioe)
		      {
		         ioe.printStackTrace();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Class not found");
		         c.printStackTrace();
		      }
		      return pmap;
		}
	public  ConcurrentHashMap<String, Vehicle> deserializeDVMap()
	{
		ConcurrentHashMap<String, Vehicle> dvmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("dvhashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         dvmap = (ConcurrentHashMap) ois.readObject();
		         System.out.println("Deserialized HashMap data" + dvmap);
		         ois.close();
		         fis.close();
		      }catch(IOException ioe)
		      {
		         ioe.printStackTrace();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Class not found");
		         c.printStackTrace();
		      }
		      return dvmap;
		}
		
	}


