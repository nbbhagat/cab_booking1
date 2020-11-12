/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.UUID;

/**
 *
 * @author namrata
 */
public class Passenger extends User{
     public Passenger(String name, String phoneNo,String password,Location location){
        super(name,phoneNo,password,location);
        this.userId="P"+UUID.randomUUID().toString();
    }
    @Override
    public String toString(){
        return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location;
    }
}
