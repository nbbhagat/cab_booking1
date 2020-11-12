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
public class Driver extends User{
        public boolean status;
        public Driver(String name, String phoneNo,String password,Location location, boolean status,Vehicle vehicle){
                super(name,phoneNo,password,location);
                this.status=status;
                this.userId="D"+UUID.randomUUID().toString();
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus() {
            this.status = !status;
        }

        @Override
        public String toString(){
            return "name:-> "+name+", phoneNo-> "+phoneNo+", avgRating-> "+avgRating+", location-> "+location;
        }
}

