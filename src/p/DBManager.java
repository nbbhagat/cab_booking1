package p;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.io.Serializable;


public class DBManager{
	public  void SerializeUserMap(HashMap<Integer, User> userMap)
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
	public  void SerializeDVMap(HashMap<String, String> dvMap)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("dvhashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(dvMap);
               oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in dvhashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
	public  void SerializePayMap(HashMap<Integer, Payment> payMap)
	{
        try
        {
               FileOutputStream fos =
                  new FileOutputStream("dvhashmap.ser");
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
	public  void SerializeRideMap(HashMap<Integer, Ride> rideMap)
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
	public  HashMap<Integer, User> DeserializeUserMap()
	{
		      HashMap<Integer, User> umap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("userhashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         umap = (HashMap) ois.readObject();
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
	public  HashMap<Integer, Ride> DeserializeRideMap()
	{
		      HashMap<Integer, Ride> rmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("ridehashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         rmap = (HashMap) ois.readObject();
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

	public  HashMap<Integer, Payment> DeserializePayMap()
	{
		      HashMap<Integer, Payment> pmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("ridehashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         pmap = (HashMap) ois.readObject();
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
	public  HashMap<String, String> DeserializeDVMap()
	{
		      HashMap<String, String> dvmap = null;
		      try
		      {
		         FileInputStream fis = new FileInputStream("ridehashmap.ser");
		         ObjectInputStream ois = new ObjectInputStream(fis);
		         dvmap = (HashMap) ois.readObject();
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


