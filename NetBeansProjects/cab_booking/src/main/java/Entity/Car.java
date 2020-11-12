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
public class Car extends Vehicle implements java.io.Serializable{
    
    public int capacity=4;
    public double baseFare=150;
    public double factor=7;
    public void setId(){
        vId="VC"+UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
    	return "VId: "+this.getvId() +" capacity: "+this.capacity +" base fare: "+this.baseFare+" factor : "+this.factor;
    }

}
