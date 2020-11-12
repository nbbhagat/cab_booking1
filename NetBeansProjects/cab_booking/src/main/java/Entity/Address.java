package entity;
public class Address {
    int blockNo;
    String street;
    String city;
    String state;
    String country;
    int pinCode;
    public Address(){
        
    }
    public Address(int blockNo, String street, String city, String state, String country, int pinCode){
        this.blockNo=blockNo;
        this.street=street;
        this.city=city;
        this.state=state;
        this.country=country;
        this.pinCode=pinCode;
    }
    @Override
    public String toString(){
        return "\r\n Address -> " +blockNo+", "+street+", "+city+", "+state+", "+country+ ", "+pinCode;
    }
}
