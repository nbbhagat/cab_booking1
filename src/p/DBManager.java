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

		
	}
}


