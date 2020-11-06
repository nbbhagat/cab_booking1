package p;
public class Vehicle {
    int vId;
    String type;
    int capacity;
    int bootSpace;
    int baseFare;
    float factor;
    public Vehicle(int vId, String type, int capacity, int bootSpace, int baseFare, float factor) {
        this.vId = vId;
        this.type = type;
        this.capacity = capacity;
        this.bootSpace = bootSpace;
        this.baseFare = baseFare;
        this.factor = factor;
    }
}
