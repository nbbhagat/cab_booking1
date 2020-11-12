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
public class Auto extends Vehicle implements java.io.Serializable{
    
    public int capacity=3;
    public double baseFare=100;
    public double factor=5;
    public void setId(){
        vId="VA"+UUID.randomUUID().toString();
    }
    @Override
    public String toString() {
    	return "VId: "+this.getvId() +" capacity: "+this.capacity +" base fare: "+this.baseFare+" factor : "+this.factor;
    }
}
